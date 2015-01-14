package com.spinach.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.bean.ContactUs;

public class ContactUsAction extends ActionSupport{
	
	private String email;
	private String name;
	private String subject;
	private String content;
	
	public String sendMessage(){
		new Thread(new Runnable(){
			public void run() {
				ContactUs cu = new ContactUs();
				cu.sendEmail(email, name, subject, content);
			}
		}).start();
		
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
