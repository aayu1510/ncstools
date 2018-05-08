package com.concretepage.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.AddCandidate;
import com.concretepage.entity.Candidate;
import com.concretepage.entity.ContractRole;
import com.concretepage.entity.CountInformation;
import com.concretepage.entity.Demand;
import com.concretepage.entity.DemandCountInformation;
import com.concretepage.entity.GroupName;
import com.concretepage.entity.Model;
import com.concretepage.entity.demand.mapping.DemandMapping;
import com.concretepage.service.IModelService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("employee")
public class ModelController {
	@Autowired
	private IModelService modelService;
	 private static String UPLOADED_FOLDER = "D://temp//";
	@GetMapping("candidates/{id}")
	public ResponseEntity<Candidate> getArticleById(@PathVariable("id") Integer id) {
		Candidate candidate = modelService.getCandidateById(id);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}
	/*@GetMapping("candidates/error")
	public String displayException() {
		return "invalid employee  id";
		
	}*/
	@GetMapping("model")
	public ResponseEntity<List<Model>> getAllEmployees() {
		List<Model> list = modelService.getAllEmployees();
		return new ResponseEntity<List<Model>>(list, HttpStatus.OK);
	}
	
	@GetMapping("candidates")
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		List<Candidate> list = modelService.getAllCandidates();
		return new ResponseEntity<List<Candidate>>(list, HttpStatus.OK);
	}
	@GetMapping("demands")
	public ResponseEntity<List<Demand>> getAlldemands() {
		List<Demand> list = modelService.getAllDemands();
		return new ResponseEntity<List<Demand>>(list, HttpStatus.OK);
	}
	
	 @RequestMapping(value = "demand", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> addDemand(@RequestBody Demand demand, UriComponentsBuilder builder) {
     boolean flag = modelService.addDemand(demand);
     if (flag == false) {
     	 Map<String, Object> userValue = new HashMap<String, Object>();
 		 userValue.put("message", "demand already exist");
 		 userValue.put("status", HttpStatus.CONFLICT);
 		 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CONFLICT);
     }
     else
     {
     HttpHeaders headers = new HttpHeaders();
     headers.setLocation(builder.path("/demand/{id}").buildAndExpand(demand.getDemandId()).toUri());
     Map<String, Object> userValue = new HashMap<String, Object>();
		 userValue.put("message", "demand has been created sucessfully");
		 userValue.put("status", HttpStatus.CREATED);
		 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CREATED);
     }
     
	}
	 
	 @PutMapping("demand")
		public ResponseEntity<Demand> updateDeamnd(@RequestBody Demand demand) {
			modelService.updateDemand(demand);
			return new ResponseEntity<Demand>(demand, HttpStatus.OK);
		}
	
	  @RequestMapping(value = "candidate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> addArticle(@RequestBody AddCandidate candidate, UriComponentsBuilder builder) {
        boolean flag = modelService.addCandidate(candidate);
        if (flag == false) {
        	 Map<String, Object> userValue = new HashMap<String, Object>();
    		 userValue.put("message", "User already exist");
    		 userValue.put("status", HttpStatus.CONFLICT);
    		 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CONFLICT);
        }
	//	modelService.addCandidate(candidate);
        else
        {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/candidate/{id}").buildAndExpand(candidate.getTxtEmployeeNo()).toUri());
        Map<String, Object> userValue = new HashMap<String, Object>();
		 userValue.put("message", "User has been created sucessfully");
		 userValue.put("status", HttpStatus.CREATED);
		 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CREATED);
        }
        
	}
	  
	  @DeleteMapping("demand/{id}")
		public ResponseEntity<Void> deleteDemand(@PathVariable("id") String demand) {
			modelService.deleteDemand(demand);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	  
	  @GetMapping("groupnames")
		public ResponseEntity<List<GroupName>> getgroupNames() {
			List<GroupName> list = modelService.getgroupNames();
			return new ResponseEntity<List<GroupName>>(list, HttpStatus.OK);
		}
		
		
	
	@GetMapping("model/newCandidates")
	public ResponseEntity<List<Candidate>> getAllNewCandidates() {
		List<Candidate> list = modelService.getAllNewCandidates();
		return new ResponseEntity<List<Candidate>>(list, HttpStatus.OK);
	}
	
	@GetMapping("contractroles")
	public ResponseEntity<List<ContractRole>> getContractRoles() {
		List<ContractRole> list = modelService.getAllContractRoles();
		return new ResponseEntity<List<ContractRole>>(list, HttpStatus.OK);
	}
	
	
	
	@PutMapping("candidate")
	public ResponseEntity<AddCandidate> updateCandidate(@RequestBody AddCandidate candidate) {
		modelService.updateCandidate(candidate);
		return new ResponseEntity<AddCandidate>(candidate, HttpStatus.OK);
	}
	
	@DeleteMapping("candidate/{id}")
	public ResponseEntity<Void> deleteCandidate(@PathVariable("id") String employeeNumber) {
		modelService.deleteCandidate(employeeNumber);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("countInformation")
	public ResponseEntity<List<CountInformation>> getCountInformation() {
		List<CountInformation> list = modelService.getAllCountInformation();
		return new ResponseEntity<List<CountInformation>>(list, HttpStatus.OK);
	}
	
	@GetMapping("demandCount")
	public ResponseEntity<List<DemandCountInformation>> getdemandCount() {
		List<DemandCountInformation> list = modelService.getAllDemandCountInformation();
		return new ResponseEntity<List<DemandCountInformation>>(list, HttpStatus.OK);
	}
	
	@GetMapping("demandMapping")
	public ResponseEntity<List<DemandMapping>> getAllMappeddemands() {
		List<DemandMapping> list = modelService.getAllMAppedDemands();
		return new ResponseEntity<List<DemandMapping>>(list, HttpStatus.OK);
	}
	
	  @RequestMapping(value = "demandMapping", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
			public ResponseEntity<Map<String, Object>> addDemandMapping(@RequestBody DemandMapping demandMapping, UriComponentsBuilder builder) {
	        boolean flag = modelService.addDemandMapping(demandMapping);
	        if (flag == false) {
	        	 Map<String, Object> userValue = new HashMap<String, Object>();
	    		 userValue.put("message", "User already exist");
	    		 userValue.put("status", HttpStatus.CONFLICT);
	    		 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CONFLICT);
	        }
		//	modelService.addCandidate(candidate);
	        else
	        {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/candidate/{id}").buildAndExpand(demandMapping.getInfosysEmpNo()).toUri());
	        Map<String, Object> userValue = new HashMap<String, Object>();
			 userValue.put("message", "User has been created sucessfully");
			 userValue.put("status", HttpStatus.CREATED);
			 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CREATED);
	        }
	        
		}
	  
	  @PutMapping("demandMapping")
		public ResponseEntity<DemandMapping> updateDemandMapping(@RequestBody DemandMapping demandMapping) {
			modelService.updateDemandMapping(demandMapping);
			return new ResponseEntity<DemandMapping>(demandMapping, HttpStatus.OK);
		}
	  
	  @RequestMapping(value = "candidatesinexcel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> addCandidatesForExcel() {
		  modelService.addExcelData();
      	 Map<String, Object> userValue = new HashMap<String, Object>();
  		 userValue.put("message", "excel data added");
  		 userValue.put("status", HttpStatus.ACCEPTED);
  		 return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.ACCEPTED);
      }

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> myService(@RequestParam("file") MultipartFile file) {

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			Map<String, Object> userValue = new HashMap<String, Object>();
			userValue.put("message", "file uploaded");
			userValue.put("status", HttpStatus.ACCEPTED);
			return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.ACCEPTED);
		} catch (IOException e) {
			e.printStackTrace();
			Map<String, Object> userValue = new HashMap<String, Object>();
			userValue.put("message", "file not found");
			userValue.put("status", HttpStatus.CONFLICT);
			return new ResponseEntity<Map<String, Object>>(userValue, HttpStatus.CONFLICT);

		}
	}

     
} 