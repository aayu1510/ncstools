package com.concretepage.entity;

import java.util.Date;

public class Demand {
	String demandId;
	String groupName;
	String jdRole;
	String contractRoles;
	String skillType;
	String roleTechnologyMapping;
	String technologyGroup;
	String relevantExperience;
	String psoOwner;
	Date raisedOn;
	Date needBy;
	String status;
	
	public String getDemandId() {
		return demandId;
	}
	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getJdRole() {
		return jdRole;
	}
	public void setJdRole(String jdRole) {
		this.jdRole = jdRole;
	}
	public String getContractRoles() {
		return contractRoles;
	}
	public void setContractRoles(String contractRoles) {
		this.contractRoles = contractRoles;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getRoleTechnologyMapping() {
		return roleTechnologyMapping;
	}
	public void setRoleTechnologyMapping(String roleTechnologyMapping) {
		this.roleTechnologyMapping = roleTechnologyMapping;
	}
	public String getTechnologyGroup() {
		return technologyGroup;
	}
	public void setTechnologyGroup(String technologyGroup) {
		this.technologyGroup = technologyGroup;
	}
	public String getRelevantExperience() {
		return relevantExperience;
	}
	public void setRelevantExperience(String relevantExperience) {
		this.relevantExperience = relevantExperience;
	}
	public String getPsoOwner() {
		return psoOwner;
	}
	public void setPsoOwner(String psoOwner) {
		this.psoOwner = psoOwner;
	}
	public Date getRaisedOn() {
		return raisedOn;
	}
	public void setRaisedOn(Date raisedOn) {
		this.raisedOn = raisedOn;
	}
	public Date getNeedBy() {
		return needBy;
	}
	public void setNeedBy(Date needBy) {
		this.needBy = needBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
