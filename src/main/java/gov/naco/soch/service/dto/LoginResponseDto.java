package gov.naco.soch.service.dto;

import java.time.LocalDateTime;
import java.util.List;

public class LoginResponseDto {

	private String token;
	private String ssoSessionId;
	private Long userId;
	private String firstname;
	private String lastname;
	private String contact;
	private Long divisionId;
	private Long facilityTypeId;
	private Long facilityId;
	private String facilityName;
	private String facilityCode;
	private Long designationId;
	private String designation;
	private String userName;
	private Long roleId;
	private String roleName;
	private String facilityCbStatus;
	private Long stateId;
	private String stateAlernateName;
	private Long districtId;
	private String districtAlernateName;
	private LocalDateTime lastLogin;
	private List<String> accessCodes;
	private List<MenuItemDto> menuItems;
	private String activeToken;
	private LocalDateTime currentLoginTime;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSsoSessionId() {
		return ssoSessionId;
	}
	public void setSsoSessionId(String ssoSessionId) {
		this.ssoSessionId = ssoSessionId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	public Long getFacilityTypeId() {
		return facilityTypeId;
	}
	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFacilityCbStatus() {
		return facilityCbStatus;
	}
	public void setFacilityCbStatus(String facilityCbStatus) {
		this.facilityCbStatus = facilityCbStatus;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getStateAlernateName() {
		return stateAlernateName;
	}
	public void setStateAlernateName(String stateAlernateName) {
		this.stateAlernateName = stateAlernateName;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getDistrictAlernateName() {
		return districtAlernateName;
	}
	public void setDistrictAlernateName(String districtAlernateName) {
		this.districtAlernateName = districtAlernateName;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public List<String> getAccessCodes() {
		return accessCodes;
	}
	public void setAccessCodes(List<String> accessCodes) {
		this.accessCodes = accessCodes;
	}
	public List<MenuItemDto> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItemDto> menuItems) {
		this.menuItems = menuItems;
	}
	public String getActiveToken() {
		return activeToken;
	}
	public void setActiveToken(String activeToken) {
		this.activeToken = activeToken;
	}
	public LocalDateTime getCurrentLoginTime() {
		return currentLoginTime;
	}
	public void setCurrentLoginTime(LocalDateTime currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}
	@Override
	public String toString() {
		return "LoginResponseDto [token=" + token + ", ssoSessionId=" + ssoSessionId + ", userId=" + userId
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", contact=" + contact + ", divisionId="
				+ divisionId + ", facilityTypeId=" + facilityTypeId + ", facilityId=" + facilityId + ", facilityName="
				+ facilityName + ", facilityCode=" + facilityCode + ", designationId=" + designationId
				+ ", designation=" + designation + ", userName=" + userName + ", roleId=" + roleId + ", roleName="
				+ roleName + ", facilityCbStatus=" + facilityCbStatus + ", stateId=" + stateId + ", stateAlernateName="
				+ stateAlernateName + ", districtId=" + districtId + ", districtAlernateName=" + districtAlernateName
				+ ", lastLogin=" + lastLogin + ", accessCodes=" + accessCodes + ", menuItems=" + menuItems
				+ ", activeToken=" + activeToken + ", currentLoginTime=" + currentLoginTime + "]";
	}
	
}
