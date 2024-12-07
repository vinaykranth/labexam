package klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {
	
	@Autowired
	JavaMailSender mailSender;
	
	public String sendEmail(String toemail, String subject, String message)
	{
		try
		{
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("drkpn2019@gmail.com");
			mailMessage.setTo(toemail);
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			
			mailSender.send(mailMessage);
			return "Email sent successfully";
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
