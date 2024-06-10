
package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"userPolicyId"})
	})
	public class AutoPolicy {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long autoPurchaseId;
	    private String vehicleModelNo;
	    private String licensePlateNo;
	    private String driverLicense;
	    private Double vehicleValue;
	    private String primaryUse;
	    private String vehicleType;
	    private Integer driverAge;
	    private String cheatSheet;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "userPolicyId")
	    private UserPolicy userPolicy;

		public Long getAutoPurchaseId() {
			return autoPurchaseId;
		}

		public void setAutoPurchaseId(Long autoPurchaseId) {
			this.autoPurchaseId = autoPurchaseId;
		}

		public String getVehicleModelNo() {
			return vehicleModelNo;
		}

		public void setVehicleModelNo(String vehicleModelNo) {
			this.vehicleModelNo = vehicleModelNo;
		}

		public String getLicensePlateNo() {
			return licensePlateNo;
		}

		public void setLicensePlateNo(String licensePlateNo) {
			this.licensePlateNo = licensePlateNo;
		}

		public String getDriverLicense() {
			return driverLicense;
		}

		public void setDriverLicense(String driverLicense) {
			this.driverLicense = driverLicense;
		}

		public Double getVehicleValue() {
			return vehicleValue;
		}

		public void setVehicleValue(Double vehicleValue) {
			this.vehicleValue = vehicleValue;
		}

		public String getPrimaryUse() {
			return primaryUse;
		}

		public void setPrimaryUse(String primaryUse) {
			this.primaryUse = primaryUse;
		}

		public String getVehicleType() {
			return vehicleType;
		}

		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}

		public Integer getDriverAge() {
			return driverAge;
		}

		public void setDriverAge(Integer driverAge) {
			this.driverAge = driverAge;
		}

		public String getCheatSheet() {
			return cheatSheet;
		}

		public void setCheatSheet(String cheatSheet) {
			this.cheatSheet = cheatSheet;
		}

		public UserPolicy getUserPolicy() {
			return userPolicy;
		}

		public void setUserPolicy(UserPolicy userPolicy) {
			this.userPolicy = userPolicy;
		}

		@Override
		public String toString() {
			return "AutoPolicy [autoPurchaseId=" + autoPurchaseId + ", vehicleModelNo=" + vehicleModelNo
					+ ", licensePlateNo=" + licensePlateNo + ", driverLicense=" + driverLicense + ", vehicleValue="
					+ vehicleValue + ", primaryUse=" + primaryUse + ", vehicleType=" + vehicleType + ", driverAge="
					+ driverAge + ", cheatSheet=" + cheatSheet + ", userPolicy=" + userPolicy + "]";
		}

		public AutoPolicy(Long autoPurchaseId, String vehicleModelNo, String licensePlateNo, String driverLicense,
				Double vehicleValue, String primaryUse, String vehicleType, Integer driverAge, String cheatSheet,
				UserPolicy userPolicy) {
			super();
			this.autoPurchaseId = autoPurchaseId;
			this.vehicleModelNo = vehicleModelNo;
			this.licensePlateNo = licensePlateNo;
			this.driverLicense = driverLicense;
			this.vehicleValue = vehicleValue;
			this.primaryUse = primaryUse;
			this.vehicleType = vehicleType;
			this.driverAge = driverAge;
			this.cheatSheet = cheatSheet;
			this.userPolicy = userPolicy;
		}

		public AutoPolicy() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	    // Getters and setters
	}
