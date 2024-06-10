package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AutoPolicy;
import com.example.repo.AutoPolicyRepo;

@Service
public class AutoPolicyService {
    
    @Autowired
    private AutoPolicyRepo autoPolicyRepository;
    
    public AutoPolicy createAutoPolicy(AutoPolicy autoPolicy) {
        return autoPolicyRepository.save(autoPolicy);
    }
    
    public List<AutoPolicy> getAllAutoPolicies() {
        return autoPolicyRepository.findAll();
    }
}

