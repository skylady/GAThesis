package ga.entities;

public class GroupCode {

	private int id;
	private String subject;
	private String subjectType;
	private String lecturer;
	private int groupSize;
	//private int groupSize;

	public GroupCode(int id, String subject, String subjectType, String lecturer,
			int groupSize) {
		this.id = id;
		this.subject = subject;
		this.subjectType = subjectType;
		this.lecturer=lecturer;
		this.groupSize = groupSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

}
