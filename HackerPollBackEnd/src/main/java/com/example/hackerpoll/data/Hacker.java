package com.example.hackerpoll.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hacker {
	@Id
	private Long personid;
	private String username;
	private String email;
	private String password;
	private String location;
	private String contest;
	private String datastructure;
	private String python;
	private String cpp;
	private String java;
	private String algorithms;
	private Long votes;
	
	public Hacker() {
		super();
	}

	public Hacker(Long personid, String username, String email, String password, String location, String contest,
			String datastructure, String python, String cpp, String java, String algorithms, Long votes) {
		super();
		this.personid = personid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.location = location;
		this.contest = contest;
		this.datastructure = datastructure;
		this.python = python;
		this.cpp = cpp;
		this.java = java;
		this.algorithms = algorithms;
		this.votes = votes;
	}

	public Long getPersonid() {
		return personid;
	}

	public void setPersonid(Long personid) {
		this.personid = personid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContest() {
		return contest;
	}

	public void setContest(String contest) {
		this.contest = contest;
	}

	public String getDatastructure() {
		return datastructure;
	}

	public void setDatastructure(String datastructure) {
		this.datastructure = datastructure;
	}

	public String getPython() {
		return python;
	}

	public void setPython(String python) {
		this.python = python;
	}

	public String getCpp() {
		return cpp;
	}

	public void setCpp(String cpp) {
		this.cpp = cpp;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getAlgorithms() {
		return algorithms;
	}

	public void setAlgorithms(String algorithms) {
		this.algorithms = algorithms;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Hacker [personid=" + personid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", location=" + location + ", contest=" + contest + ", datastructure=" + datastructure + ", python="
				+ python + ", cpp=" + cpp + ", java=" + java + ", algorithms=" + algorithms + ", votes=" + votes + "]";
	}

	

}