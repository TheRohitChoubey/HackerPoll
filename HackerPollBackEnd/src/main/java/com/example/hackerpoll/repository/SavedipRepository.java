package com.example.hackerpoll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackerpoll.data.Hacker;
import com.example.hackerpoll.data.Savedip;

@Repository
public interface SavedipRepository extends JpaRepository<Savedip, Long> {
	Savedip findByIp(String ip);
}
