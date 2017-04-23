package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.VotersApplicationsDto;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.AssemblyConstituencyService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.VotersApplicationsService;
import com.pesit.eVoting.sql.dao.VotersApplicationsDAO;
import com.pesit.eVoting.sql.domain.VotersApplications;

@Service("VotersApplications")
public class VotersApplicationsServiceImpl implements VotersApplicationsService {

	@Autowired
	private VotersApplicationsDAO voterApplicationDao;

	@Autowired
	private AssemblyStatesService assemblyStateService;

	@Autowired
	private AssemblyDistrictService assemblyDistrictService;

	@Autowired
	private AssemblyConstituencyService assemblyConstituencyService;
	
	@Autowired
	private MailService mailService;

	@Override
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto, long appliedBy) {

		VotersApplications isApplicationExists = voterApplicationDao.findByAadhar(voterApplicationDto.getAadhar());
		
			if(isApplicationExists == null){
				Timestamp currentDate = new Timestamp(new Date().getTime());
				isApplicationExists = new VotersApplications();
				isApplicationExists.setStateId(voterApplicationDto.getStateId());
				isApplicationExists.setDistrictId(voterApplicationDto.getDistrictId());
				isApplicationExists.setAssemblyId(voterApplicationDto.getAssemblyId());
				isApplicationExists.setName(voterApplicationDto.getName() + " " + voterApplicationDto.getSurName());
				isApplicationExists.setDob(voterApplicationDto.getDob());
				isApplicationExists.setGender(voterApplicationDto.getGender());
				isApplicationExists.setMobile(voterApplicationDto.getMobile());
				isApplicationExists.setEmail(voterApplicationDto.getEmail());
				isApplicationExists.setAadhar(voterApplicationDto.getAadhar());
				isApplicationExists.setAddress(voterApplicationDto.getArea() + " , " + voterApplicationDto.getStreet());
				isApplicationExists.setLandMark(voterApplicationDto.getLandMark());
				isApplicationExists.setPinCode(voterApplicationDto.getPinCode());
				isApplicationExists.setApplicationStatus("pending");
				isApplicationExists.setAddedBy(appliedBy);
				isApplicationExists.setAppliedFor(voterApplicationDto.getAppliedFor());
				isApplicationExists.setCreatedDate(currentDate);
	
				voterApplicationDao.saveOrUpdate(isApplicationExists);
				
				new Thread(() -> {
	
					try {
						mailService.sendMailHtml(
								"E-VOTING: Application Status", mailService.getNewApplicationMailBody(
										voterApplicationDto.getName()),
								Constants.FROM_MAIL, Constants.FROM_MAIL);
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
				}).start();
		
				return Constants.SUCCESS;
			} else {
				return "Applicaton already submitted";
			}
		
	}

	@Override
	public List<VotersApplicationsDto> getUserAppliedApplications(long id) {

		List<VotersApplicationsDto> responseUserApplications = new ArrayList<VotersApplicationsDto>();

		List<VotersApplications> userApplicationsFromDb = voterApplicationDao.findByUserId(id);

		if (userApplicationsFromDb != null) {
			for (VotersApplications indudivalApplication : userApplicationsFromDb) {
				String stateName = assemblyStateService.getAssemblyStatesById(indudivalApplication.getStateId());
				String districtName = assemblyDistrictService.getAssemblyDistrictById(indudivalApplication.getDistrictId());
				String assemblyName = assemblyConstituencyService.getAssemblysById(indudivalApplication.getAssemblyId());
				// AssemblyDistrict district
				VotersApplicationsDto application = new VotersApplicationsDto(indudivalApplication);
				application.setStateName(stateName);
				application.setDistrictName(districtName);
				application.setAssemblyName(assemblyName);
				
				responseUserApplications.add(application);
			}
		}

		return responseUserApplications;
	}

	@Override
	public String deleteUserApplication(long id) {
		
		VotersApplications applicationFromDb = voterApplicationDao.findById(id);
		
		if(applicationFromDb != null){
			voterApplicationDao.delete(applicationFromDb);
			return Constants.SUCCESS;
		} else{
			return "Applicaion Not Found";
		}
		
	}

	@Override
	public List<VotersApplicationsDto> getAllPendingApplications() {
		List<VotersApplicationsDto> responseApplications = new ArrayList<VotersApplicationsDto>();
		List<VotersApplications> userApplicationsFromDb = voterApplicationDao.findPendingApplications();
		System.out.println("User Application : " +userApplicationsFromDb);
		if (userApplicationsFromDb != null) {
			for (VotersApplications indudivalApplication : userApplicationsFromDb) {
				String stateName = assemblyStateService.getAssemblyStatesById(indudivalApplication.getStateId());
				String districtName = assemblyDistrictService.getAssemblyDistrictById(indudivalApplication.getDistrictId());
				String assemblyName = assemblyConstituencyService.getAssemblysById(indudivalApplication.getAssemblyId());
				// AssemblyDistrict district
				VotersApplicationsDto application = new VotersApplicationsDto(indudivalApplication);
				application.setStateName(stateName);
				application.setDistrictName(districtName);
				application.setAssemblyName(assemblyName);
				
				responseApplications.add(application);
			}
		}
		
		return responseApplications;
	}

	@Override
	public void updateApplicationStatus(long id, String comment, String status) {
		
		VotersApplications applicationFromDb = voterApplicationDao.findById(id);
		
		applicationFromDb.setApplicationStatus(status);
		applicationFromDb.setComment(comment);
		System.out.println("ssssssssssssssssssssssssss :"+applicationFromDb);
		voterApplicationDao.saveOrUpdate(applicationFromDb);

	}
}
