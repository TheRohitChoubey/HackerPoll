package com.example.hackerpoll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackerpoll.data.Hacker;
import com.example.hackerpoll.data.Login;
import com.example.hackerpoll.data.Savedip;
import com.example.hackerpoll.data.VotingData;
import com.example.hackerpoll.model.CreateHackerRequestModel;
import com.example.hackerpoll.service.HackerService;

@RestController
public class UserController {
	@Autowired
	private HackerService userService;
	
	@PostMapping("/registerupdate")
	public ResponseEntity<?> createUser(@RequestBody Hacker user) {
		System.out.println(user);
		Hacker userDetails = userService.createNewUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login user) {
		System.out.println(user);
		Hacker userDetails = userService.login(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
	}
	
	@GetMapping("/candidateDetail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable("email") String email) {
		System.out.println("User email = "+email);
		Hacker userDetails = userService.getCandidate(email);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
	}
	
	@GetMapping("/allCandidates")
	public ResponseEntity<?> getAllCandidates() {
		List<Hacker> userDetails = userService.getAllHackers();
		return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
	}
	
	@PostMapping("/vote")
	public ResponseEntity<?> vote(@RequestBody VotingData data) {
		System.out.println(data);
		Hacker userDetails = userService.vote(data);
		
		if(userDetails == null) {
			userDetails = new Hacker();
			userDetails.setUsername("Not Found");
			userDetails.setEmail("Not Found");
			return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
		}
	}
	
	@PostMapping("/ip")
	public ResponseEntity<?> ipAdd(@RequestBody Savedip data) {
		System.out.println(data);
		Savedip userDetails = userService.ipAdd(data);
		
		if(userDetails == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Error");
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Success");
		}
	}
}
