package ga.thesis.entities;

import java.util.HashMap;

public class Group {

	private int id;
	private GroupCode groupCode;
	private int groupNumber;

	public Group(int id, GroupCode groupCode, int groupNumber) {
		this.id = id;
		this.groupCode = groupCode;
		this.groupNumber = groupNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GroupCode getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(GroupCode groupCode) {
		this.groupCode = groupCode;
	}

	public int getgroupNumber() {
		return groupNumber;
	}

	public void setgroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	
	public static HashMap<Integer, Group> setOfGroups(Group group,
			int length) {
		HashMap<Integer, Group> setOfGroups = new HashMap<Integer, Group>();
		for (int i = 0; i < length; i++) {
			setOfGroups.put(i, group);
		}
		return setOfGroups;
	}

	public static HashMap<Group, Integer> setOfEncodedGroups(HashMap<Integer, Group> setOfGroups,
			Integer startPoint) {
		HashMap<Group, Integer> setOfEncodedGroups = new HashMap<Group, Integer>();
		for (int i = 0; i < setOfGroups.size(); i++) {	
			setOfEncodedGroups.put(setOfGroups.get(i),startPoint);
			startPoint++;
		}
		return setOfEncodedGroups;
	}

}
