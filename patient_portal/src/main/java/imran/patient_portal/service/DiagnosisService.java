package imran.patient_portal.service;

import imran.patient_portal.database.DatabaseClass;
import imran.patient_portal.model.Diagnosis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class DiagnosisService {

	private Map<Long,Diagnosis> diagnoses = DatabaseClass.getDiagnosis();
	
	//Since we are not connecting to DB, our message map is empty. 
	// Will  use this constructor to create two messages just to get a non empty response 
	public DiagnosisService(){ 
		
		diagnoses.put(1L, new Diagnosis(1, " Seasonal Allergy", "Watery nose and itchy eyes")); 
		diagnoses.put(2L, new Diagnosis(2, "Hair Loss", "Rapid baldness and weakness"));
	}
	
	public List<Diagnosis> getAllDiagnosis(){ 		
		 
		return new ArrayList<Diagnosis>(diagnoses.values()); 
	}
	
	public List<Diagnosis> getAllDiagnosisForYear(int year){
		List<Diagnosis> diagnosisForYear = new ArrayList<>(); 
		Calendar cal = Calendar.getInstance(); 
		for(Diagnosis diagnosis: diagnoses.values()){ 
			cal.setTime(diagnosis.getCreated()); 
			if(cal.get(Calendar.YEAR) == year){ 
				diagnosisForYear.add(diagnosis); 
			}
			
		}
		return diagnosisForYear; 	
	}
	
	public List<Diagnosis> getAllDiagnosisPaginated(int start, int size){
		
		ArrayList<Diagnosis> list = new ArrayList<Diagnosis>(diagnoses.values()); 
		if(start + size > list.size()) new ArrayList<Diagnosis>(); 
		
		return list.subList(start,start + size);	
	}
	
	public Diagnosis getDiagnosis(long id) 
	{ 
		
		return diagnoses.get(id); 
	}
	public Diagnosis addDiagnosis(Diagnosis diagnosis){ 
		
		diagnosis.setId(diagnoses.size() + 1);
		diagnoses.put(diagnosis.getId(), diagnosis); 
		return diagnosis; 
	}
	
	public Diagnosis updateDiagnosis(Diagnosis diagnosis){ 
		
		if(diagnosis.getId() <= 0) 
			return null; 
		diagnoses.put(diagnosis.getId(), diagnosis); 
		return diagnosis; 
	}
	
	public Diagnosis removeDiagnosis(long id){ 
		
		return diagnoses.remove(id); 
	}
}
