package com.soarsky.octopus.common.service;

public interface MailService {
	
	/**
	 * 发送邮件，使用线程池中线程完成发送任务
	 * @param targerEmail
	 * @param content
	 */
	 public void sendMail(String targerEmail,String content);

}
