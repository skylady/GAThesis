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

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public static HashMap<Integer, Group> setOfGroups(Group group, int length) {
		HashMap<Integer, Group> setOfGroups = new HashMap<Integer, Group>();
		for (int i = 0; i < length; i++) {
			setOfGroups.put(i, group);
		}
		return setOfGroups;
	}

	public static HashMap<Group, Integer> setOfEncodedGroups(
			HashMap<Integer, Group> setOfGroups, Integer startPoint) {
		HashMap<Group, Integer> setOfEncodedGroups = new HashMap<Group, Integer>();
		for (int i = 0; i < setOfGroups.size(); i++) {
			setOfEncodedGroups.put(setOfGroups.get(i), startPoint);
			startPoint++;
		}
		return setOfEncodedGroups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((groupCode == null) ? 0 : groupCode.hashCode());
		result = prime * result + groupNumber;
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
		Group other = (Group) obj;
		if (groupCode == null) {
			if (other.groupCode != null)
				return false;
		} else if (!groupCode.equals(other.groupCode))
			return false;
		if (groupNumber != other.groupNumber)
			return false;
		return true;
	}

}
