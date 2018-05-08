package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IModelDAO;
import com.concretepage.entity.AddCandidate;
import com.concretepage.entity.Candidate;
import com.concretepage.entity.ContractRole;
import com.concretepage.entity.CountInformation;
import com.concretepage.entity.Demand;
import com.concretepage.entity.DemandCountInformation;
import com.concretepage.entity.GroupName;
import com.concretepage.entity.Model;
import com.concretepage.entity.demand.mapping.DemandMapping;
@Service
public class ModelService implements IModelService {
	@Autowired
	private IModelDAO articleDAO;
	@Override
	public Candidate getCandidateById(int candidateId) {
		Candidate obj = articleDAO.getCandidateById(candidateId);
		return obj;
	}	
	@Override
	public List<Model> getAllEmployees(){
		return articleDAO.getAllEmployees();
	}
	
	@Override
	public List<Candidate> getAllCandidates(){
		return articleDAO.getAllCandidates();
	}
	
	@Override
	public List<Demand> getAllDemands(){
		return articleDAO.getAllDemands();
	}
	@Override
	public boolean addCandidate(AddCandidate addCandidate) {
		if (articleDAO.candidateExists(addCandidate.getTxtEmployeeNo())) {
	    	   return false;
	       } else {
	    	   articleDAO.addCandidate(addCandidate);
	    	   return true;
	       }
		
	}
	
	@Override
	public List<Candidate> getAllNewCandidates(){
		return articleDAO.getAllNewCandidates();
	}
	
	
	/*@Override
	public synchronized boolean addCandidate(AddCandidate candidate){
       
	}*/
	@Override
	public void updateCandidate(AddCandidate candidate) {
		articleDAO.updateCandidate(candidate);
	}
	@Override
	public List<ContractRole> getAllContractRoles() {
		// TODO Auto-generated method stub
		return articleDAO.getAllContractRoles();
	}
	@Override
	public void deleteCandidate(String employeeNumber) {
		// TODO Auto-generated method stub
		articleDAO.deleteCandidate(employeeNumber);
	}
	@Override
	public List<CountInformation> getAllCountInformation() {
		return articleDAO.getAllCountInformation();
	}
	@Override
	public boolean addDemand(Demand addDemand) {
		if (articleDAO.demandExists(addDemand.getDemandId())) {
	    	   return false;
	       } else {
	    	   articleDAO.addDemand(addDemand);
	    	   return true;
	       }
	}
	@Override
	public void updateDemand(Demand demand) {
		articleDAO.updateDemand(demand);
		
	}
	@Override
	public List<GroupName> getgroupNames() {
		// TODO Auto-generated method stub
		return articleDAO.getgroupNames();
	}
	
	@Override
	public void deleteDemand(String demand) {
		articleDAO.deleteDemand(demand);
		
	}
	@Override
	public List<DemandCountInformation> getAllDemandCountInformation() {
		// TODO Auto-generated method stub
		return articleDAO.getAllDemandCountInformation();
	}
	@Override
	public List<DemandMapping> getAllMAppedDemands() {
		// TODO Auto-generated method stub
		return articleDAO.getAllMappedDemands();
	}
	@Override
	public boolean addDemandMapping(DemandMapping demandMapping) {
		if (articleDAO.mappingExists(demandMapping.getDemandId())) {
	    	   return false;
	       } else {
	    	   articleDAO.addDemandMapping(demandMapping);
	    	   return true;
	       }
	}
	@Override
	public void updateDemandMapping(DemandMapping demandMapping) {
		articleDAO.updateDemandMapping(demandMapping);
		
	}
	@Override
	public void addExcelData() {
		articleDAO.addExcelData();
		
	}
		
}
	
	
	/*@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}*/

