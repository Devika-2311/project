package com.example.service;

import com.example.model.UserPolicy;
import com.example.repo.UserPolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPolicyService {

    @Autowired
    private UserPolicyRepo userPolicyRepository;

    public UserPolicy createUserPolicy(UserPolicy userPolicy) {
        return userPolicyRepository.save(userPolicy);
    }

    public List<UserPolicy> getAllUserPolicies() {
        return userPolicyRepository.findAll();
    }
}
