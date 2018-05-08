package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class DemandRowMapper implements RowMapper<Demand> {

	@Override
	public Demand mapRow(ResultSet row, int rowNum) throws SQLException {
		Demand demand = new Demand();
		demand.setDemandId(row.getString(1));
		demand.setGroupName(row.getString(3));
		demand.setJdRole(row.getString(4));
		demand.setContractRoles(row.getString(5));
		demand.setSkillType(row.getString(6));
		demand.setRoleTechnologyMapping(row.getString(7));
		demand.setTechnologyGroup(row.getString(8));
		demand.setRelevantExperience(row.getString(9));
		demand.setPsoOwner(row.getString(10));
		demand.setRaisedOn(row.getDate(11));
		demand.setNeedBy(row.getDate(12));
		demand.setStatus(row.getString(13));
		return demand;
	}

}
