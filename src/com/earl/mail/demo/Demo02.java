package com.earl.mail.demo;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo02 {

	public static void main(String[] args) throws Exception {
		
		//�����ʼ�������
		//��һ����Ҫ����������Message��
		//MessageΪ�����࣬������Ҫnew����ʵ�ֶ���MimeMessage
		//��ʱMimeMessage�Ĺ��췽����Ҫһ��Session����
		//ͨ��Session�ľ�̬�������һ��session����
		//Session�Ļ�ȡ��Ҫ����һЩ����
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");//�����ʼ�����Э��
		props.setProperty("mail.smtp.auth", "true");//�����ʼ��������Ƿ���Ҫ��֤
		props.setProperty("mail.host", "smtp.163.com");
		//����ʹ�õ���Authenticator�������ڲ���ʵ��PasswordAuthentication������һ�������˵��û���������
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("earlyuan", "yy900731");
			}
		});
		session.setDebug(true);
		
		Message message=new MimeMessage(session);
		//�����ʼ�����
		message.setSubject("earl's mail");
		message.setText("EARL'S SECOND JAVAMAIL");
		message.setFrom(new InternetAddress("earlyuan@163.com"));
		//�����ռ���
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("yy28458@126.com"));
		//���ó�����
		message.setRecipient(Message.RecipientType.CC, new InternetAddress("605715613@qq.com"));
		
		//�ڶ�����Ҫ�з�������Transport
		//ʹ��Transport�ľ�̬�������з���
		Transport.send(message);
		
	}

}
