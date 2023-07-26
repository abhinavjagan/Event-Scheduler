package com.example.demo.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserServices {
	
		
			
			public static String EmailVerification(String to) {
				
				System.out.println("preparing to send message ...");
				String otp=OTPGen();
				String message = "Hello,\n\nYour OTP for email verification is "+ otp+ "\n\nThe Car Parking Solutions Team";
					
				String subject = "Email Verification";
				
				String from = "theCh0sen0ne.oo111@gmail.com";
				
				sendEmail(message,subject,to,from);
				
				return otp;
				
			}
			
			private static String OTPGen() {
				String otp="";
				for(int i=0;i<6;i++) {
					otp=otp.concat(Integer.toString((int)(Math.random()*9) + 1));// (int)(Math.random() * range) + min; range = max - min + 1;
				}
				
				
				return otp;
			}
			//this is responsible to send the message with attachment
			public static void sendEmail(String message, String subject, String to, String from) {

				//Variable for gmail
				String host="smtp.gmail.com";
				
				//get the system properties
				Properties properties = System.getProperties();
				System.out.println("PROPERTIES "+properties);
				
				//setting important information to properties object
				
				//host set
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port","465");
				properties.put("mail.smtp.ssl.enable","true");
				properties.put("mail.smtp.auth","true");
				
				//Step 1: to get the session object..
				Session session=Session.getInstance(properties, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {				
						return new PasswordAuthentication(from, "poiuyt098765");
					}
					
					
					
				});
				
				session.setDebug(true);
				
				//Step 2 : compose the message [text,multi media]
				MimeMessage m = new MimeMessage(session);
				
				try {
				
				//from email
				m.setFrom(from);
				
				//adding recipient to message
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//adding subject to message
				m.setSubject(subject);
			
				m.setText(message);
				
				//Step 3 : send the message using Transport class
				Transport.send(m);
				
				
				
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Sent success...................");
				
				
			}
		
			
}
