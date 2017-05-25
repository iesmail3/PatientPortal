package imran.patient_portal.service;

import imran.patient_portal.database.DatabaseClass;
import imran.patient_portal.model.Medication;
import imran.patient_portal.model.Diagnosis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicationService {
	
	private Map<Long, Diagnosis> diagnosis = DatabaseClass.getDiagnosis();
	
	public MedicationService() {
		
		 //create medications for diag1
		Map<Long,Medication> medicationforDiag1 = new HashMap<>();  
		medicationforDiag1.put(1L, new Medication(1,"Cortisol", "Twice a day"));
		medicationforDiag1.put(2L, new Medication(2,"Asporin", "After lunch"));
		//set the medications for diag1  
		diagnosis.get(1L).setMedications(medicationforDiag1);
		//create medications for diag2
		Map<Long,Medication> medicationforDiag2 = new HashMap<>();  
		medicationforDiag2.put(1L, new Medication(1,"Finesteride", "Every day"));
		medicationforDiag2.put(2L, new Medication(2,"Lucozade", "Every four hours"));
		//set the medications for diag2
		diagnosis.get(2L).setMedications(medicationforDiag2);
		
	}
	
	public List<Medication> getAllMedications(long diagnosisId) {
		Map<Long, Medication> medications = diagnosis.get(diagnosisId).getMedications();
		return new ArrayList<Medication>(medications.values());
	}
	
	public Medication getMedication(long diagnosisId, long commentId) {
		Map<Long, Medication> medications = diagnosis.get(diagnosisId).getMedications();
		return medications.get(commentId);
	}
	
	public Medication addMedication(long diagnosisId, Medication medication) {
		Map<Long, Medication> medications = diagnosis.get(diagnosisId).getMedications();
		medication.setId(medications.size() + 1);
		medications.put(medication.getId(), medication);
		return medication;
	}
	
	public Medication updateMedication(long diagnosisId, Medication medication) {
		Map<Long, Medication> medications = diagnosis.get(diagnosisId).getMedications();
		if (medication.getId() <= 0) {
			return null;
		}
		medications.put(medication.getId(), medication);
		return medication;
	}
	
	public Medication removeMedication(long diagnosisId, long medicationId) {
		Map<Long, Medication> medications = diagnosis.get(diagnosisId).getMedications();
		return medications.remove(medicationId);
	}
		
}
