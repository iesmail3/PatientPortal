# PatientPortal

The following tutorial will show you how to perform CRUD opertions using chrome's postman plugin. 
                                  
                                  *********************** GET REQUESTS*****************************
1) GET ALL Patients 

  To get all the patients, use the following link: http://localhost:8080/patient_portal/webapi/patients 

2) GET One Patient 

  To get a specific patient, you can search by the patient's last name : http://localhost:8080/patient_portal/webapi/patients/Imran

3) GET ALL Diagnoses 

  To get a list of diagnoses, use the following link: http://localhost:8080/patient_portal/webapi/diagnoses

4) GET specific Diagnosis 

  To get a specific diagnosis, you can search by the diagnosis ID : http://localhost:8080/patient_portal/webapi/diagnoses/1

5) GET ALL Medications Related to a Diagnosis 

  If you would like to see the prescribed medications for a specific diagnosis, then use diagnosis ID followed by /medications: 
  http://localhost:8080/patient_portal/webapi/diagnoses/1/medications

6) GET One Medication For Some Diagnosis ID 

  Just provide the diagnosis and medication IDs: http://localhost:8080/patient_portal/webapi/diagnoses/1/medications/2
  
  
                                             ***************POST REQUESTS ***************************
                                             
  7) ADD PATIENT/MEDICATIONS/DIAGNOSES 
  
   Step 1: Make sure you add a key value pair for the contentype = json in the header section. (Key = ContentType, Value= application/json)

 Step 2: Use the following link: http://localhost:8080/patient_portal/webapi/patients and choose POST as your HTTP request. 
 
 The same approach can be applied while adding medications and diagnosis medications and diagnosis. 
 
 
                               ****************PUT REQUESTS******************************
                               
    8) UPDATE a PATIENT / MEDICATION / DIAGNOSIS 
    
    Add the key/value pair in the header section. 
    
   Choose PUT as your HTTP request. 
   
   
                          ***********************DELETE REQUESTS*************************
                          
    9)  DELETE PATIENT(S) / MEDICATION(S) / DIAGNOSES 
    
    To delete a patient, choose the DELETE HTTP request. 
   
    



