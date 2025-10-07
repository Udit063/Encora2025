package edu.disease.asn2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID; 

import org.junit.jupiter.api.Test;

public class DiseaseTest {
	UUID id2 = UUID.randomUUID();
	UUID id3 = UUID.randomUUID();
	InfectiousDisease d = new InfectiousDisease("malaria", id2);
	NonInfectiousDisease d2 = new NonInfectiousDisease("thyroid", id3);
	
//	Disease d = new Disease(); 
	@Test 
	public void TestDisease() {
		d.setDiseaseId(id2);  
		assertEquals(id2, d.getDiseaseId());
		
		d.setName("Udit");
		assertEquals("Udit", d.getName());
		
		String s = "Disease [diseaseId=" + id2 + ", name=Udit]"; 
		assertEquals(s, d.toString()); 
		
//		Disease d2 = new Disease();
		
		assertTrue(d.equals(d));
		assertFalse(d.equals(null));
		assertFalse(d.equals(new InfectiousDisease("covid", id3)));
		assertFalse(d.equals(d2));
		assertNotEquals(d.hashCode(), d2.hashCode());
		
		d.getExamples();
		d2.getExamples();
		
	}
}
