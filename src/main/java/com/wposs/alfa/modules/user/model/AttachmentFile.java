package com.wposs.alfa.modules.user.model;

import java.io.Serializable;

public class AttachmentFile implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5689848466548653868L;
	private String name_file;
	private String base64_file;
	
	public String getName_file() {
		return name_file;
	}
	public void setName_file(String name_file) {
		this.name_file = name_file;
	}
	public String getBase64_file() {
		return base64_file;
	}
	public void setBase64_file(String base64_file) {
		this.base64_file = base64_file;
	}
	@Override
	public String toString() {
		return "AttachmentFileDTO [name_file=" + name_file + ", base64_file=" + base64_file + "]";
	}
	

}
