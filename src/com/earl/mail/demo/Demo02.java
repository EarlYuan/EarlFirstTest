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
		
		//发送邮件分两步
		//第一步：要有内容载体Message。
		//Message为抽象类，所以需要new它的实现对象MimeMessage
		//此时MimeMessage的构造方法需要一个Session对象。
		//通过Session的静态方法获得一个session对象。
		//Session的获取需要传入一些属性
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");//设置邮件传输协议
		props.setProperty("mail.smtp.auth", "true");//设置邮件服务器是否需要验证
		props.setProperty("mail.host", "smtp.163.com");
		//这里使用的是Authenticator的匿名内部类实现PasswordAuthentication来传递一个发件人的用户名和密码
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("earlyuan", "yy900731");
			}
		});
		session.setDebug(true);
		
		Message message=new MimeMessage(session);
		//设置邮件内容
		message.setSubject("earl's mail");
		message.setText("EARL'S SECOND JAVAMAIL");
		message.setFrom(new InternetAddress("earlyuan@163.com"));
		//设置收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("yy28458@126.com"));
		//设置抄送人
		message.setRecipient(Message.RecipientType.CC, new InternetAddress("605715613@qq.com"));
		
		//第二步：要有发送载体Transport
		//使用Transport的静态方法进行发送
		Transport.send(message);
		
	}

}
