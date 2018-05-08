package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CountInformationRowMapper implements RowMapper<CountInformation> {

	@Override
	public CountInformation mapRow(ResultSet row, int rowNum) throws SQLException {
		CountInformation countInformation = new CountInformation();
		countInformation.setOfBoardingnumber(row.getInt(1));
		countInformation.setOnBoardingnumber(row.getInt(2));
		return countInformation;
	}

}
