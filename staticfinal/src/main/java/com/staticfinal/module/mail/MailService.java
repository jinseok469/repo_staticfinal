package com.staticfinal.module.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.staticfinal.module.user.UserDto;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender javaMailSender;

//	회원가입 축하 메일
    public void sendMailWelcome(UserDto userDto) throws Exception{

    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo(userDto.getEmail()); 
    	mimeMessageHelper.setSubject(userDto.getTpTitle());
    	mimeMessageHelper.setText("회원가입을 축하합니다!", true); 
    	javaMailSender.send(mimeMessage);
    	
}
}