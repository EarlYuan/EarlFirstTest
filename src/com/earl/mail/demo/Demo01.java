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
		
		//发送邮件分两步
		//第一步：要有内容载体Message。
		//Message为抽象类，所以需要new它的实现对象MimeMessage
		//此时MimeMessage的构造方法需要一个Session对象。
		//通过Session的静态方法获得一个session对象。
		//Session的获取需要传入一些属性
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");//设置邮件传输协议
		props.setProperty("mail.smtp.auth", "false");//设置邮件服务器是否需要验证
		Session session=Session.getDefaultInstance(props);
		session.setDebug(true);
		
		Message message=new MimeMessage(session);
		//设置邮件内容
		message.setSubject("earl's mail");
		message.setText("EARL'S FRIST JAVAMAIL");
		message.setFrom(new InternetAddress("earlyuan@163.com"));
		
		
		//第二步：要有发送载体Transport
		//从session中获取发送载体
		Transport transport=session.getTransport();
		//设置连接的参数，这里的第三个参数发送方用户名一定要与message.setFrom中的保持一致，否则就会报错
		transport.connect("smtp.163.com", 25, "earlyuan", "yy900731");
		//发送邮件，参数为收件人邮箱
		transport.sendMessage(message, new Address[]{new InternetAddress("yy28458@126.com")});
		transport.close();
		
	}

}
