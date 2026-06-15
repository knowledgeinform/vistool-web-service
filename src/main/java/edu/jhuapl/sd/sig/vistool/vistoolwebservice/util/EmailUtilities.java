package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilities{
	@Autowired private JavaMailSender emailSender;
	@Autowired private SecurityUtilities securityUtilities;
	
	public void sendEmail(String message) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(securityUtilities.getCurrentUser().get().getEmail());
        email.setTo("vistool-support@jhuapl.edu");
        /*
        * FIXME: sendEmail(@NonNull String from, @NonNull String to, @NonNull String subject, @NonNull String message)
        * IST Common library with generic EmailUtilities class
        */

        email.setSubject("IST: Vistool Support Request");
        email.setText(message);
        emailSender.send(email);
	}
}
