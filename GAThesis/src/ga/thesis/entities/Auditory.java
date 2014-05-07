package ga.thesis.entities;

import java.util.HashMap;

public class Auditory {

	private int id;
	private String auditoryNumber;
	private int auditorySize;

	public Auditory(int id, String auditoryNumber, int auditorySize) {
		this.id = id;
		this.auditoryNumber = auditoryNumber;
		this.auditorySize=auditorySize;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuditoryNumber() {
		return auditoryNumber;
	}

	public void setAuditoryNumber(String auditoryNumber) {
		this.auditoryNumber = auditoryNumber;
	}

	public static HashMap<Integer, Auditory> setOfAuditories(Auditory auditory,
			int length) {
		HashMap<Integer, Auditory> setOfAuditories = new HashMap<Integer, Auditory>();
		for (int i = 0; i < length; i++) {
			setOfAuditories.put(i, auditory);
		}
		return setOfAuditories;
	}

	public static HashMap<Auditory, Integer> setOfEncodedAuditories(
			HashMap<Integer, Auditory> setOfAuditories, Integer startPoint) {
		HashMap<Auditory, Integer> setOfEncodedAuditories = new HashMap<Auditory, Integer>();
		for (int i = 0; i < setOfAuditories.size(); i++) {
			setOfEncodedAuditories.put(setOfAuditories.get(i), startPoint);
			startPoint++;
		}
		return setOfEncodedAuditories;
	}

	public static HashMap<Integer, Auditory> setOfReverseEncodedAuditories(
			HashMap<Integer, Auditory> setOfAuditories, Integer startPoint) {
		HashMap<Integer, Auditory> setOfEncodedAuditories = new HashMap<Integer, Auditory>();
		for (int i = 0; i < setOfAuditories.size(); i++) {
			setOfEncodedAuditories.put(startPoint, setOfAuditories.get(i));
			startPoint++;
		}
		return setOfEncodedAuditories;
	}

	public int getAuditorySize() {
		return auditorySize;
	}

	public void setAuditorySize(int size) {
		this.auditorySize = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((auditoryNumber == null) ? 0 : auditoryNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditory other = (Auditory) obj;
		if (auditoryNumber == null) {
			if (other.auditoryNumber != null)
				return false;
		} else if (!auditoryNumber.equals(other.auditoryNumber))
			return false;
		return true;
	}
}
