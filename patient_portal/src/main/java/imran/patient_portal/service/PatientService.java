package imran.patient_portal.service;

import imran.patient_portal.database.DatabaseClass;
import imran.patient_portal.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PatientService {

	
	private Map<String, Patient> patients =  DatabaseClass.getPatients(); 
	
	
	public PatientService(){ 
		
		patients.put("Imran", new Patient(1L, "Imran", "Imran", "Esmail"));
	}
	
	public List<Patient> getAllPatients(){ 
		
		return new ArrayList<Patient>(patients.values()); 
	}
	
	
	public Patient getPatient(String profileName) { 
		
		return patients.get(profileName);
	}
	public Patient addPatient(Patient patient) { 
		
		patient.setId(patients.size() + 1);
		patients.put(patient.getProfileName(), patient); 
		return patient; 
		
	}
	
	public Patient updatePatient(Patient patient) 
	{ 
		if(patient.getProfileName().isEmpty())
			return null; 
		
		patients.put(patient.getProfileName(), patient); 
		return patient; 
		
	}
	
	public Patient removePatient(String profileName) { 
		
		return patients.remove(profileName); 
		
	}
}
