package imran.patient_portal.model;

import java.util.Date;

public class Medication {
	

	private long id;
    private String name;
    private Date administeredDate;
    private String dosage;
    
    public Medication() {
    	
    }
    
    public Medication(long id, String name, String dosage) {
    	this.id = id;
    	this.name = name; 
    	this.dosage = dosage;
    	this.administeredDate = new Date();
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 
	public Date getCreated() {
		return administeredDate;
	}
	public void setCreated(Date created) {
		this.administeredDate = created;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    

}
