package edu.disease.asn2;
import edu.disease.asn1.Exposure;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class DiseaseControlManagerImplTest {
	DiseaseControlManagerImpl dcm = new DiseaseControlManagerImpl(2, 2);
	UUID id = UUID.randomUUID();
	UUID id2 = UUID.randomUUID();
	Disease infect = new InfectiousDisease("corona", id);
	Disease nonInfect = new NonInfectiousDisease("thyroid", id);
	Patient p = new Patient(2,2);
	Exposure exp = new Exposure(id2); 
	
	@Test
	public void DCMImplTest() { 
		Disease d1 = dcm.addDisease("covid", true);
		Disease d2 = dcm.addDisease("cancer", false);
		assertThrows(IllegalArgumentException.class, ()->{
			 new DiseaseControlManagerImpl(-1, 0); 
		});
		assertThrows(IllegalStateException.class, ()->{
			dcm.addDisease("thyroid", false);
		});
		assertEquals(d1, dcm.getDisease(d1.getDiseaseId()));
		assertEquals(d2, dcm.getDisease(d2.getDiseaseId()));
		assertNull(dcm.getDisease(id));
		
		Patient p1 = dcm.addPatient("Akshat", "Kapoor", 1, 1);
		dcm.addPatient("Rohan", "malhotra", 2, 1);
		assertNull(dcm.getPatient(id2));
		
		assertThrows(IllegalStateException.class, ()->{
			dcm.addPatient("Raju", "Rastogi", 1, 2);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			dcm.addDiseaseToPatient(p1.getPatientId(), id);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			dcm.addDiseaseToPatient(id2, d1.getDiseaseId());
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			dcm.addExposureToPatient(id2, new Exposure(id2));
		});
			
		assertEquals(p1, dcm.getPatient(p1.getPatientId()));
		p.AddDeseaseId(d1.getDiseaseId());
		dcm.addDiseaseToPatient(p1.getPatientId(), d1.getDiseaseId());
		dcm.addExposureToPatient(p1.getPatientId(), new Exposure(p1.getPatientId()));
	}
}
