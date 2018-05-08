package com.concretepage.entity.demand.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class DemandMappingRowMapper implements RowMapper<DemandMapping> {

@Override
public DemandMapping mapRow(ResultSet row, int rowNum) throws SQLException {
DemandMapping demandMapping = new DemandMapping();
demandMapping.setDemandId(row.getString(1));
demandMapping.setGroupName(row.getString(3));
demandMapping.setContractRole(row.getString(4));
demandMapping.setInfosysEmpNo(row.getInt(5));
demandMapping.setName(row.getString(6));
demandMapping.setCustomeRoleMapping(row.getString(7));
demandMapping.setProfileSharedDate(row.getDate(8));
demandMapping.setInterviewDate(row.getDate(9));
demandMapping.setClientInformationDate(row.getDate(10));
demandMapping.setPsoStatus(row.getString(11));
demandMapping.setOnboardingStatus(row.getString(12));
demandMapping.setComments(row.getString(13));
return demandMapping;
	}

}
