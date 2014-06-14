package ga.thesis.entities;

import java.util.ArrayList;

public class GroupCode {

    private int id;
    private String subject;
    private String subjectType;
    private Lecturer lecturer;
    private int groupSize;
    private String weeks;
	//private String groupType;
    //private ArrayList<Integer> groupList;

    public GroupCode(int id, String subject, String subjectType, Lecturer lecturer,
            int groupSize, String weeks) {
        //String groupType, ArrayList<Integer> groupList) {
        this.id = id;
        this.subject = subject;
        this.subjectType = subjectType;
        this.lecturer = lecturer;
        this.groupSize = groupSize;
        this.weeks = weeks;
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

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
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

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + groupSize;
        result = prime * result + id;
        result = prime * result
                + ((lecturer == null) ? 0 : lecturer.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result
                + ((subjectType == null) ? 0 : subjectType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GroupCode other = (GroupCode) obj;
        if (groupSize != other.groupSize) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (lecturer == null) {
            if (other.lecturer != null) {
                return false;
            }
        } else if (!lecturer.equals(other.lecturer)) {
            return false;
        }
        if (subject == null) {
            if (other.subject != null) {
                return false;
            }
        } else if (!subject.equals(other.subject)) {
            return false;
        }
        if (subjectType == null) {
            if (other.subjectType != null) {
                return false;
            }
        } else if (!subjectType.equals(other.subjectType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GroupCode [subject=" + subject + ", subjectType=" + subjectType
                + ", lecturer=" + lecturer + ", groupSize=" + groupSize + "]";
    }
}
