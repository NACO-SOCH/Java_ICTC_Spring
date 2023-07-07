package gov.naco.soch.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IctcSearchResultDTO<T> {

	private Integer beneficiaryId;
	private String uid;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String mobileNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String oldPreArtNumber;
	private String oldArtNumber;
	private String preArtNumber;
	private String artNumber;
	private String status;
	private Boolean lacLinked;
	private Boolean isTransit;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rSeq;
	private String artTransferStatus;
	private String transferredTo;
	
	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getOldPreArtNumber() {
		return oldPreArtNumber;
	}
	public void setOldPreArtNumber(String oldPreArtNumber) {
		this.oldPreArtNumber = oldPreArtNumber;
	}
	public String getOldArtNumber() {
		return oldArtNumber;
	}
	public void setOldArtNumber(String oldArtNumber) {
		this.oldArtNumber = oldArtNumber;
	}
	public String getPreArtNumber() {
		return preArtNumber;
	}
	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}
	public String getArtNumber() {
		return artNumber;
	}
	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getLacLinked() {
		return lacLinked;
	}
	public void setLacLinked(Boolean lacLinked) {
		this.lacLinked = lacLinked;
	}
	public Boolean getIsTransit() {
		return isTransit;
	}
	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}
	public Date getrSeq() {
		return rSeq;
	}
	public void setrSeq(Date rSeq) {
		this.rSeq = rSeq;
	}
	public String getArtTransferStatus() {
		return artTransferStatus;
	}
	public void setArtTransferStatus(String artTransferStatus) {
		this.artTransferStatus = artTransferStatus;
	}
	public String getTransferredTo() {
		return transferredTo;
	}
	public void setTransferredTo(String transferredTo) {
		this.transferredTo = transferredTo;
	}

	
	


}
