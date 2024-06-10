package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AutoPolicy;
import com.example.service.AutoPolicyService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auto-policies")
public class AutoPolicyController {
    
    @Autowired
    private AutoPolicyService autoPolicyService;
    
    @PostMapping("/create")
    public ResponseEntity<AutoPolicy> createAutoPolicy(@RequestBody AutoPolicy autoPolicy) {
        AutoPolicy createdAutoPolicy = autoPolicyService.createAutoPolicy(autoPolicy);
        return new ResponseEntity<>(createdAutoPolicy, HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AutoPolicy>> getAllAutoPolicies() {
        List<AutoPolicy> autoPolicies = autoPolicyService.getAllAutoPolicies();
        return new ResponseEntity<>(autoPolicies, HttpStatus.OK);
    }
}
