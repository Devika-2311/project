package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TermPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termPolicyId;
    
    private Double annualIncome;
    private boolean anyDisease;
    private String nomineeName;
    private String nomineeRelation;
    private String nomineeEmail;
    private String nomineeProof;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_policy_id")
    private UserPolicy userPolicy;
    
	public Long getTermPolicyId() {
		return termPolicyId;
	}
	public void setTermPolicyId(Long termPolicyId) {
		this.termPolicyId = termPolicyId;
	}
	public Double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public boolean isAnyDisease() {
		return anyDisease;
	}
	public void setAnyDisease(boolean anyDisease) {
		this.anyDisease = anyDisease;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getNomineeRelation() {
		return nomineeRelation;
	}
	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}
	public String getNomineeEmail() {
		return nomineeEmail;
	}
	public void setNomineeEmail(String nomineeEmail) {
		this.nomineeEmail = nomineeEmail;
	}
	public String getNomineeProof() {
		return nomineeProof;
	}
	public void setNomineeProof(String nomineeProof) {
		this.nomineeProof = nomineeProof;
	}
	public UserPolicy getUserPolicy() {
		return userPolicy;
	}
	public void setUserPolicy(UserPolicy userPolicy) {
		this.userPolicy = userPolicy;
	}
	@Override
	public String toString() {
		return "TermPolicy [termPolicyId=" + termPolicyId + ", annualIncome=" + annualIncome + ", anyDisease="
				+ anyDisease + ", nomineeName=" + nomineeName + ", nomineeRelation=" + nomineeRelation
				+ ", nomineeEmail=" + nomineeEmail + ", nomineeProof=" + nomineeProof + ", userPolicy=" + userPolicy
				+ "]";
	}
	public TermPolicy(Long termPolicyId, Double annualIncome, boolean anyDisease, String nomineeName,
			String nomineeRelation, String nomineeEmail, String nomineeProof, UserPolicy userPolicy) {
		super();
		this.termPolicyId = termPolicyId;
		this.annualIncome = annualIncome;
		this.anyDisease = anyDisease;
		this.nomineeName = nomineeName;
		this.nomineeRelation = nomineeRelation;
		this.nomineeEmail = nomineeEmail;
		this.nomineeProof = nomineeProof;
		this.userPolicy = userPolicy;
	}
	public TermPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

   
 
}

