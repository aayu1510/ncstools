package com.concretepage.dao;
import java.util.List;

import com.concretepage.entity.AddCandidate;
import com.concretepage.entity.Candidate;
import com.concretepage.entity.ContractRole;
import com.concretepage.entity.CountInformation;
import com.concretepage.entity.Demand;
import com.concretepage.entity.DemandCountInformation;
import com.concretepage.entity.GroupName;
import com.concretepage.entity.Model;
import com.concretepage.entity.demand.mapping.DemandMapping;
public interface IModelDAO {
    List<Model> getAllEmployees();
    List<Candidate> getAllNewCandidates();
    List<Candidate> getAllCandidates();
    List<Demand> getAllDemands();
    List<ContractRole> getAllContractRoles();
   Candidate getCandidateById(int candidateId);
void addCandidate(AddCandidate addCandidate);
/*boolean articleExists(String employeeNumber);*/
  //  void addArticle(Article article);
    void updateCandidate(AddCandidate candidate);
    void deleteCandidate(String employeeID);
    /* boolean articleExists(String title, String category);*/
	boolean candidateExists(String employeeId);
	List<CountInformation> getAllCountInformation();
	boolean demandExists(String demandId);
	void addDemand(Demand addDemand);
	void updateDemand(Demand demand);
	List<GroupName> getgroupNames();
	void deleteDemand(String demand);
	List<DemandCountInformation> getAllDemandCountInformation();
	List<DemandMapping> getAllMappedDemands();
	boolean mappingExists(String demandId);
	void addDemandMapping(DemandMapping demandMapping);
	void updateDemandMapping(DemandMapping demandMapping);
	void addExcelData();
}
 