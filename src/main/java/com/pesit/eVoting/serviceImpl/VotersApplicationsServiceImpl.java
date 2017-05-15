package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

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

/**
 * 
 * @author
 *
 */
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
	@Transactional
	public String registerForVoterApplication(VotersApplicationsDto voterApplicationDto, long appliedBy) {

		VotersApplications isAadharExist = voterApplicationDao.findByAadhar(voterApplicationDto.getAadhar());
		VotersApplications isExistingApplication = voterApplicationDao.findById(voterApplicationDto.getId());

		/*if(isAadharExist != null && isAadharExist.getAadhar() != isExistingApplication.getAadhar()){
			
		}*/
		
		Timestamp currentDate = new Timestamp(new Date().getTime());
		if (isExistingApplication == null) {
			if(isAadharExist != null)
				return "Application already exist...!!";
			
			isExistingApplication = new VotersApplications();
			isExistingApplication.setStateId(voterApplicationDto.getStateId());
			isExistingApplication.setDistrictId(voterApplicationDto.getDistrictId());
			isExistingApplication.setAssemblyId(voterApplicationDto.getAssemblyId());
			isExistingApplication.setCreatedDate(currentDate);
			isExistingApplication.setAppliedFor(Constants.INCLUDING);
		} 
		isExistingApplication.setApplicationStatus("pending");
		isExistingApplication.setName(voterApplicationDto.getName() + " " + voterApplicationDto.getSurName());
		isExistingApplication.setDob(voterApplicationDto.getDob());
		isExistingApplication.setGender(voterApplicationDto.getGender());
		isExistingApplication.setMobile(voterApplicationDto.getMobile());
		isExistingApplication.setEmail(voterApplicationDto.getEmail());
		isExistingApplication.setAadhar(voterApplicationDto.getAadhar() );
		isExistingApplication.setAddress(voterApplicationDto.getArea() + " , " + voterApplicationDto.getStreet());
		isExistingApplication.setLandMark(voterApplicationDto.getLandMark());
		isExistingApplication.setPinCode(voterApplicationDto.getPinCode());
		isExistingApplication.setAddedBy(appliedBy);

		voterApplicationDao.saveOrUpdate(isExistingApplication);

		new Thread(() -> {

			try {
				mailService.sendMailHtml("E-VOTING: Application Status", mailService
						.getNewApplicationMailBody(voterApplicationDto.getName(), voterApplicationDto.getAppliedFor()),
						Constants.FROM_MAIL, Constants.FROM_MAIL);
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}).start();

		return Constants.SUCCESS;

	}

	@Override
	public List<VotersApplicationsDto> getUserAppliedApplications(long id) {

		List<VotersApplicationsDto> responseUserApplications = new ArrayList<VotersApplicationsDto>();

		List<VotersApplications> userApplicationsFromDb = voterApplicationDao.findByUserId(id);

		if (userApplicationsFromDb != null) {
			for (VotersApplications indudivalApplication : userApplicationsFromDb) {
				String stateName = assemblyStateService.getAssemblyStatesById(indudivalApplication.getStateId());
				String districtName = assemblyDistrictService
						.getAssemblyDistrictById(indudivalApplication.getDistrictId());
				String assemblyName = assemblyConstituencyService
						.getAssemblysById(indudivalApplication.getAssemblyId());
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
	@Transactional
	public String deleteUserApplication(long id) {

		VotersApplications applicationFromDb = voterApplicationDao.findById(id);

		if (applicationFromDb != null) {
			voterApplicationDao.delete(applicationFromDb);
			return Constants.SUCCESS;
		} else {
			return "Applicaion Not Found";
		}

	}

	@Override
	public List<VotersApplicationsDto> getAllPendingApplications() {
		List<VotersApplicationsDto> responseApplications = new ArrayList<VotersApplicationsDto>();
		List<VotersApplications> userApplicationsFromDb = voterApplicationDao.findPendingApplications();
		System.out.println("User Application : " + userApplicationsFromDb);
		if (userApplicationsFromDb != null) {
			for (VotersApplications indudivalApplication : userApplicationsFromDb) {
				String stateName = assemblyStateService.getAssemblyStatesById(indudivalApplication.getStateId());
				String districtName = assemblyDistrictService
						.getAssemblyDistrictById(indudivalApplication.getDistrictId());
				String assemblyName = assemblyConstituencyService
						.getAssemblysById(indudivalApplication.getAssemblyId());
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

	/**
	 * 
	 * The service method is called when user clicks for a reject button
	 * of a voter application. 
	 * 
	 * @author 
	 * @param id
	 * @param comment
	 * @param status
	 * 
	 */
	@Override
	@Transactional
	public void updateApplicationStatus(long id, String comment, String status) {

		VotersApplications applicationFromDb = voterApplicationDao.findById(id);

		applicationFromDb.setApplicationStatus(status);
		applicationFromDb.setComment(comment);
		voterApplicationDao.saveOrUpdate(applicationFromDb);
		
		if(status.equals("rejected")){
			new Thread(() -> {
	
				try {
					mailService.sendMailHtml("E-VOTING: Application Status", mailService
							.getApplicationRejectBody(applicationFromDb.getName(), applicationFromDb.getComment()),
							applicationFromDb.getEmail(), Constants.FROM_MAIL);
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}).start();
		}

	}

	@Override
	@Transactional
	public String editRequestElectorApplication(VotersApplicationsDto voterApplicationDto, long appliedBy) {
		
		VotersApplications isExistingApplication = voterApplicationDao.findByAadhar(voterApplicationDto.getAadhar());
		
		if(isExistingApplication  != null ){
			isExistingApplication.setName(voterApplicationDto.getName());
			isExistingApplication.setDob(voterApplicationDto.getDob());
			isExistingApplication.setGender(voterApplicationDto.getGender());
			isExistingApplication.setMobile(voterApplicationDto.getMobile());
			isExistingApplication.setEmail(voterApplicationDto.getEmail());
			isExistingApplication.setAddress(voterApplicationDto.getArea());
			isExistingApplication.setLandMark(voterApplicationDto.getLandMark());
			isExistingApplication.setPinCode(voterApplicationDto.getPinCode());
			isExistingApplication.setAddedBy(appliedBy);
			isExistingApplication.setAppliedFor(Constants.EDITING);
			isExistingApplication.setApplicationStatus(Constants.PENDING);
			
			voterApplicationDao.saveOrUpdate(isExistingApplication);
			
			return "Application has been submited..";
		}
		return "NO Aplication Found";
	}

	@Override
	@Transactional
	public String requestToDeletElector(long aadhar) {
		
		VotersApplications isExistingApplication = voterApplicationDao.findByAadhar(aadhar);
		
		if(isExistingApplication  != null ){;
			isExistingApplication.setAppliedFor(Constants.DELETING);
			isExistingApplication.setApplicationStatus(Constants.PENDING);
			
			voterApplicationDao.saveOrUpdate(isExistingApplication);
			
			return "Deleting request has been submited..";
		}
		return "NO Aplication Found";
	}
}
