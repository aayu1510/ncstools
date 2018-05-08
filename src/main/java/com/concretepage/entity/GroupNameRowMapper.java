package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class GroupNameRowMapper implements RowMapper<GroupName> {

	@Override
	public GroupName mapRow(ResultSet row, int rowNum) throws SQLException {
		GroupName groupName = new GroupName();
		List<String>groupnames=new ArrayList<String>();
		while(row.next())
		{
			groupnames.add(row.getString(1));
			
		}
		
		groupName.setGroupName(groupnames);;
		return groupName;
	}

}
