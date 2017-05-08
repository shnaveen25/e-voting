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

		if(isAadharExist != null && isAadharExist.getAadhar() != isExistingApplication.getAadhar()){
			return "Application already exist...!!";
		}
		
		Timestamp currentDate = new Timestamp(new Date().getTime());
		if (isExistingApplication == null) {
			isExistingApplication = new VotersApplications();
			isExistingApplication.setStateId(voterApplicationDto.getStateId());
			isExistingApplication.setDistrictId(voterApplicationDto.getDistrictId());
			isExistingApplication.setAssemblyId(voterApplicationDto.getAssemblyId());
			isExistingApplication.setCreatedDate(currentDate);
			isExistingApplication.setAppliedFor(Constants.INCLUDING);
		} else {
			isExistingApplication.setAppliedFor(Constants.EDITING);
		}
		isExistingApplication.setApplicationStatus("pending");
		isExistingApplication.setName(voterApplicationDto.getName() + " " + voterApplicationDto.getSurName());
		isExistingApplication.setDob(voterApplicationDto.getDob());
		isExistingApplication.setGender(voterApplicationDto.getGender());
		isExistingApplication.setMobile(voterApplicationDto.getMobile());
		isExistingApplication.setEmail(voterApplicationDto.getEmail());
		isExistingApplication.setAadhar(voterApplicationDto.getAadhar());
		isExistingApplication.setAddress(voterApplicationDto.getArea() + " , " + voterApplicationDto.getStreet());
		isExistingApplication.setLandMark(voterApplicationDto.getLandMark());
		isExistingApplication.setPinCode(voterApplicationDto.getPinCode());

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

	@Override
	@Transactional
	public void updateApplicationStatus(long id, String comment, String status) {

		VotersApplications applicationFromDb = voterApplicationDao.findById(id);

		applicationFromDb.setApplicationStatus(status);
		applicationFromDb.setComment(comment);
		voterApplicationDao.saveOrUpdate(applicationFromDb);

	}
}
