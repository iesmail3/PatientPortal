package imran.patient_portal.database;

import imran.patient_portal.model.Diagnosis;
import imran.patient_portal.model.Patient;

import java.util.HashMap; 
import java.util.Map;

public class DatabaseClass {
	
	
	private static Map<Long, Diagnosis> diagnosis = new HashMap<>();
	private static Map<String, Patient> patients = new HashMap<>();
	
	
	public static Map<Long,Diagnosis> getDiagnosis(){ 
		return diagnosis; 		
	}
	
	public static Map<String,Patient> getPatients(){ 
		return patients; 		
	}
}
