package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.AutoPolicy;

public interface AutoPolicyRepo extends JpaRepository<AutoPolicy,Long> {

}