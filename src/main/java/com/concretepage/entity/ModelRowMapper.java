package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ModelRowMapper implements RowMapper<Model> {

	@Override
	public Model mapRow(ResultSet row, int rowNum) throws SQLException {
		Model article = new Model();
		article.setGroupInfo(row.getString(1));
		article.setJD_Role(row.getString(2));
		
		article.setLocation(row.getString(3));
		article.setNiche_Commodity(row.getString(4));
		article.setKey_Posn(row.getString(5));
		article.setCustomer_Role_Mapping(row.getString(6));
		article.setRole_Technology_Mapping(row.getString(7));
		article.setTechnology_Group(row.getString(8));
		article.setRole_Group(row.getString(9));
		article.setRelevant_Exp(row.getString(10));
		article.setExp_on_Date_of_Onboarding(row.getString(11));
		article.setNCS_Contact(row.getString(12));
		article.setRaised_On_by_Client(row.getString(13));
		article.setNeed_By(row.getString(14));
		article.setVAC_onboarding_Date(row.getString(15));
		article.setOnboarding_Month(row.getString(16));
		article.setProfile_Shared_Date(row.getString(17));
		article.setInterview_Date(row.getString(18));
		article.setClient_confirmation_Date(row.getString(19));
		article.setNo_of_Rejections(row.getInt(20));
		article.setVAC_Offboarding_Date(row.getString(21));
		article.setInfosys_Unit_Owner(row.getString(22));
		article.setPSO_Status(row.getString(23));
		article.setOnboarding_Status(row.getString(24));
		article.setMerged_Status(row.getString(25));
		article.setInfosy_Emp_Id(row.getString(26));
		article.setCandidate_ID(row.getString(27));
		article.setName(row.getString(28));
		article.setJob_Role(row.getString(29));
		article.setContract_Role(row.getString(30));
		article.setInfosys_Designation(row.getString(31));
		article.setPU(row.getString(32));
		article.setDU(row.getString(33));
		article.setProject_Code(row.getString(34));
		article.setNCS_ID(row.getString(35));
		article.setNCS_Email(row.getString(36));
		article.setInterview_Status(row.getString(37));
		article.setLateral(row.getString(38));
		article.setInfys_DOJ(row.getString(39));
		article.setRemarks(row.getString(40));
		/*article.setArticleId(row.getInt("articleId"));
		article.setTitle(row.getString("title"));
		article.setCategory(row.getString("category"));*/
		return article;
	}

}
