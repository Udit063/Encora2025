package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class PatientTest {
	 UUID id3 = UUID.randomUUID();
	 UUID id4 = UUID.randomUUID();
	 UUID id5 = UUID.randomUUID(); 
	 Patient p = new Patient(2,2);
	 Exposure e1 = new Exposure(id3);
	 Exposure e2 = new Exposure(id4);
	 Exposure e3 = new Exposure(id5);

	 @Test
	 public void TestPatient() {
		 p.AddDeseaseId(id3);
		 p.AddDeseaseId(id4);
		 assertThrows(IndexOutOfBoundsException.class, ()->{
			 p.AddDeseaseId(id5);
		 }); 
		 
		 
		 assertThrows(IllegalArgumentException.class, ()->{
			new Patient(0,2); 
		 });
		 p.setPatientId(id3);
		 assertEquals(id3, p.getPatientId());
		 
		 p.setFirstName("Udit");
		 assertEquals("Udit", p.getFirstName());
		 
		 p.setLastName("Kapoor");
		 assertEquals("Kapoor", p.getLastName());
		 
		 p.AddExposure(e1);
		 p.AddExposure(e2);
		 assertThrows(IndexOutOfBoundsException.class, ()->{
			 p.AddExposure(e3);
		 });
		 
		 Patient p2 = new Patient(1,2);
		 
		 assertTrue(p.equals(p));
		 assertFalse(p.equals(null));
		 assertFalse(p.equals(new PatientTest()));
		 assertFalse(p.equals(p2));
		 
		 assertNotEquals(p.hashCode(), p2.hashCode()); 
		 
		 String s1 = "Patient [patientId=" + id3 + ", firstName=" + p.getFirstName() + ", lastName=" + p.getLastName() + ", exposure="
					+ Arrays.toString(p.exposure) + ", diseaseIds=" + Arrays.toString(p.diseaseIds) + "]";
		 
		 assertEquals(s1, p.toString());
	 }
}
