package imran.patient_portal.resources;

import imran.patient_portal.model.Patient;
import imran.patient_portal.service.PatientService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("patients")
public class PatientResource {
	
	
	private PatientService patientService = new PatientService(); 
	
	 
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Patient> getPatients(){ 
		return patientService.getAllPatients(); 
	}
	 
	
	@GET 
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("profileName") String profileName){ 
		return patientService.getPatient(profileName); 
	}

	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Patient addPatient(Patient patient){ 
		return patientService.addPatient(patient);
		 
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Patient updatePatient(@PathParam("profileName") String profileName,Patient patient){ 
		 patient.setProfileName(profileName);
		return patientService.updatePatient(patient);
	} 
	
	@DELETE 
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName") String profileName){ 
		patientService.removePatient(profileName); 
	}

}
