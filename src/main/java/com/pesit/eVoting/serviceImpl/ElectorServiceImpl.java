package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.Util.ElectorIdGenerator;
import com.pesit.eVoting.Util.PasswordUtil;
import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectorService;
import com.pesit.eVoting.sql.dao.ElectorDAO;
import com.pesit.eVoting.sql.dao.VotersApplicationsDAO;
import com.pesit.eVoting.sql.domain.Elector;
import com.pesit.eVoting.sql.domain.VotersApplications;

@Service("ElectorService")
public class ElectorServiceImpl implements ElectorService{

	@Autowired
	private VotersApplicationsDAO voterApplicationDao;
	
	@Autowired
	private AssemblyStatesService assemblyStateService;
	
	@Autowired
	private AssemblyDistrictService assemblyDistricte;
	
	@Autowired
	private ElectorDAO electorDao;
	
	@Autowired
	private MailService mailService;

	
	@Override
	public String registerVoter(long id) {
		
		VotersApplications applicationDetails=  voterApplicationDao.findById(id);
		
		if(applicationDetails != null){
			
			Elector electorToBeSaved = electorDao.findByAadharNumber(applicationDetails.getAadhar());
			
			if(electorToBeSaved == null){
				String state = assemblyStateService.getAssemblyStatesById(applicationDetails.getStateId());
				String district = assemblyDistricte.getAssemblyDistrictById(applicationDetails.getDistrictId());		
				String electorID = ElectorIdGenerator.generateElectorId(state, district, applicationDetails.getAadhar());		
				String password = PasswordUtil.randomAplhaNumGen(6);
				Timestamp currentDate = new Timestamp(new Date().getTime());
				
				electorToBeSaved = new Elector();		
				electorToBeSaved.setApplicationid(id);
				electorToBeSaved.setElectorId(electorID);
				electorToBeSaved.setStateId(applicationDetails.getStateId());
				electorToBeSaved.setDistrictId(applicationDetails.getDistrictId());
				electorToBeSaved.setAssemblyId(applicationDetails.getAssemblyId());
				electorToBeSaved.setName(applicationDetails.getName());
				electorToBeSaved.setDob(applicationDetails.getDob());
				electorToBeSaved.setGender(applicationDetails.getGender());
				electorToBeSaved.setMobile(applicationDetails.getMobile());
				electorToBeSaved.setEmail(applicationDetails.getEmail());
				electorToBeSaved.setAadhar(applicationDetails.getAadhar());
				electorToBeSaved.setAddress(applicationDetails.getAddress());
				electorToBeSaved.setLandMark(applicationDetails.getLandMark());
				electorToBeSaved.setPinCode(applicationDetails.getPinCode());
				electorToBeSaved.setPassword(password);
				electorToBeSaved.setCreatedDate(currentDate);
				electorToBeSaved.setStatus("active");
				
				electorDao.save(electorToBeSaved);
				
				new Thread( () -> {
					try {
						mailService.sendMailHtml("E-VOTING: Application Status",
								mailService.getElectorRegisteredMail(applicationDetails.getName(), electorID, password),
								applicationDetails.getEmail() , Constants.FROM_MAIL);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
				
				return Constants.SUCCESS;
			}else{
				return "You are already registered";
			}		
		}else{
			return "Application not found";
		}
	}

}
