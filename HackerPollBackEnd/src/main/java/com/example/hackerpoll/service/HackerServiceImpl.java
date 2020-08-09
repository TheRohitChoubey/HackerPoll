package com.example.hackerpoll.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.hackerpoll.data.Hacker;
import com.example.hackerpoll.data.Login;
import com.example.hackerpoll.data.Savedip;
import com.example.hackerpoll.data.VotingData;
import com.example.hackerpoll.repository.HackerRepository;
import com.example.hackerpoll.repository.SavedipRepository;

@Service
public class HackerServiceImpl implements HackerService {
	@Autowired
	private Environment env;

	private HackerRepository hackerRepository;
	@Autowired
	private SavedipRepository savedipRepository;


	@Autowired
	public HackerServiceImpl(Environment env, HackerRepository hackerRepository) {
		super();
		this.env = env;
		this.hackerRepository = hackerRepository;
	}

	@Override
	public Hacker createNewUser(Hacker user) {
		
		if(hackerRepository.findByEmail(user.getEmail()) == null) {
			List<Hacker> allUsers = hackerRepository.findAll();
			Integer totalSize = allUsers.size() + 1;
			Long personId = totalSize.longValue();
			user.setPersonid(personId);
			return hackerRepository.save(user);
		}
		else {
			Hacker oldDetails = hackerRepository.findByEmail(user.getEmail());
			user.setPersonid(oldDetails.getPersonid());
			user.setVotes(oldDetails.getVotes());
			hackerRepository.delete(oldDetails);
			return hackerRepository.save(user);
		}
	}
	
	@Override
	public Hacker login(Login user) {
		if(hackerRepository.findByEmailAndPassword(user.getEmail(),user.getPassword()) == null) {
			Hacker detail = new Hacker();
			detail.setUsername("Not Found");
			detail.setEmail("Not Found");
			return detail;
		}
		else {
			return hackerRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		}
	}
	
	@Override
	public Hacker getCandidate(String email) {
		if(hackerRepository.findByEmail(email) == null) {
			Hacker detail = new Hacker();
			detail.setUsername("Not Found");
			detail.setEmail("Not Found");
			return detail;
		}
		else {
			return hackerRepository.findByEmail(email);
		}
	}
	
	@Override
	public List<Hacker> getAllHackers(){
		List<Hacker> allUsers = hackerRepository.findAll();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getPersonid() == 1) {
				allUsers.remove(i);
			}
		}
		return allUsers;
	}

	@Override
	public Hacker vote(VotingData data) {
		Hacker user = hackerRepository.findByEmail(data.getEmail());
		if(user != null) {
			if(savedipRepository.findByIp(data.getIp()) == null) {
				user.setVotes(user.getVotes()+1);
				List<Savedip> allIps = savedipRepository.findAll();
				Long ipId;
				if(allIps == null) {
					Integer totalSize = 1;
					ipId = totalSize.longValue();
				}
				else {
					Integer totalSize = allIps.size() + 1;
					ipId = totalSize.longValue();
				}
				Savedip ip = new Savedip();
				ip.setIpid(ipId);
				ip.setIp(data.getIp());
				savedipRepository.save(ip);
				
				return hackerRepository.save(user);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		
	}

	@Override
	public Savedip ipAdd(Savedip data) {
		return savedipRepository.save(data);
	}
	
	

}
