package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.UUID;

public class Test {
	public static void main(String[] args) {
		UUID id = UUID.randomUUID();
		LocalDateTime dt = LocalDateTime.now();
		Exposure e = new Exposure(id);
		
		
		UUID id2 = UUID.randomUUID();
		LocalDateTime dt2 = LocalDateTime.now();
		Exposure e2 = new Exposure(id);
		
		//System.out.println(e.equals(e2));
		
		System.out.println(e.hashCode()==e2.hashCode());
	}
}
