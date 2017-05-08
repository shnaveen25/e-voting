package com.pesit.eVoting.notification;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private static final Logger LOG = Logger.getLogger(MailService.class);

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * This method will send compose and send the message
	 */
	public void sendMail(String subject, String body, String reciver, String from) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(reciver);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error" + e);
		}
	}

	@Async
	public void sendMailHtml(final String subject, final String body, final String reciver, final String from)
			throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setTo(reciver);
		helper.setSubject(subject);
		helper.setText(body, true);
		javaMailSender.send(message);

	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @param hrType
	 * @param name
	 * @return
	 */
	public String getAccountCreatedMailBody(String email, String name) {

		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		builder.append("<p><i>Dear " + name);

		builder.append(" ,<br>Your registration is successiful");

		builder.append("<br>");

		builder.append("Your username: " + email + "<br>");

		builder.append("Link: <a href='http://localhost:9000'>Click here to Login.</a><br>");

		return builder.toString();

	} // End method

	public String getNewApplicationMailBody(String name , String appliedFor) {

		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		builder.append("<p><i>Dear <b>Admin</b>");

		builder.append(
				" ,<br>New Application has bee arrived for registration as a Elector with the fallowing details");

		builder.append("<br>");

		builder.append("Application Name:<b> " + name + "</b><br>");
		
		builder.append("Applied for :<b> " + appliedFor + "</b><br>");

		builder.append("Link: <a href='http://localhost:9000'>Click here to Login.</a><br>");

		return builder.toString();

	} // End method

	/**
	 * 
	 * This Service composes the body for accepted applications
	 * 
	 * @param name
	 * @param electorId
	 * @return
	 */
	public String getElectorRegisteredMail(String name, String electorId, String password) {
		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		builder.append("<p>Dear <b>" + name + "</b>");

		builder.append(" ,<br>Your application has been accepted for elector.");

		builder.append("<br>");

		builder.append("Elector id : <b>" + electorId + "</b>");

		builder.append("<br>Password : <b>" + password + "</b>");

		builder.append("<br>Please keep elector id number and password for voting ");

		builder.append("<br>Thank you and Regards,");

		builder.append("<br><a href='http://localhost:3000'>Team eVoting</a><br>");

		return builder.toString();
	}

	public String getParticipantRegisteredMail(String name, String state, String district, String assembly,
			String post , String date) {
		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		// builder.append("<p>Dear <b>"+partyName+"</b>");

		builder.append("<br>As per your recent application, We have registered the participant with a bellow details");

		builder.append("<br>");
		builder.append("<br>");

		builder.append("Name : <b>" + name.toUpperCase() + "</b><br>");

		builder.append("State : <b>" + state.toUpperCase() + "</b><br>");

		builder.append("District : <b>" + district.toUpperCase() + "</b><br>");

		builder.append("Assembly : <b>" + assembly.toUpperCase() + "</b><br>");

		builder.append("Post : <b>" + post.toUpperCase() + "</b><br>");
		
		builder.append("Election Date : <b>" + date + "</b><br>");

		builder.append("<br>Regards,");

		builder.append("<br><a href='http://localhost:3000'>Team eVoting</a><br>");

		return builder.toString();
	}

	public String getElectionAddedMail(String name, String date, String electionFor) {
		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		builder.append("<p>Dear <b>" + name + "</b>");

		builder.append(" ,<br>We Have added election for <b>" + electionFor);
		
		builder.append("</b> in your respected Assembly dated on <b>" + date + "</b>");

		builder.append("<br>Please login with your credential to vote on " + date);
		
		builder.append("<br>");

		builder.append("<br>Thank you and Regards,");

		builder.append("<br><a href='http://localhost:3000'>Team eVoting</a><br>");

		return builder.toString();
	}
	
	public String getVotiedSuccessBody(String name) {

		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		builder.append("<p><i>Dear <b>"+name+"</b>");

		builder.append("<br> Thank you for participating in eVoting Process");

		builder.append("<br> Your choice has been recorded..");

		builder.append("<br>");

		builder.append("<br>Thank you and Regards,");

		builder.append("<br><a href='http://localhost:3000'>Team eVoting</a><br>");

		return builder.toString();

	} // End method
	
	public String getResetPasswordBody(String name , String password) {

		StringBuilder builder = new StringBuilder();

		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");

		builder.append("<p><i>Dear <b>"+name+"</b>");

		builder.append("<br> As per your request we have update you password..");

		builder.append("<br> Please login with bellow credentials");

		builder.append("<br> Password : "+password);
		
		builder.append("<br>");
		
		builder.append("<br>Thank you and Regards,");

		builder.append("<br><a href='http://localhost:3000'>Team eVoting</a><br>");

		return builder.toString();

	} // End method
	

}