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
	 * */
	public void sendMail(String subject, String body, String reciver,
			String from) {
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
	public void sendMailHtml(final String subject, final String body,
			final String reciver, final String from) throws MessagingException {

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
	public String getAccountCreatedMailBody(String email, String name)  {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");
		
		builder.append("<p><i>Dear "+name);
		
		builder.append(" ,<br>Your registration is successiful");
		
		builder.append("<br>");
		
		builder.append("Your username: "+email+"<br>");
		
		builder.append("Link: <a href='http://localhost:9000'>Click here to Login.</a><br>");
		
		return builder.toString();
		
	}  // End method
	
	/**
	 * 
	 * This Service composes the body for accepted applications
	 * 
	 * @param name
	 * @param electorId
	 * @return
	 */
	public String getElectorRegisteredMail(String name, String electorId, String password){
		StringBuilder builder = new StringBuilder();
		
		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");
		
		builder.append("<p>Dear <b>"+name+"</b>");
		
		builder.append(" ,<br>Your application has been accepted for elector.");
		
		builder.append("<br>");
		
		builder.append("Elector id : <b>"+electorId+"</b>");
		
		builder.append("<br>Password : <b>"+password+"</b>");
		
		builder.append("<br>Please keep elector id number and password for voting ");
		
		builder.append("<br>Thank you and Regards,");
		
		builder.append("<br>Team eVoting");
		
		builder.append("Link: <a href='http://localhost:9000'>Click here to Login.</a><br>");
		
		return builder.toString();
	}
	
	public String getParticipantRegisteredMail(String partyName, String name, 
			String state, String district, String assembly, String post){
		StringBuilder builder = new StringBuilder();
		
		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");
		
		builder.append("<p>Dear <b>"+partyName+"</b>");
		
		builder.append(" ,<br>As per your recent application, We have registered the participant with a bellow details");
		
		builder.append("<br>");
		
		builder.append("Name : <b>"+name+"</b><br>");
		
		builder.append("State : <b>"+state+"</b><br>");
		
		builder.append("District : <b>"+district+"</b><br>");
		
		builder.append("Assembly : <b>"+assembly+"</b><br>");
		
		builder.append("Post : <b>"+post+"</b><br>");
		
		builder.append("<br>Thank you and Regards,");
		
		builder.append("<br>Team eVoting");
		
		builder.append("Link: <a href='http://localhost:3000'>E-Voting</a><br>");
		
		return builder.toString();
	}
}