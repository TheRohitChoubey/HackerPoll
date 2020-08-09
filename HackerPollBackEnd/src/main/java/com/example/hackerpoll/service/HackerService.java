package com.example.hackerpoll.service;

import java.util.List;

import com.example.hackerpoll.data.Hacker;
import com.example.hackerpoll.data.Login;
import com.example.hackerpoll.data.Savedip;
import com.example.hackerpoll.data.VotingData;

public interface HackerService {
	public Hacker createNewUser(Hacker userDetail);
	public Hacker login(Login user);
	public Hacker getCandidate(String email);
	public List<Hacker> getAllHackers();
	public Hacker vote(VotingData data);
	public Savedip ipAdd(Savedip data);
}
