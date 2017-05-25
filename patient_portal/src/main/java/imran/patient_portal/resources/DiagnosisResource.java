package imran.patient_portal.resources;

import imran.patient_portal.model.Diagnosis;
import imran.patient_portal.resources.bean.MessageFilterBean;
import imran.patient_portal.service.DiagnosisService;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("diagnoses")   
public class DiagnosisResource {
	
	
	DiagnosisService diagnosisService = new DiagnosisService(); 
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Diagnosis> getDiagnosis(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0) 
			return diagnosisService.getAllDiagnosisForYear(filterBean.getYear());
		
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return diagnosisService.getAllDiagnosisPaginated(filterBean.getStart(), filterBean.getSize());
			
		}
		
		return diagnosisService.getAllDiagnosis(); 
	}
	 
	
	@GET 
	@Path("/{diagnosisId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Diagnosis getDiagnosis(@PathParam("diagnosisId") long id){ 
		return diagnosisService.getDiagnosis(id); 
	}

	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Diagnosis addDiagnosis(Diagnosis diagnosis){ 
		return diagnosisService.addDiagnosis(diagnosis);
		 
	}
	
	@PUT
	@Path("/{diagnosisId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Diagnosis updateDiagnosis(@PathParam("diagnosisId") long id,Diagnosis diagnosis){ 
		diagnosis.setId(id); 
		return diagnosisService.updateDiagnosis(diagnosis);
	} 
	
	@DELETE 
	@Path("/{diagnosisId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("diagnosisId") long id){ 
		diagnosisService.removeDiagnosis(id); 
	}
	

	@Path("/{diagnosisId}/medications")
	public MedicationResource getMedicationResource(){ 
		return new MedicationResource();
	}
	
}
	
