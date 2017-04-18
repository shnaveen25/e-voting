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
		
		builder.append("Link: <a href='http://localhost:3000'>Click here to Login.</a><br>");
		
		return builder.toString();
		
	}  // End method
	
	public String getElectorRegisteredMail(String name, String electorId){
		StringBuilder builder = new StringBuilder();
		
		builder.append("<html><body style='max-width: 1024px; margin: 11px auto; width:90%'>");

		builder.append("<div style='border:2px solid #4285f4; padding:10px;'>");
		
		builder.append("<p><i>Dear "+name);
		
		builder.append(" ,<br>Your are registered as Elector");
		
		builder.append("<br>");
		
		builder.append("Your Elector id : "+electorId+"<br>");
		
		builder.append("Link: <a href='http://localhost:3000'>Click here to Login.</a><br>");
		
		return builder.toString();
	}
}