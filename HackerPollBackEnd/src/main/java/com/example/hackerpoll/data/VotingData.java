package com.example.hackerpoll.data;

public class VotingData {
	private String ip;
	private String email;
	
	public VotingData() {
		super();
	}

	public VotingData(String ip, String email) {
		super();
		this.ip = ip;
		this.email = email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "VotingData [ip=" + ip + ", email=" + email + "]";
	}
	
}
