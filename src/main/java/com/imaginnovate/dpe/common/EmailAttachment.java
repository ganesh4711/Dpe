package com.imaginnovate.dpe.common;


import java.io.InputStream;

public class EmailAttachment {
	private String name;
	private InputStream attachment;

	public EmailAttachment(String name, InputStream attachment) {
		this.name = name;
		this.attachment = attachment;
	}

	public String getName() {
		return this.name;
	}

	public InputStream getAttachment() {
		return this.attachment;
	}

}
