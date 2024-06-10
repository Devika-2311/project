package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UserPolicy;

public interface UserPolicyRepo extends JpaRepository<UserPolicy,Long> {

}