package imran.patient_portal.resources;

import imran.patient_portal.model.Medication;
import imran.patient_portal.service.MedicationService;

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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MedicationResource {

	private MedicationService medicationService = new MedicationService();
	
	@GET
	public List<Medication> getAllMedications(@PathParam("diagnosisId") long diagnosisId) {
		return medicationService.getAllMedications(diagnosisId);
	}
	
	@POST
	public Medication addMedication(@PathParam("diagnosisId") long diagnosisId, Medication medication) {
		return medicationService.addMedication(diagnosisId, medication);
	}
	
	@PUT
	@Path("/{medicationId}")
	public Medication updateMedication(@PathParam("diagnosisId") long diagnosisId, @PathParam("medicationId") long id, Medication medication) {
		medication.setId(id);
		return medicationService.updateMedication(diagnosisId, medication);
	}
	
	@DELETE
	@Path("/{medicationId}")
	public void deleteComment(@PathParam("diagnosisId") long diagnosisId, @PathParam("medicationId") long medicationId) {
		medicationService.removeMedication(diagnosisId, medicationId);
	}
	
	
	@GET
	@Path("/{medicationId}")
	public Medication getMessage(@PathParam("diagnosisId") long diagnosisId, @PathParam("medicationId") long medicationId) {
		return medicationService.getMedication(diagnosisId, medicationId);
	}
	
}
