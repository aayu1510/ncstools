package com.concretepage.entity.demand.mapping;

import java.util.Date;

public class DemandMapping {
	
private String demandId;
private String groupName;
private String contractRole;
private int infosysEmpNo;
private String name;
private String customeRoleMapping;
private Date profileSharedDate;
private Date interviewDate;
private Date clientInformationDate;
private String psoStatus;
private String onboardingStatus;
private String comments;

public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public String getContractRole() {
	return contractRole;
}
public void setContractRole(String contractRole) {
	this.contractRole = contractRole;
}
public int getInfosysEmpNo() {
	return infosysEmpNo;
}
public void setInfosysEmpNo(int infosysEmpNo) {
	this.infosysEmpNo = infosysEmpNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCustomeRoleMapping() {
	return customeRoleMapping;
}
public void setCustomeRoleMapping(String customeRoleMapping) {
	this.customeRoleMapping = customeRoleMapping;
}
public Date getProfileSharedDate() {
	return profileSharedDate;
}
public void setProfileSharedDate(Date profileSharedDate) {
	this.profileSharedDate = profileSharedDate;
}
public Date getInterviewDate() {
	return interviewDate;
}
public void setInterviewDate(Date interviewDate) {
	this.interviewDate = interviewDate;
}
public Date getClientInformationDate() {
	return clientInformationDate;
}
public void setClientInformationDate(Date clientInformationDate) {
	this.clientInformationDate = clientInformationDate;
}
public String getPsoStatus() {
	return psoStatus;
}
public void setPsoStatus(String psoStatus) {
	this.psoStatus = psoStatus;
}
public String getOnboardingStatus() {
	return onboardingStatus;
}
public void setOnboardingStatus(String onboardingStatus) {
	this.onboardingStatus = onboardingStatus;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getDemandId() {
	return demandId;
}
public void setDemandId(String demandId) {
	this.demandId = demandId;
}

}
