package com.example.service;

import com.example.model.TermPolicy;
import com.example.repo.TermPolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermPolicyService {

    private final TermPolicyRepo termPolicyRepository;

    @Autowired
    public TermPolicyService(TermPolicyRepo termPolicyRepository) {
        this.termPolicyRepository = termPolicyRepository;
    }

    public TermPolicy createTermPolicy(TermPolicy termPolicy) {
        return termPolicyRepository.save(termPolicy);
    }
    public TermPolicy createTermPolicy(TermPolicy termPolicy, Long userPolicyId) {
        // Set the userPolicyId in the TermPolicy
        termPolicy.getUserPolicy().setUserPolicyId(userPolicyId);

        // Save the TermPolicy in the database
        return termPolicyRepository.save(termPolicy);
    }
    public Iterable<TermPolicy> getAllTermPolicies() {
        return termPolicyRepository.findAll();
    }
    
}
