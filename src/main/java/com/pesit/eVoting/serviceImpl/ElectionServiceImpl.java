package com.pesit.eVoting.serviceImpl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pesit.eVoting.constants.Constants;
import com.pesit.eVoting.dto.ElectionDto;
import com.pesit.eVoting.notification.MailService;
import com.pesit.eVoting.service.AssemblyStatesService;
import com.pesit.eVoting.service.ElectionService;
import com.pesit.eVoting.sql.dao.ElectionDAO;
import com.pesit.eVoting.sql.dao.ElectionPollDAO;
import com.pesit.eVoting.sql.dao.ElectorDAO;
import com.pesit.eVoting.sql.domain.Election;
import com.pesit.eVoting.sql.domain.Elector;

@Service("ElectionService")
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionDAO electionDao;

	@Autowired
	private ElectorDAO electorDao;

	@Autowired
	private ElectionPollDAO electionPollDao;

	@Autowired
	private AssemblyStatesService assemblyStateService;

	@Autowired
	private MailService mailService;

	@Override
	@Transactional
	public String addUpcomingElection(String electionFor, long stateId, String electionDate) {

		Timestamp currentDate = new Timestamp(new Date().getTime());

		Election electionToBeSaved = new Election();
		electionToBeSaved.setElectionFor(electionFor);
		electionToBeSaved.setStateId(stateId);
		electionToBeSaved.setElectionDate(electionDate);
		electionToBeSaved.setStatus(Constants.UPCOMING_ELECTION);
		electionToBeSaved.setCreatedDate(currentDate);

		try {
			electionDao.save(electionToBeSaved);

			List<Elector> electorListFromDb = electorDao.findAll();

			new Thread(() -> {

				for (Elector eachElector : electorListFromDb) {
					if (eachElector.getStatus().equals("active")
							&& electionToBeSaved.getStateId() == eachElector.getStateId()) {
						try {
							mailService.sendMailHtml("E-VOTING: Upcoming Election Details",
									mailService.getElectionAddedMail(eachElector.getName(),
											electionToBeSaved.getElectionDate(), electionToBeSaved.getElectionFor()),
									eachElector.getEmail(), Constants.FROM_MAIL);
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}).start();

			return Constants.SUCCESS;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public List<ElectionDto> getUpcomingElections() {

		List<ElectionDto> electionList = new ArrayList<ElectionDto>();

		List<Election> electionsFromDb = electionDao.findByUpcomingElection();

		for (Election eachElection : electionsFromDb) {
			String state = assemblyStateService.getAssemblyStatesById(eachElection.getStateId());
			ElectionDto election = new ElectionDto(eachElection);
			election.setStateName(state);
			electionList.add(election);
		}

		return electionList;
	}
	
	@Override
	public List<ElectionDto> getPastElections() {
		List<ElectionDto> electionList = new ArrayList<ElectionDto>();

		List<Election> electionsFromDb = electionDao.findPastElection();

		for (Election eachElection : electionsFromDb) {
			String state = assemblyStateService.getAssemblyStatesById(eachElection.getStateId());
			ElectionDto election = new ElectionDto(eachElection);
			election.setStateName(state);
			electionList.add(election);
		}

		return electionList;
	}

	@Override
	public List<ElectionDto> getUpcomingOrOnGoingElection() {
		
		List<ElectionDto> electionList = new ArrayList<ElectionDto>();

		List<Election> electionsFromDb = electionDao.findByUpComingOrOnGoingElection();

		for (Election eachElection : electionsFromDb) {
			String state = assemblyStateService.getAssemblyStatesById(eachElection.getStateId());
			ElectionDto election = new ElectionDto(eachElection);
			election.setStateName(state);
			electionList.add(election);
		}

		return electionList;
	}

	@Override
	public List<ElectionDto> getUpcomingElectionForState(long id) {

		List<ElectionDto> electionList = new ArrayList<ElectionDto>();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date).toString();

		List<Election> electionsFromDb = electionDao.findByStateUpcomingElection(id,currentDate);

		for (Election eachElection : electionsFromDb) {
			ElectionDto election = new ElectionDto(eachElection);
			electionList.add(election);
		}

		return electionList;
	}

	@Override
	@Transactional
	public ElectionDto getElectionById(long id) {

		return new ElectionDto(electionDao.findById(id));

	}

	@Override
	public ElectionDto getCurrentElection(long stateId, String date) {

		ElectionDto currentElection = null;

		Election electionformDb = electionDao.findByCurrentElection(stateId, date);

		if (electionformDb != null)
			currentElection = new ElectionDto(electionformDb);

		return currentElection;

	}

	@Override
	@Transactional
	public String startOrStopElection(long id, String status) {

		Election election = electionDao.findById(id);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date).toString();

		System.out.println("ele date" + election.getElectionDate());
		System.out.println("current date" + currentDate);

		if (election != null) {
			if (election.getElectionDate().equals(currentDate)) {
				election.setStatus(status);
				electionDao.save(election);
				return "Election has been "+status;
			} else {
				return "You cannot start election before prefered date..!!";
			}
		} else {
			return "No Election found..!!";
		}
	}

	

}
