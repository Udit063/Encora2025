package edu.disease.asn2;
import edu.disease.asn1.Exposure;

import java.util.UUID;

public interface DiseaseControlManager {
	public Disease addDisease(String name, Boolean infectious) throws Exception;
	public Disease getDisease(UUID diseaseId);
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) throws Exception;
	public Patient getPatient(UUID patientId);
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId);
	public void addExposureToPatient(UUID patientId, Exposure exposure);
}
