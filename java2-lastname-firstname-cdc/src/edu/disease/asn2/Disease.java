package edu.disease.asn2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

abstract public class Disease {
	UUID diseaseId;
	String name; 
	public Disease() {}
	public UUID getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId; 
	}
	public String getName() {
		return name;
	} 
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diseaseId);
	}
	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(diseaseId, other.diseaseId);
	}
	@Override
	public String toString() { 
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]"; 
	}
	 
	public abstract String[] getExamples();
}

class InfectiousDisease extends Disease{
	String[] infec = {"malaria", "dengue", "corona", "viral"};
	public InfectiousDisease(String name, UUID diseaseId) {
		this.diseaseId = diseaseId;
		this.name =name;
	}
	
	@Override
	public String[] getExamples() {
		return infec;
	} 
}

class NonInfectiousDisease extends Disease{
	public NonInfectiousDisease(String name, UUID diseaseId) {
		this.diseaseId = diseaseId;
		this.name=name;
	}
	@Override
	public String[] getExamples() {
		return new String[]{"typhoid", "Cancer","thyroid","tumor"};
	}
}
