package ga.thesis.entities;

import java.util.ArrayList;

public class Lecturer {

	private int id;
	private String lecturerSurname;
	private ArrayList<Period> unAvailablePeriods;

	public Lecturer(int id, String lecturer,
			ArrayList<Period> unAvailablePeriods) {
		this.setId(id);
		this.lecturerSurname = lecturer;
		this.unAvailablePeriods = unAvailablePeriods;
	}

	@Override
	public String toString() {
		return "Lecturer [lecturer=" + lecturerSurname
				+ ", unAvailablePeriods=" + unAvailablePeriods + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lecturerSurname == null) ? 0 : lecturerSurname.hashCode());
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
		Lecturer other = (Lecturer) obj;
		if (lecturerSurname == null) {
			if (other.lecturerSurname != null)
				return false;
		} else if (!lecturerSurname.equals(other.lecturerSurname))
			return false;
		return true;
	}

	public String getLecturerSurname() {
		return lecturerSurname;
	}

	public void setLecturerSurname(String lecturer) {
		this.lecturerSurname = lecturer;
	}

	public ArrayList<Period> getUnAvailablePeriods() {
		return unAvailablePeriods;
	}

	public void setUnAvailablePeriods(ArrayList<Period> unAvailablePeriods) {
		this.unAvailablePeriods = unAvailablePeriods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
