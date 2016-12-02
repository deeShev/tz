package com.shevelev.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Device")
public class Device {
	@Id 
	@GenericGenerator(name="assigned", strategy = "assigned")
	@Column(name = "id",unique=true, nullable = false)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "numer")
	private String numer;
	@Column(name = "data")
	private String data;
	@Column(name = "resposible")
	private String resposible;
	@Column(name = "state")
	private String state;
	@Column(name = "node")
	private String node;
	
	public Device(){}
	
	public Device(String id){
		this.id = id;	
	}
	
	public Device(String id,String name, String numer, String data, String resposible, String state, String node) {
		this.id = id;
		this.name = name;
		this.numer = numer;
		this.data = data;
		this.resposible = resposible;
		this.state = state;
		this.node = node;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getResposible() {
		return resposible;
	}

	public void setResposible(String resposible) {
		this.resposible = resposible;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

}
