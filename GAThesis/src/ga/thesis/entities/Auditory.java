package ga.thesis.entities;

import java.util.HashMap;

public class Auditory {

	private int id;
	private String auditoryNumber;

	public Auditory(int id, String auditoryNumber) {
		this.id = id;
		this.auditoryNumber = auditoryNumber;
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

	public static HashMap<Auditory, Integer> setOfEncodedAuditories(HashMap<Integer, Auditory> setOfAuditories,
			Integer startPoint) {
		HashMap<Auditory, Integer> setOfEncodedAuditories = new HashMap<Auditory, Integer>();
		for (int i = 0; i < setOfAuditories.size(); i++) {	
			setOfEncodedAuditories.put(setOfAuditories.get(i),startPoint);
			startPoint++;
		}
		return setOfEncodedAuditories;
	}
	
	public static HashMap<Integer,Auditory> setOfReverseEncodedAuditories(HashMap<Integer, Auditory> setOfAuditories,
			Integer startPoint) {
		HashMap<Integer,Auditory> setOfEncodedAuditories = new HashMap<Integer,Auditory>();
		for (int i = 0; i < setOfAuditories.size(); i++) {	
			setOfEncodedAuditories.put(startPoint,setOfAuditories.get(i));
			startPoint++;
		}
		return setOfEncodedAuditories;
	}
}
