package com.example.hackerpoll.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Savedip {
	@Id
	private Long ipid;
	private String ip;
		
	public Savedip() {
		super();
	}

	public Savedip(Long ipid, String ip) {
		super();
		this.ipid = ipid;
		this.ip = ip;
	}

	public Long getIpid() {
		return ipid;
	}

	public void setIpid(Long ipid) {
		this.ipid = ipid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Savedip [ipid=" + ipid + ", ip=" + ip + "]";
	}
}
