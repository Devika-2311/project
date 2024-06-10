package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.TermPolicy;

public interface TermPolicyRepo extends JpaRepository<TermPolicy,Long> {

}