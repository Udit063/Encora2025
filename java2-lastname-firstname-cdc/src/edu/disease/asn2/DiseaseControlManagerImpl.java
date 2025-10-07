package edu.disease.asn2;
import edu.disease.asn1.Exposure;

import java.util.Arrays;
import java.util.UUID;

public class DiseaseControlManagerImpl implements DiseaseControlManager {
	private Disease[] diseases;
	private Patient[] patients;
	int maxDisease = 0;
	int maxPatient = 0;
	UUID id3 = UUID.randomUUID();
	UUID id4 = UUID.randomUUID();
	Disease infect = new InfectiousDisease("dengue", id3);
	Disease nonInfect = new NonInfectiousDisease("thyroid", id4);
	
	public DiseaseControlManagerImpl(int maxDiseases, int maxPatients)throws IllegalArgumentException {
		try {
			if(maxDiseases <= 0 || maxPatients <= 0) {
				throw new IllegalArgumentException("Please enter proper integer...");
			} else {
				diseases = new Disease[maxDiseases];
				patients = new Patient[maxPatients];
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("Please enter an integer...");
		}
	}
	
	@Override
	public Disease addDisease(String name, Boolean infectious) throws IllegalStateException {
		try {
			if(maxDisease < diseases.length) {	
				Disease d = null;
				if(infectious) {
					d = new InfectiousDisease(name, UUID.randomUUID());
					diseases[maxDisease++] = d;
					return d;
				} else {
					d = new NonInfectiousDisease(name, UUID.randomUUID());
					diseases[maxDisease++] = d;
					return d;
				}
				} else {
					throw new IllegalStateException("No more diseases can be added...");
				}
		} catch(Exception e) {
			throw new IllegalStateException("No more diseases can be added...");
		}
	} 
	
	@Override
	public Disease getDisease(UUID diseaseId) {
		for(Disease i : diseases) {
			if(i!= null && i.getDiseaseId().equals(diseaseId)) {
				return i;
			}
		} 
		return null;   
	}
	
	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) throws IllegalStateException {
		try { 
			if(maxPatient < patients.length) {
				Patient p = new Patient(maxDiseases, maxExposures);
				p.setPatientId(UUID.randomUUID());
				p.setFirstName(firstName);
				p.setLastName(lastName);
				patients[maxPatient++] = p;
				return p;
			} else {
				throw new IllegalStateException("No more patients can be added..."); 
			}
		} catch(Exception e) {
			throw new IllegalStateException("No more patients can be added...");
		}
	}
	
	@Override
	public Patient getPatient(UUID patientId) {
		for(Patient p : patients) {
			if(p.patientId == patientId) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) throws IllegalArgumentException {
		Patient pat = null;
		Disease dis = null;
		for(Patient p : patients) {
			if(p!= null && p.patientId == patientId) {
				pat = p; 
				break;
			} 
		}
		if(pat == null) {
			throw new IllegalArgumentException("Patient id not found...");
		}
		
		for(Disease d : diseases) {
			if(d != null && d.diseaseId == diseaseId) {
				dis = d;
				break;
			} 
		}
		
		if(dis == null) {
			throw new IllegalArgumentException("Disease id not found...");
		}
		
		pat.AddDeseaseId(diseaseId);
	}
	 
	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		Patient pat=null;
		for(Patient p : patients) {
			if(p.patientId == patientId) {
				pat = p;
				break;
			}
		}
		if(pat == null) {
			throw new IllegalArgumentException("Patient id not found...");
		}
		
		pat.AddExposure(exposure);
	}
}
