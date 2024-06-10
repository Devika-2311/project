package com.example.controller;

import com.example.model.User;
import com.example.model.UserPolicy;
import com.example.repo.UserPolicyRepo;
import com.example.repo.UserRepo;
import com.example.service.UserPolicyService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controller.UserController;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user-policies")
public class UserPolicyController {

	@Autowired
    private UserRepo ur;
	@Autowired
	private UserPolicyRepo upr;
    
	 private final UserPolicyService userPolicyService;
	 @Autowired
	 private HttpSession session;
	 public static Long createdUserId;

	    @Autowired
	    public UserPolicyController(UserPolicyService userPolicyService, HttpSession session) {
	        this.userPolicyService = userPolicyService;
	        this.session = session;
	    }

   @Autowired
  private HttpSession httpSession;
   @PostMapping("/create")
	    public UserPolicy createUserPolicy(@RequestBody UserPolicy userPolicy, HttpSession session) {
	        Long userId = UserController.suserid; // Assuming suserid is accessible here
	        User user = ur.findById(userId)
	                       .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

	        userPolicy.setUser(user);
	        UserPolicy ups=userPolicyService.createUserPolicy(userPolicy);
	        System.out.println(ups.getUserPolicyId());
	        createdUserId = ups.getUserPolicyId();
	        System.out.println(createdUserId);
	        session.setAttribute("userPolicyId", userPolicy.getUserPolicyId());
	        System.out.println( userPolicy.getUserPolicyId());
	        return ups;
	    }
	   
//	    	@Autowired
//	    	private HttpSession httpSession;
//		    @PostMapping("/create")
//		    public ResponseEntity<UserPolicy>  createUserPolicy(@RequestBody UserPolicy userPolicy, HttpSession session) {
//		        Long userId = UserController.suserid; 
//		        System.out.println("userid"+userId);// Assuming suserid is accessible here
//		        User user = ur.findById(userId)
//		                       .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//		        
//		        userPolicy.setUser(user);
//		        
////		        // Save the userPolicyId in the session
////		        session.setAttribute("userPolicyId", userPolicy.getUserPolicyId());
//		        userPolicyService.createUserPolicy(userPolicy);
//		        System.out.println( userPolicy.getUserPolicyId());
//		        UserPolicy createdUser=upr.save(userPolicy);
//		        createdUserId = createdUser.getUserPolicyId();
//		        System.out.println(createdUserId);// Store the ID of the created user
//		        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//		    }


    @GetMapping("/all")
    public List<UserPolicy> getAllUserPolicies() {
        return userPolicyService.getAllUserPolicies();
    } 
    
}
