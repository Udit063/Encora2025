package edu.disease.asn2;

import edu.disease.asn1.Exposure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Patient implements Comparable<Patient> {
	UUID patientId;
	String firstName;
	String lastName;
	Exposure[] exposure;
	UUID[] diseaseIds; 
	int i = 0;
	int j = 0;
	

	public Patient(int maxDiseases, int maxExposures) throws IllegalArgumentException {
		try {
			if (maxDiseases <= 0 || maxExposures <= 0) {
				throw new IllegalArgumentException("Please enter an integer...");
			} else {
				exposure = new Exposure[maxExposures];
				diseaseIds = new UUID[maxExposures];
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Please enter an integer...");
		}
	}
 
	public void AddDeseaseId(UUID diseaseId) throws IndexOutOfBoundsException {
		if (i < diseaseIds.length) {
			diseaseIds[i++] = diseaseId;
		} else {
			throw new IndexOutOfBoundsException("Can't Add....Array is full...");
		}
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", exposure="
				+ Arrays.toString(exposure) + ", diseaseIds=" + Arrays.toString(diseaseIds) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(patientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}

	public void AddExposure(Exposure exposures) throws IndexOutOfBoundsException {
		if (j < exposure.length) {
			exposure[j++] = exposures;
		} else {
			throw new IndexOutOfBoundsException("Can't Add....Array is full...");
		}
	}

	public int compareTo(Patient s) {
		if (this.lastName.compareTo(s.lastName) == 0) {
			return this.firstName.compareTo(s.firstName);
		} else
			return this.lastName.compareTo(s.lastName);
	}

}