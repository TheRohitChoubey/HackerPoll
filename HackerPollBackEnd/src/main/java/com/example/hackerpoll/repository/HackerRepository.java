package com.example.hackerpoll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackerpoll.data.Hacker;

@Repository
public interface HackerRepository extends JpaRepository<Hacker, Long> {

	Hacker findByEmail(String email);
	Hacker findByEmailAndPassword(String email,String password);
}
