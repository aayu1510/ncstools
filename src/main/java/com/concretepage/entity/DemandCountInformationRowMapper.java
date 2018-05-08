package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class DemandCountInformationRowMapper implements RowMapper<DemandCountInformation> {

	@Override
	public DemandCountInformation mapRow(ResultSet row, int rowNum) throws SQLException {
		DemandCountInformation demandCountInformation = new DemandCountInformation();
		demandCountInformation.setTotalDemands(row.getInt(1));
		demandCountInformation.setTotalHold(row.getInt(2));
		demandCountInformation.setTotalAbandoned(row.getInt(3));
		demandCountInformation.setTotalActive(row.getInt(4));
		return demandCountInformation;
	}

}
