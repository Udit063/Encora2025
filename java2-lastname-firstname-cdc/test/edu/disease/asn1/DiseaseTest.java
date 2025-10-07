package edu.disease.asn1;
import edu.disease.asn1.Disease;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class DiseaseTest {
	UUID id2 = UUID.randomUUID();
	Disease d = new Disease();
	@Test 
	public void TestDisease() {
		d.setDiseaseId(id2); 
		assertEquals(id2, d.getDiseaseId());
		
		d.setName("Udit");
		assertEquals("Udit", d.getName());
		
		String s = "Disease [diseaseId=" + id2 + ", name=Udit]"; 
		assertEquals(s, d.toString()); 
		
		Disease d2 = new Disease();
		 
		assertTrue(d.equals(d));
		assertFalse(d.equals(null));
		assertFalse(d.equals(new DiseaseTest())); 
		assertFalse(d.equals(d2));
		assertNotEquals(d.hashCode(), d2.hashCode());
	}
}
