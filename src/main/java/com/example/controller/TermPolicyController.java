package com.example.controller;

import com.example.model.TermPolicy;
import com.example.model.User;
import com.example.model.UserPolicy;
import com.example.repo.UserPolicyRepo;
import com.example.service.TermPolicyService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controller.UserPolicyController;
import org.springframework.web.bind.annotation.SessionAttribute;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/term-policies")
public class TermPolicyController {

private final TermPolicyService termPolicyService;
    
@Autowired
private UserPolicyRepo upr;

    @Autowired
    public TermPolicyController(TermPolicyService termPolicyService) {
        
		this.termPolicyService = termPolicyService;
    }


    
    @PostMapping("/create")
    public ResponseEntity<TermPolicy> createTermPolicy(@RequestBody TermPolicy termPolicy, HttpSession session) throws RuntimeException {
        // Retrieve the userPolicyId from the session
        //Long userPolicyId = (Long) session.getAttribute("userPolicyId");
    	Long userPolicyId=UserPolicyController.createdUserId;
//    	 userPolicy.setUser(user);
//	        UserPolicy ups=userPolicyService.createUserPolicy(userPolicy);
    	UserPolicy user1;
		
		       user1 = upr.findById(userPolicyId)
		                       .orElseThrow(() -> new RuntimeException("User not found with ID: " + userPolicyId));
		       termPolicy.setUserPolicy(user1);

		
		       TermPolicy tps=termPolicyService.createTermPolicy(termPolicy);
		
//        Logger logger = (Logger) LoggerFactory.getLogger(TermPolicyController.class);
//      System.out.println(userPolicyId);
//        if (userPolicyId == null) {
//            // Handle case when userPolicyId is not found in the session
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        // Now create the TermPolicy
      
        return new ResponseEntity<>(tps, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<TermPolicy>> getAllTermPolicies() {
        Iterable<TermPolicy> termPolicies = termPolicyService.getAllTermPolicies();
        return new ResponseEntity<>(termPolicies, HttpStatus.OK);
    }
}
