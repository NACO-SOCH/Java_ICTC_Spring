
package gov.naco.soch.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import gov.naco.soch.domain.Facility;
import gov.naco.soch.domain.ReferredICTC;

public class FICTCOutReferralHistoryResponseDto {

	private String beneficiaryName;
	private String pid;
	private LocalDate hivScreeningDate;
	private String gender;
	private String age;
	private String mobileNumber;
	private Long numberOfDaysSinceScreening;
	private Facility referredToIctcDetails;
	private boolean pregnant;
	private String pregnancyStatus;
	private LocalDateTime dateOfReferral;
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public LocalDate getHivScreeningDate() {
		return hivScreeningDate;
	}
	public void setHivScreeningDate(LocalDate hivScreeningDate) {
		this.hivScreeningDate = hivScreeningDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Long getNumberOfDaysSinceScreening() {
		return numberOfDaysSinceScreening;
	}
	public void setNumberOfDaysSinceScreening(Long numberOfDaysSinceScreening) {
		this.numberOfDaysSinceScreening = numberOfDaysSinceScreening;
	}
	public Facility getReferredToIctcDetails() {
		return referredToIctcDetails;
	}
	public void setReferredToIctcDetails(Facility referredToIctcDetails) {
		this.referredToIctcDetails = referredToIctcDetails;
	}
	public boolean isPregnant() {
		return pregnant;
	}
	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}
	public String getPregnancyStatus() {
		return pregnancyStatus;
	}
	public void setPregnancyStatus(String pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}
	public LocalDateTime getDateOfReferral() {
		return dateOfReferral;
	}
	public void setDateOfReferral(LocalDateTime dateOfReferral) {
		this.dateOfReferral = dateOfReferral;
	}
	
	
	
}
