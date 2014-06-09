package com.institute.meeting.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailUtil {
	
	private String userName;  //发送邮件用户名
	private String password;  //发送邮件用户的密码
	private String host;
	private String port;
	
	
	 public static void main(String[] args) throws AddressException, MessagingException {
		 EmailUtil emailUtil = new EmailUtil();
		 emailUtil.sendEmail("cll219@qq.com","122##$%");
		
	}	
	
	public void sendEmail(String customerEmail,String backPsd) throws AddressException, MessagingException{
		MyAuthenticator auth = new MyAuthenticator(userName,password);
		Properties  props =new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");// 使用smtp身份验证 
		
		Session session = Session.getInstance(props,auth);
		session.setDebug(false);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] address = {new InternetAddress(customerEmail)};
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject("找回【"+customerEmail+"】在朵唯摇摇上的密码");
		msg.setSentDate(new Date());
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setText("亲爱的【"+customerEmail+"】：\r\n"+
				 "    您的密码是：【"+backPsd+"】,请牢记，再次感谢您对朵唯摇摇的支持，祝您摇奖愉快，谢谢！\r\n"+
				 "（这是一封自动发出的email，请勿回复）");
	
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);
		msg.setContent(mp);
		Transport.send(msg);
		System.out.println("发送邮件完成");
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}


class MyAuthenticator extends Authenticator {

	 String username, password;

    public MyAuthenticator(String username, String password) {
       this.username = username;
       this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() { 
       return new PasswordAuthentication(username, password);  
    }
}
