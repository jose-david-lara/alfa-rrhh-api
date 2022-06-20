package com.wposs.alfa.modules.test.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;



public class Email implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8551017049800118678L;

	@Valid
	private List<Address> address;
	
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String format;
	
	
	private List<AttachmentFile> attachments_file;
	
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String body;
	
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String title;
	
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String description;
	
	@NonNull
	private Boolean attachments_flag;

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public List<AttachmentFile> getAttachments_file() {
		return attachments_file;
	}

	public void setAttachments_file(List<AttachmentFile> attachments_file) {
		this.attachments_file = attachments_file;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Boolean getAttachments_flag() {
		return attachments_flag;
	}

	public void setAttachments_flag(Boolean attachments_flag) {
		this.attachments_flag = attachments_flag;
	}

	@Override
	public String toString() {
		return "EmailInputDTO [address=" + address + ", format=" + format + ", attachments_file=" + attachments_file
				+ ", body=" + body + ", title=" + title + ", description=" + description + ", attachments_flag="
				+ attachments_flag + "]";
	}
	
	
	

}
