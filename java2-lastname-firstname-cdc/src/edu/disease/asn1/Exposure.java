package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;

public class Exposure {
	UUID patientId;
	LocalDateTime dateTime;
	String exposureType;
	
	public Exposure(UUID patientId) {
		this.patientId = patientId;
	}
 
	public UUID getPatientId() {
		return patientId;
	} 

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getExposureType() {
		return exposureType;
	} 

	public void setExposureType(String exposureType) throws IllegalArgumentException {
		if(exposureType == "D" || exposureType == "I") {
			this.exposureType = exposureType;
		} else {
			throw new IllegalArgumentException();
		}
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(dateTime, patientId);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true; 
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Exposure other = (Exposure) obj;
//		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientId, other.patientId);
//	}

	@Override 
	public String toString() {
		return "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, patientId);
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (!(obj instanceof Exposure))
			return false;
		Exposure other = (Exposure) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientId, other.patientId);
	}
}

