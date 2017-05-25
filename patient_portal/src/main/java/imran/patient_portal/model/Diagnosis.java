package imran.patient_portal.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement //this is a JAXB code that enables the results to be returned as XML
public class Diagnosis {
	
	private long id; 
	private String name; 
	private Date created; 
	private String description; 
	
	private Map<Long,Medication> medications = new HashMap<>(); 
	
	
	//no arg constructor will be used in response (while converting the response to xml or json)
	public Diagnosis(){ 
		
	}
	public Diagnosis(long id, String name, String description) {
		this.id = id;
		this.setName(name);
		this.created = new Date();
		this.setDescription(description);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	@XmlTransient //this notation hides the comments associated with a particular message when you just want to access the message via msg id. 
	public Map<Long, Medication> getMedications() {
		return medications;
	}
	public void setMedications(Map<Long, Medication> medications) {
		this.medications = medications;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
