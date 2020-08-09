package com.example.hackerpoll.model;


public class CreateHackerResponseModel {
	private Long personId;
	private String username;
	private String email;
	private String password;
	private String datastructure;
	private String python;
	private String cpp;
	private String java;
	private String algorithms;
	private Long votes;
	
	public CreateHackerResponseModel() {
		super();
	}

	public CreateHackerResponseModel(Long personId, String username, String email, String password, String datastructure, String python,
			String cpp, String java, String algorithms, Long votes) {
		super();
		this.personId = personId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.datastructure = datastructure;
		this.python = python;
		this.cpp = cpp;
		this.java = java;
		this.algorithms = algorithms;
		this.votes = votes;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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
		return "CreateHackerResponseModel [personId=" + personId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", datastructure=" + datastructure + ", python=" + python + ", cpp=" + cpp + ", java=" + java
				+ ", algorithms=" + algorithms + ", votes=" + votes + "]";
	}
	
}
