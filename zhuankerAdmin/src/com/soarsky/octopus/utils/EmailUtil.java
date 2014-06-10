package com.soarsky.octopus.utils;

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
	
	private static String USERNAME="service@zhuanker.cn";  //发送邮件用户名
	private static String PASSWORD="911911wy";  //发送邮件用户的密码
	private static String HOST="smtp.exmail.qq.com";
	private static String PORT="465";
//	
	
//	private static String USERNAME="627540599@qq.com";  //发送邮件用户名
//	private static String PASSWORD="xpp9598929";  //发送邮件用户的密码
//	private static String HOST="smtp.qq.com";
//	private static String PORT="25";
	
	
	 public static void main(String[] args) throws AddressException, MessagingException {
		 EmailUtil.sendEmail("cll219@qq.com","122##$%");
		
	}	
	
	 /**
	  * 
	  * @param customerEmail  目标邮件地址
	  * @param content   内容
	  * @throws AddressException
	  * @throws MessagingException
	  */
	public static void sendEmail(String customerEmail,String content) throws AddressException, MessagingException{
		MyAuthenticator auth = new MyAuthenticator(USERNAME,PASSWORD);
		Properties  props =new Properties();
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.auth", "true");// 使用smtp身份验证 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		
		Session session = Session.getInstance(props,auth);
		session.setDebug(false);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(USERNAME));
		InternetAddress[] address = {new InternetAddress(customerEmail)};
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject("赚客网安装分享");
		msg.setSentDate(new Date());
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setText("亲爱的【"+customerEmail+"】：\r\n"+
				 "    您的赚客网app下载地址是：【"+content+"】,请牢记，再次感谢您对赚客的支持，祝您愉快，谢谢！\r\n"+
				 "（这是一封自动发出的email，请勿回复）");
	
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);
		msg.setContent(mp);
		Transport.send(msg);
		System.out.println("发送邮件完成");
		
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
