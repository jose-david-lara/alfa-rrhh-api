package com.wposs.alfa.modules.device.model;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable{
	
	
	private String idEquipo;
	private Integer estado;
	private String serial;
	private String ultimaIp;
	private Date fechaActivacion;
	private String model;
	private String latitud;
	private String longitud;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7569522791731558295L;
	
	public String getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getUltimaIp() {
		return ultimaIp;
	}
	public void setUltimaIp(String ultimaIp) {
		this.ultimaIp = ultimaIp;
	}
	public Date getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Device [idEquipo=" + idEquipo + ", estado=" + estado + ", serial=" + serial + ", ultimaIp=" + ultimaIp
				+ ", fechaActivacion=" + fechaActivacion + ", model=" + model + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}
	
	


}
