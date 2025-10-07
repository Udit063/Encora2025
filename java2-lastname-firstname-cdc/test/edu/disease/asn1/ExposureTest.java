package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class ExposureTest {
	UUID id = UUID.randomUUID();
	LocalDateTime dt = LocalDateTime.now();
	Exposure e = new Exposure(id); 
	 
	@Test 
	public void TestMethod() {
		assertSame(id, e.getPatientId());
		e.setDateTime(dt);
		assertSame(dt, e.getDateTime());
		
		e.setExposureType("I");
		assertEquals("I", e.getExposureType());
		
		e.setExposureType("D");
		assertEquals("D", e.getExposureType());
		
		assertThrows(IllegalArgumentException.class, ()->{
			e.setExposureType("P");
		});
		
		assertTrue(e.equals(e));
		assertFalse(e.equals(null));
		assertFalse(e.equals(new ExposureTest()));
		
		Exposure exp = new Exposure(id);
		exp.setDateTime(dt);
		
		assertTrue(e.equals(exp));
		
		exp.setDateTime(LocalDateTime.now());
		assertFalse(e.equals(exp));
		
		String s = "Exposure [patientId=" + id + ", dateTime=" + dt + ", exposureType=D]";
		assertEquals(s, e.toString());
		
		assertNotEquals(e.hashCode(),exp.hashCode());
	}
}
