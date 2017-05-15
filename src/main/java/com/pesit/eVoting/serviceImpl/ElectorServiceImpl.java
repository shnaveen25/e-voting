package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.Util.ElectorIdGenerator;
import com.pesit.eVoting.Util.PasswordUtil;
import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.ElectorDto;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.AssemblyDistrictService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectorService;
import com.pesit.eVoting.sql.dao.ElectorDAO;
import com.pesit.eVoting.sql.dao.VotersApplicationsDAO;
import com.pesit.eVoting.sql.domain.Elector;
import com.pesit.eVoting.sql.domain.VotersApplications;

@Service("ElectorService")
public class ElectorServiceImpl implements ElectorService {

	String electorID = null;
	String password = null;

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
	@Transactional
	public String registerVoter(long id) {

		VotersApplications applicationDetails = voterApplicationDao.findById(id);

		if (applicationDetails != null) {

			Elector electorToBeSaved = electorDao.findByAadharNumber(applicationDetails.getAadhar());

			if (electorToBeSaved == null) {
				String state = assemblyStateService.getAssemblyStatesById(applicationDetails.getStateId());
				String district = assemblyDistricte.getAssemblyDistrictById(applicationDetails.getDistrictId());
				this.electorID = ElectorIdGenerator.generateElectorId(state, district,
						applicationDetails.getAadhar());
				this.password = PasswordUtil.randomAplhaNumGen(6);
				Timestamp currentDate = new Timestamp(new Date().getTime());

				electorToBeSaved = new Elector();
				electorToBeSaved.setApplicationid(id);
				electorToBeSaved.setElectorId(electorID);
				electorToBeSaved.setPassword(password);
				electorToBeSaved.setCreatedDate(currentDate);
				electorToBeSaved.setStatus("active");
				electorToBeSaved.setStateId(applicationDetails.getStateId());
				electorToBeSaved.setDistrictId(applicationDetails.getDistrictId());
				electorToBeSaved.setAssemblyId(applicationDetails.getAssemblyId());

			}			
			electorToBeSaved.setName(applicationDetails.getName());
			electorToBeSaved.setDob(applicationDetails.getDob());
			electorToBeSaved.setGender(applicationDetails.getGender());
			electorToBeSaved.setMobile(applicationDetails.getMobile());
			electorToBeSaved.setEmail(applicationDetails.getEmail());
			electorToBeSaved.setAadhar(applicationDetails.getAadhar());
			electorToBeSaved.setAddress(applicationDetails.getAddress());
			electorToBeSaved.setLandMark(applicationDetails.getLandMark());
			electorToBeSaved.setPinCode(applicationDetails.getPinCode());

			electorDao.saveOrUpdate(electorToBeSaved);

			if(applicationDetails.getAppliedFor().equals(Constants.INCLUDING)){
				new Thread(() -> {
					try {
						mailService.sendMailHtml("E-VOTING: Application Status",
								mailService.getElectorRegisteredMail(applicationDetails.getName(), electorID, password),
								applicationDetails.getEmail(), Constants.FROM_MAIL);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
			}

			return Constants.SUCCESS;
		} else {
			return "Application not found";
		}
	}

	@Override
	public ElectorDto authonticateActiveElector(String electorId, String password) {

		ElectorDto authorizedElector = null;

		Elector electorFromDb = electorDao.findByElectorIdAndPassord(electorId, password);

		if (electorFromDb != null && electorFromDb.getStatus().equals(Constants.ACTIVE)) {
			authorizedElector = new ElectorDto(electorFromDb);
			return authorizedElector;
		}
		return authorizedElector;
	}

	@Override
	@Transactional
	public String changeElectorPassword(String email) {

		Elector isExistingElector = electorDao.findByEmail(email);

		if (isExistingElector != null) {
			String randomPasword = PasswordUtil.randomAplhaNumGen(6);

			isExistingElector.setPassword(randomPasword);
			electorDao.saveOrUpdate(isExistingElector);

			new Thread(() -> {
				try {
					mailService.sendMailHtml("E-VOTING: Elector Re-set Password",
							mailService.getResetPasswordBody(isExistingElector.getName(),
									isExistingElector.getPassword()),
							isExistingElector.getEmail(), Constants.FROM_MAIL);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();

			return "Password has been sent to given Email..";
		} else {
			return "Email not registered with us";
		}

	}

	@Override
	public List<ElectorDto> getAllElectorsOfAss(long assId) {
		List<ElectorDto> respListOfElectors = null;

		List<Elector> electorFromDb = electorDao.findAllElectorByAssId(assId);

		if (electorFromDb != null) {
			respListOfElectors = new ArrayList<ElectorDto>();
			for (Elector eachElector : electorFromDb) {
				ElectorDto elector = new ElectorDto(eachElector);
				respListOfElectors.add(elector);
			}
		}
		return respListOfElectors;
	}

	@Override
	@Transactional
	public String activeOrInactiveElector(long id) {

		Elector isExistingElector = electorDao.findById(id);

		if (isExistingElector != null) {

			if (isExistingElector.getStatus().equals(Constants.ACTIVE)) {
				isExistingElector.setStatus(Constants.INACTIVE);
			} else {
				isExistingElector.setStatus(Constants.ACTIVE);
			}
			electorDao.saveOrUpdate(isExistingElector);
			return isExistingElector.getName() + " has been " + isExistingElector.getStatus() + " to vote";
		}
		return "No user found";

	}

	@Override
	public String getOTP(String electorId) {

		Elector electorFromDb = electorDao.findByElectorID(electorId);

		if (electorFromDb != null) {
			String OTP = PasswordUtil.randomAplhaNumGen(5);

			new Thread(() -> {
				try {
					mailService.sendMailHtml("E-VOTING: Elector Re-set Password",
							mailService.getOTPBody(electorFromDb.getName(), OTP), electorFromDb.getEmail(),
							Constants.FROM_MAIL);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}).start();

			return OTP;
		}
		return null;
	}

	@Override
	public ElectorDto getElectorProfileByEleId(String electorId) {

		ElectorDto elector = null;

		Elector electorFromDb = electorDao.findByElectorID(electorId);

		if (electorFromDb != null) {
			elector = new ElectorDto(electorFromDb);
		}
		return elector;
	}

}
