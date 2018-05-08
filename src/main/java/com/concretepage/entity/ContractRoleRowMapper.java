package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class ContractRoleRowMapper implements RowMapper<ContractRole> {

	@Override
	public ContractRole mapRow(ResultSet row, int rowNum) throws SQLException {
		ContractRole contractRole = new ContractRole();
		List<String>contractRoles=new ArrayList<String>();
		while(row.next())
		{
			contractRoles.add(row.getString(1));
			
		}
		
		contractRole.setContractRole(contractRoles);
		return contractRole;
	}

}
