package com.concretepage.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.AddCandidate;
import com.concretepage.entity.Candidate;
import com.concretepage.entity.CandidateRowMapper;
import com.concretepage.entity.ContractRole;
import com.concretepage.entity.ContractRoleRowMapper;
import com.concretepage.entity.CountInformation;
import com.concretepage.entity.CountInformationRowMapper;
import com.concretepage.entity.Demand;
import com.concretepage.entity.DemandCountInformation;
import com.concretepage.entity.DemandCountInformationRowMapper;
import com.concretepage.entity.DemandRowMapper;
import com.concretepage.entity.GroupName;
import com.concretepage.entity.GroupNameRowMapper;
import com.concretepage.entity.Model;
import com.concretepage.entity.ModelRowMapper;
import com.concretepage.entity.demand.mapping.DemandMapping;
import com.concretepage.entity.demand.mapping.DemandMappingRowMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@Transactional
@Repository
public class ModelDAO implements IModelDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	 static XSSFRow row;
	 int employeeNo;
	private	String name;
	private String contractRole;
	private	Date onboardingDate;
	private	String ncsId;
	private	String ncsEmail;
	private	String status;
	private	Date offboardingDate;
	private	int srNo;
	private	int flag;
	FileInputStream fis;
	@Override
	public Candidate getCandidateById(int candidateId) {
		/*String sql = "SELECT ca.Infosys_EmpNo,ca.Name,ca.NCS_ID,ca.NCS_Email,ca.Contract_Role,dm.Onboarding_Status,ca.VAC_Onboarding_Date,dm.VAC_Offboarding_Date FROM candidates ca INNER JOIN demandmapping dm"
				+ " ON ca.Infosys_EmpNo = dm.Infosys_EmpNo and ca.Candidate_ID=dm.Candidate_ID and ca.empid=dm.empid  where  ca.Infosys_EmpNo=?";*/
		String sql = "SELECT  c.Infosys_EmpNo,c.Name,c.ncs_id,c.NCS_Email,c.Contract_Role,dm.Onboarding_Status,c.VAC_Onboarding_Date,dm.VAC_Offboarding_Date FROM demandmapping dm, demand d , candidates c, groupdetails g where dm.DemandSrno=d.DemandSrno and dm.EmpId=c.EmpId and d.group_id=g.groupId and  d.Demand_ID !='' and dm.Demand_ID != '' and  c.Infosys_EmpNo=?";
		RowMapper<Candidate> rowMapper = new CandidateRowMapper();
		Candidate candidate = jdbcTemplate.queryForObject(sql, rowMapper, candidateId);
		return candidate;
	}
	
	@Override
	public List<Model> getAllEmployees() {
		String sql = "select * from demandtrackernew123";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Model> rowMapper = new ModelRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	
	@Override
	public List<Candidate> getAllNewCandidates() {
	//String sql = "SELECT ca.Infosys_EmpNo,ca.Name,ca.NCS_ID,ca.NCS_Email,ca.Contract_Role,dm.Onboarding_Status,ca.VAC_Onboarding_Date,dm.VAC_Offboarding_Date FROM candidates ca INNER JOIN demandmapping dm ON  ca.empid=dm.empid where dm.Candidate_ID is null and flag=1";
String sql="SELECT ca.Infosys_EmpNo,ca.Name,ca.NCS_ID,ca.NCS_Email,ca.Contract_Role,ca.Status,ca.Onboarding_Date,ca.Offboarding_Date FROM latestcandidatedetails ca where flag=0";
		RowMapper<Candidate> rowMapper = new CandidateRowMapper();
return this.jdbcTemplate.query(sql, rowMapper);

	}	
	
	@Override
	public List<Candidate> getAllCandidates() {
		/*String sql = "SELECT ca.Infosys_EmpNo,ca.Name,ca.NCS_ID,ca.NCS_Email,ca.Contract_Role,dm.Onboarding_Status,ca.VAC_Onboarding_Date,dm.VAC_Offboarding_Date FROM candidates ca INNER JOIN demandmapping dm"
				+ " ON ca.Infosys_EmpNo = dm.Infosys_EmpNo and ca.Candidate_ID=dm.Candidate_ID and ca.empid=dm.empid ";*/
		String sql = "SELECT  c.Infosys_EmpNo,c.Name,c.ncs_id,c.NCS_Email,c.Contract_Role,dm.Onboarding_Status,c.VAC_Onboarding_Date,dm.VAC_Offboarding_Date FROM demandmapping dm, demand d , candidates c, groupdetails g where dm.DemandSrno=d.DemandSrno and dm.EmpId=c.EmpId and d.group_id=g.groupId and  d.Demand_ID !='' and dm.Demand_ID != ''";

        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Candidate> rowMapper = new CandidateRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public List<Demand> getAllDemands() {
		String sql = "select ld.Demand_ID,ld.Group_ID,gd.GroupInfo,ld.JDRole,ld.Contract_Roles,ld.Skill_Type,ld.Role_Technology_Mapping,ld.Technology_Group,ld.Relevant_Exp,ld.PSO_Owner,ld.raised_On,ld.Need_By,ld.Status from latestdemands ld  inner join  groupdetails gd on ld.Group_ID=gd.GroupID";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Demand> rowMapper = new DemandRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public void addCandidate(AddCandidate candidate) {
		//Add article
		//String sql = "INSERT INTO articles (articleId, title, category) values (?, ?, ?)";
		String sql="insert into candidates(Infosys_EmpNo,Name,ncs_id,NCS_Email,Contract_Role,VAC_Onboarding_Date)values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, candidate.getTxtEmployeeNo(),candidate.getTxtName(), candidate.getTxtNCSID(), candidate.getTxtNCSEmailid(),candidate.getTxtContractRole(), candidate.getTxtVACOnboardingDate());
		
		//Fetch article id
		//sql = "SELECT articleId FROM articles WHERE title = ? and category=?";
		sql="select EmpId from candidates where Infosys_EmpNo=?";
		int employeeId = jdbcTemplate.queryForObject(sql, Integer.class, candidate.getTxtEmployeeNo());
		
		sql="insert into demandmapping(Onboarding_Status,VAC_Offboarding_Date,Infosys_EmpNo,EmpId,DemandSrno)values(?,?,?,?,?)";
		jdbcTemplate.update(sql,candidate.getTxtOnboardingStatus(), candidate.getTxtVACOffboardingDate(), candidate.getTxtEmployeeNo(),employeeId,employeeId);
		
		sql="insert into demandtracker(Infosy_Emp_Id,Name,NCS_ID,NCS_Email,Contract_Role,VAC_onboarding_Date,Onboarding_Status,VAC_Offboarding_Date)values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, candidate.getTxtEmployeeNo(),candidate.getTxtName(), candidate.getTxtNCSID(), candidate.getTxtNCSEmailid(),candidate.getTxtContractRole(), candidate.getTxtVACOnboardingDate(),candidate.getTxtOnboardingStatus(), candidate.getTxtVACOffboardingDate());
		
		sql="insert into latestcandidatedetails(Infosys_EmpNo,Name,Contract_Role,Onboarding_Date,NCS_ID,NCS_Email,Status,Offboarding_Date)values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, candidate.getTxtEmployeeNo(),candidate.getTxtName(),candidate.getTxtContractRole(),candidate.getTxtVACOnboardingDate(),candidate.getTxtNCSID(), candidate.getTxtNCSEmailid(), candidate.getTxtOnboardingStatus(), candidate.getTxtVACOffboardingDate());
		//Set article id 
	}
	
	@Override
	public void updateCandidate(AddCandidate candidate) {
		String sql="select EmpId from candidates where Infosys_EmpNo=?";
		int employeeId = jdbcTemplate.queryForObject(sql, Integer.class, candidate.getTxtEmployeeNo());
		 sql = "UPDATE candidates SET Name=?, ncs_id=?, NCS_Email=?, Contract_Role=?,VAC_Onboarding_Date=? WHERE Infosys_EmpNo=? and EmpId=?";
		jdbcTemplate.update(sql, candidate.getTxtName(), candidate.getTxtNCSID(), candidate.getTxtNCSEmailid(),candidate.getTxtContractRole(), candidate.getTxtVACOnboardingDate(),candidate.getTxtEmployeeNo(),employeeId);
		sql="update demandmapping set Onboarding_Status=?,VAC_Offboarding_Date=? where EmpId=?";
		jdbcTemplate.update(sql,candidate.getTxtOnboardingStatus(), candidate.getTxtVACOffboardingDate(), candidate.getTxtEmployeeNo());
		 sql="SELECT Track_Id FROM demandtracker where Infosy_Emp_Id=?";
		 
		/*int trackId = jdbcTemplate.queryForObject(sql, Integer.class, candidate.getTxtEmployeeNo());
		sql="update demandtracker set Name=?,NCS_ID=?,NCS_Email=?,Contract_Role=?,VAC_onboarding_Date=?,Onboarding_Status=?,VAC_Offboarding_Date=? where Track_Id=?";
		jdbcTemplate.update(sql, candidate.getTxtName(), candidate.getTxtNCSID(), candidate.getTxtNCSEmailid(),candidate.getTxtContractRole(), candidate.getTxtVACOnboardingDate(),candidate.getTxtOnboardingStatus(), candidate.getTxtVACOffboardingDate(),trackId);*/
		
		sql="select SrNo from latestcandidatedetails where Infosys_EmpNo=?";
		int srNo = jdbcTemplate.queryForObject(sql, Integer.class, candidate.getTxtEmployeeNo());
		sql="update latestcandidatedetails set Name=?,NCS_ID=?,NCS_Email=?,Contract_Role=?,Onboarding_Date=?,Status=?,Offboarding_Date=? where SrNo=? and Infosys_EmpNo=?";
		jdbcTemplate.update(sql, candidate.getTxtName(), candidate.getTxtNCSID(), candidate.getTxtNCSEmailid(),candidate.getTxtContractRole(), candidate.getTxtVACOnboardingDate(),candidate.getTxtOnboardingStatus(), candidate.getTxtVACOffboardingDate(),srNo,candidate.getTxtEmployeeNo());
	}
	/*
	@Override
	public void deleteArticle(int articleId) {
		String sql = "DELETE FROM articles WHERE articleId=?";
		jdbcTemplate.update(sql, articleId);
	}
	*/
	
	@Override
	public boolean candidateExists(String employeeId) {
		String sql = "SELECT count(*) FROM candidates WHERE  Infosys_EmpNo = ? ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class,employeeId );
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}

	@Override
	public List<ContractRole> getAllContractRoles() {
		String sql = "select contractRole from contractrole";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<ContractRole> rowMapper = new ContractRoleRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void deleteCandidate(String employeeID) {
		String sql="select EmpId from candidates where Infosys_EmpNo=?";
		int empId = jdbcTemplate.queryForObject(sql, Integer.class, employeeID);
		sql = "update candidates set flag=1 where EmpId=? and Infosys_EmpNo=?";
		jdbcTemplate.update(sql,empId,employeeID);
		sql="select SrNo from latestcandidatedetails where Infosys_EmpNo=?";
		int srNo = jdbcTemplate.queryForObject(sql, Integer.class, employeeID);
		sql="update latestcandidatedetails set flag=1 where Infosys_EmpNo=? and SrNo=?";
		jdbcTemplate.update(sql,employeeID,srNo);
	}

	@Override
	public List<CountInformation> getAllCountInformation() {
		// TODO Auto-generated method stub
		String sql = "select(SELECT count(*) as offboarded FROM latestcandidatedetails where Offboarding_Date<CURDATE())as offBoraded,(SELECT count(*) as onboarded FROM latestcandidatedetails where Offboarding_Date>CURDATE() or Offboarding_Date is null)as onBoarded";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<CountInformation> rowMapper = new CountInformationRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public boolean demandExists(String demandId) {
		String sql = "select count(*) from latestdemands where Demand_ID=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class,demandId );
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}

	@Override
	public void addDemand(Demand addDemand) {
		String sql="select GroupID from groupdetails where GroupInfo=?";
		int groupId = jdbcTemplate.queryForObject(sql, Integer.class, addDemand.getGroupName());
		 sql="insert into latestdemands(Demand_ID,Group_ID,JDRole,Contract_Roles,Skill_Type,Role_Technology_Mapping,Technology_Group,Relevant_Exp,PSO_Owner,raised_On,Need_By,Status)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, addDemand.getDemandId(),groupId,addDemand.getJdRole(), addDemand.getContractRoles(), addDemand.getSkillType(),addDemand.getRoleTechnologyMapping(), addDemand.getTechnologyGroup(),addDemand.getRelevantExperience(),addDemand.getPsoOwner(),addDemand.getRaisedOn(),addDemand.getNeedBy(),addDemand.getStatus());
		
	}

	@Override
	public void updateDemand(Demand demand) {
		String sql="select GroupID from groupdetails where GroupInfo=?";
		int groupId = jdbcTemplate.queryForObject(sql, Integer.class, demand.getGroupName());
		sql="select SrNo from latestdemands where Demand_ID=?";
		int srNo = jdbcTemplate.queryForObject(sql, Integer.class, demand.getDemandId());
		 sql = "UPDATE latestdemands SET Group_ID=?, JDRole=?, Contract_Roles=?, Skill_Type=?,Role_Technology_Mapping=?,Technology_Group=?,Relevant_Exp=?,PSO_Owner=?,raised_On=?,Need_By=?,Status=? WHERE Demand_ID=? and SrNo=?";
		jdbcTemplate.update(sql, groupId, demand.getJdRole(), demand.getContractRoles(),demand.getSkillType(), demand.getRoleTechnologyMapping(),demand.getTechnologyGroup(),demand.getRelevantExperience(),demand.getPsoOwner(),demand.getRaisedOn(),demand.getNeedBy(),demand.getStatus(),demand.getDemandId(),srNo);
		
	}

	@Override
	public List<GroupName> getgroupNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT groupInfo FROM groupdetails";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<GroupName> rowMapper = new GroupNameRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void deleteDemand(String demand) {
		String sql="SELECT SrNo from latestdemands where Demand_ID=?";
		int srNo = jdbcTemplate.queryForObject(sql, Integer.class, demand);
		sql = "update latestdemands set status='abandoned' where SrNo=? and Demand_ID=?";
		jdbcTemplate.update(sql,srNo,demand);
		
	}

	@Override
	public List<DemandCountInformation> getAllDemandCountInformation() {
		// TODO Auto-generated method stub
		String sql ="select (select count(*) from latestdemands where Demand_ID!='')as totalDemands,(select count(*) from latestdemands where status='hold') as totalHold,(select count(*) from latestdemands where status='abandoned') as totalAbandoned,(select count(*) from latestdemands where status='active') as totalActive";
		RowMapper<DemandCountInformation> rowMapper = new DemandCountInformationRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<DemandMapping> getAllMappedDemands() {
		String sql="select ldm.Demand_ID,ldm.GroupID,gd.GroupInfo,"+
		"ldm.Contract_Role,ldm.InfosysEmpNo,ldm.Name,"+
		"ldm.Cust_Role_Mapping,ldm.Profile_Shared_Date,"+
		"ldm.Interview_Date,ldm.Client_Confirmation_Date,"+
		"ldm.PSO_Status,ldm.Onboarding_Status,ldm.Comments "+
		"from latestdemandmapping ldm "+  
		"inner join  groupdetails gd on ldm.GroupID=gd.GroupID";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<DemandMapping> rowMapper = new DemandMappingRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
		
	}

	@Override
	public boolean mappingExists(String demandId) {
		String sql = "select count(*) from latestdemandmapping where Demand_ID=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class,demandId);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}

	@Override
	public void addDemandMapping(DemandMapping demandMapping) {
		String sql="select GroupID from groupdetails where GroupInfo=?";
		int groupId = jdbcTemplate.queryForObject(sql, Integer.class, demandMapping.getGroupName());
		 sql="insert into latestdemandmapping(Demand_ID,GroupID,Contract_Role,InfosysEmpNo,Name,Cust_Role_Mapping,Profile_Shared_Date,Interview_Date,Client_Confirmation_Date,PSO_Status,Onboarding_Status,Comments)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, demandMapping.getDemandId(),groupId,demandMapping.getContractRole(), demandMapping.getInfosysEmpNo(), demandMapping.getName(),demandMapping.getCustomeRoleMapping(),demandMapping.getProfileSharedDate(),demandMapping.getInterviewDate(),demandMapping.getClientInformationDate(),demandMapping.getPsoStatus(),demandMapping.getOnboardingStatus(),demandMapping.getComments());
		
	}

	@Override
	public void updateDemandMapping(DemandMapping demandMapping) {
		String sql="select map_id from latestdemandmapping where Demand_ID=?";
		String mapId = jdbcTemplate.queryForObject(sql, String.class, demandMapping.getDemandId());
		sql="select GroupID from groupdetails where GroupInfo=?";
		int groupId = jdbcTemplate.queryForObject(sql, Integer.class, demandMapping.getGroupName());
		 sql = "UPDATE latestdemandmapping SET GroupID=?, Contract_Role=?, InfosysEmpNo=?, Name=?,Cust_Role_Mapping=?,Profile_Shared_Date=?,Interview_Date=?,Client_Confirmation_Date=?,PSO_Status=?,Onboarding_Status=?,Comments=? WHERE Demand_ID=? and map_id=?";
		jdbcTemplate.update(sql, groupId, demandMapping.getContractRole(), demandMapping.getInfosysEmpNo(),demandMapping.getName(), demandMapping.getCustomeRoleMapping(),demandMapping.getProfileSharedDate(),demandMapping.getInterviewDate(),demandMapping.getClientInformationDate(),demandMapping.getPsoStatus(),demandMapping.getOnboardingStatus(),demandMapping.getComments(),demandMapping.getDemandId(),mapId);
	}

	@Override
	public void addExcelData() 
	{
		try 
		{
		
		String sql="REPLACE into latestcandidatedetails(Infosys_EmpNo, Name, Contract_Role,Onboarding_Date,NCS_ID,NCS_Email,Status,Offboarding_Date,SrNo,flag) VALUES(?,?,?,?,?,?,?,?,?,?)";
		 fis = new FileInputStream(new File("WriteSheet.xlsx"));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      Iterator < Row >  rowIterator = spreadsheet.iterator();
	      while (rowIterator.hasNext()) {
	         row = (XSSFRow) rowIterator.next();
	         if(row.getRowNum()>0)
	         {
	         Iterator < Cell >  cellIterator = row.cellIterator();
	         while ( cellIterator.hasNext()) {
	            Cell cell = cellIterator.next();
	            if(cell.getColumnIndex()==0)
	            {
	            	employeeNo=(int)cell.getNumericCellValue();
	            }
	            else if(cell.getColumnIndex()==1)
	            {
	            	name=cell.getStringCellValue();
	            }
	            else if(cell.getColumnIndex()==2)
	            {
	            	contractRole=cell.getStringCellValue();
	            }
	            else if(cell.getColumnIndex()==3)
	            {
	            	onboardingDate=cell.getDateCellValue();
	            }
	            else if(cell.getColumnIndex()==4)
	            {
	            	ncsId=cell.getStringCellValue();
	            }
	            else if(cell.getColumnIndex()==5)
	            {
	            	ncsEmail=cell.getStringCellValue();
	            }
	            else if(cell.getColumnIndex()==6)
	            {
	            	status=cell.getStringCellValue();
	            }
	            else if(cell.getColumnIndex()==7)
	            {
	            	offboardingDate=cell.getDateCellValue();
	            }
	            else if(cell.getColumnIndex()==8)
	            {
	            	srNo=(int)cell.getNumericCellValue();
	            }
	              
	            else if(cell.getColumnIndex()==9)
	            {
	            	flag=(int)cell.getNumericCellValue();
	            }
	        
	         }
	         jdbcTemplate.update(sql, employeeNo,name,contractRole,onboardingDate,ncsId, ncsEmail, status,offboardingDate,srNo,flag);
	         
	      }
	         
	      }
	      
	 //     con.close();

		}
	catch(

	Exception e)

	{
System.out.println(e);
	}
		finally
	{
try {
	fis.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	}
}

	

	



