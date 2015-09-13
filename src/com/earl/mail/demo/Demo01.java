package com.earl.mail.demo;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		
		//�����ʼ�������
		//��һ����Ҫ����������Message��
		//MessageΪ�����࣬������Ҫnew����ʵ�ֶ���MimeMessage
		//��ʱMimeMessage�Ĺ��췽����Ҫһ��Session����
		//ͨ��Session�ľ�̬�������һ��session����
		//Session�Ļ�ȡ��Ҫ����һЩ����
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");//�����ʼ�����Э��
		props.setProperty("mail.smtp.auth", "false");//�����ʼ��������Ƿ���Ҫ��֤
		Session session=Session.getDefaultInstance(props);
		session.setDebug(true);
		
		Message message=new MimeMessage(session);
		//�����ʼ�����
		message.setSubject("earl's mail");
		message.setText("EARL'S FRIST JAVAMAIL");
		message.setFrom(new InternetAddress("earlyuan@163.com"));
		
		
		//�ڶ�����Ҫ�з�������Transport
		//��session�л�ȡ��������
		Transport transport=session.getTransport();
		//�������ӵĲ���������ĵ������������ͷ��û���һ��Ҫ��message.setFrom�еı���һ�£�����ͻᱨ��
		transport.connect("smtp.163.com", 25, "earlyuan", "yy900731");
		//�����ʼ�������Ϊ�ռ�������
		transport.sendMessage(message, new Address[]{new InternetAddress("yy28458@126.com")});
		transport.close();
		
	}

}
