package com.concretepage.entity;

import java.util.Date;

public class Candidate {
	int Infosys_EmpNo;
	String Name;
	String Contract_Role;
	String NCS_ID;
	String NCS_Email;
	Date VAC_Onboarding_Date;
	Date VAC_Offboarding_Date;
	String onboardingStatus;
	public int getInfosys_EmpNo() {
		return Infosys_EmpNo;
	}
	public void setInfosys_EmpNo(int infosys_EmpNo) {
		Infosys_EmpNo = infosys_EmpNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContract_Role() {
		return Contract_Role;
	}
	public void setContract_Role(String contract_Role) {
		Contract_Role = contract_Role;
	}
	public String getNCS_ID() {
		return NCS_ID;
	}
	public void setNCS_ID(String nCS_ID) {
		NCS_ID = nCS_ID;
	}
	public String getNCS_Email() {
		return NCS_Email;
	}
	public void setNCS_Email(String nCS_Email) {
		NCS_Email = nCS_Email;
	}
	public Date getVAC_Onboarding_Date() {
		return VAC_Onboarding_Date;
	}
	public void setVAC_Onboarding_Date(Date vAC_Onboarding_Date) {
		VAC_Onboarding_Date = vAC_Onboarding_Date;
	}
	public Date getVAC_Offboarding_Date() {
		return VAC_Offboarding_Date;
	}
	public void setVAC_Offboarding_Date(Date vAC_Offboarding_Date) {
		VAC_Offboarding_Date = vAC_Offboarding_Date;
	}
	public String getOnboardingStatus() {
		return onboardingStatus;
	}
	public void setOnboardingStatus(String onboardingStatus) {
		this.onboardingStatus = onboardingStatus;
	}
	
	
}
