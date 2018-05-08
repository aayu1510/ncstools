package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CandidateRowMapper implements RowMapper<Candidate> {

	@Override
	public Candidate mapRow(ResultSet row, int rowNum) throws SQLException {
		Candidate candidate = new Candidate();
		candidate.setInfosys_EmpNo(row.getInt(1));
		candidate.setName(row.getString(2));
		candidate.setNCS_ID(row.getString(3));
		candidate.setNCS_Email(row.getString(4));
		candidate.setContract_Role(row.getString(5));
		candidate.setOnboardingStatus(row.getString(6));
		candidate.setVAC_Onboarding_Date(row.getDate(7));
		candidate.setVAC_Offboarding_Date(row.getDate(8));
		return candidate;
	}

}
