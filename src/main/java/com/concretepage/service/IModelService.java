package com.concretepage.service;

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

public interface IModelService {
     List<Model> getAllEmployees();
     List<Candidate> getAllCandidates();
     List<Demand> getAllDemands();
     List<ContractRole> getAllContractRoles();
     Candidate getCandidateById(int candidateId);
     boolean addCandidate(AddCandidate addCandidate);
     boolean addDemand(Demand addDemand);
     List<Candidate> getAllNewCandidates();
  // boolean add(Article article);
    void updateCandidate(AddCandidate candidate);
   // void deleteArticle(int articleId);*/
	void deleteCandidate(String employeeNumber);
	List<CountInformation> getAllCountInformation();
	void updateDemand(Demand demand);
	List<GroupName> getgroupNames();
	void deleteDemand(String demand);
	List<DemandCountInformation> getAllDemandCountInformation();
	List<DemandMapping> getAllMAppedDemands();
	boolean addDemandMapping(DemandMapping demandMapping);
	void updateDemandMapping(DemandMapping demandMapping);
	void addExcelData();	
}
