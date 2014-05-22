package ga.thesis.restrictions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Lecturer;
import ga.thesis.entities.Period;

public class SoftRestrictions {

	// cost function for teachers
	// windows for teachers ++
	// windows for groups ++
	// lect-pract order (!!! two lect or pract)
	// lectures in the morning ++

	public static double fitnessFunction(Individual ind) {
		double res = 0.0;

		double restValue =  lecturePeriod(ind, 0.2)
		+ lessWindowsForTeachers(ind, 0.2, 0.5)
		+ lessWindowsForGroups(ind, 0.05, 0.1);
		costFunnctionForTeachers(ind, 0.6);
		res = 1 / (1 + restValue);

		return res;
	}

	public static double lecturePeriod(Individual ind, double restrictionAmount) {
		double res = 0.;
		for (int i = 0; i < ind.getLength(); i++) {
			if (ind.getChromosomes().get(i).getGroup().getGroupNumber() == 0) {
				if (ind.getChromosomes().get(i).getPeriod().getNumberOfPeriod() > 3)
					// wi*ci (wi -number of constraints)
					res = res + restrictionAmount;
			}
		}
		return res;
	}

	public static double costFunnctionForTeachers(Individual ind,
			double restrictionAmount) {

		Set<Period> periodsSet = new HashSet<Period>();
		ArrayList<Period> allPeriodsList = new ArrayList<Period>();
		HashMap<Lecturer, ArrayList<Period>> lecturerPeriods = new HashMap<Lecturer, ArrayList<Period>>();
		ArrayList<Lecturer> lecturerList = new ArrayList<Lecturer>();
		Set<Lecturer> lecturerSet = new HashSet<Lecturer>();

		double res = 0;
		// generate periods for each lecturer
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			Lecturer lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			if (ind.getChromosomes().get(j).getGroup().getGroupCode()
					.getLecturer().equals(lecturer)) {
				if (lecturerPeriods.containsKey(lecturer)) {
					lecturerPeriods.get(lecturer).add(period);
				} else {
					ArrayList<Period> periodsList = new ArrayList<Period>();
					periodsList.add(period);
					lecturerPeriods.put(lecturer, periodsList);
				}
			}
		}

		// lecturer list
		for (int j = 0; j < ind.getLength(); j++) {
			Lecturer lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			if (lecturerSet.add(lecturer)) {
				lecturerList.add(lecturer);
			}
		}

		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (periodsSet.add(period)) {
				allPeriodsList.add(period);
			}
		}

		for (int k = 0; k < lecturerList.size(); k++) {
			Lecturer lecturer = lecturerList.get(k);
			ArrayList<Period> restrictions = lecturerList.get(k)
					.getUnAvailablePeriods();
			for (int m = 0; m < lecturerPeriods.get(lecturer).size(); m++) {
				if (restrictions.contains(lecturerPeriods.get(lecturer).get(m))) {
					res = res + restrictionAmount;
				}
			}
		}

		return res;
	}

	// TODO: fix lect-pract order
	public double lectPractOrder(Individual ind, double restrictionAmount) {

		Set<Period> periodsSet = new HashSet<Period>();
		ArrayList<Period> allPeriodsList = new ArrayList<Period>();
		HashMap<Period, ArrayList<Group>> periodGroups = new HashMap<Period, ArrayList<Group>>();
		Set<String> subjectsSet = new HashSet<String>();
		ArrayList<String> subjectList = new ArrayList<String>();
		Set<String> courseSet = new HashSet<String>();
		ArrayList<String> courseList = new ArrayList<String>();

		// period -> groups
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			Group group = ind.getChromosomes().get(j).getGroup();
			if (periodGroups.containsKey(period)) {
				periodGroups.get(period).add(group);
			} else {
				ArrayList<Group> periodGroupsList = new ArrayList<Group>();
				periodGroupsList.add(group);
				periodGroups.put(period, periodGroupsList);
			}
		}

		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (periodsSet.add(period)) {
				allPeriodsList.add(period);
			}
		}

		// group subject list
		for (int j = 0; j < ind.getLength(); j++) {
			String subject = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getSubject();
			if (subjectsSet.add(subject)) {
				subjectList.add(subject);
			}
		}

		// group course list
		for (int j = 0; j < ind.getLength(); j++) {
			String course = ind.getChromosomes().get(j).getGroup().getCourse();
			if (courseSet.add(course)) {
				courseList.add(course);
			}
		}

		double res = 0.;
		for (int i = 0; i < ind.getLength(); i++) {
			if (ind.getChromosomes().get(i).getGroup().getGroupNumber() == 0) {
				if (ind.getChromosomes().get(i).getPeriod().getNumberOfPeriod() > 3)
					// wi*ci (wi -number of constraints)
					res = res + restrictionAmount;
			}

		}

		for (int i = 0; i < periodGroups.size(); i++) {
			Period period = allPeriodsList.get(i);
			ArrayList<Group> groups = periodGroups.get(period);
			// different subjects
			for (int l = 0; l < courseList.size(); l++) {
				String course = courseList.get(l);
				// same subjects
				for (int k = 0; k < subjectList.size(); k++) {
					int sum = 0;
					boolean hasLecture = false;
					String subject = subjectList.get(k);
					for (int j = 0; j < groups.size(); j++) {
						if (groups.get(j).getCourse().equals(course)
								&& groups.get(j).getGroupCode().getSubject()
										.equals(subject)) {
							sum = sum + 1;

							if (groups.get(j).getGroupNumber() == 0) {
								hasLecture = true;
							}
						}
					}
					if (hasLecture && sum != 1) {
						// return false;
					}
				}
			}
		}
		return res;
	}

	// windows for teachers
	// found teacher periods per day and count the difference
	// teacher --> period
	public static double lessWindowsForTeachers(Individual ind,
			double softRestrictionAmount, double hardRestrictionAmount) {

		Set<Period> periodsSet = new HashSet<Period>();
		ArrayList<Period> allPeriodsList = new ArrayList<Period>();
		HashMap<String, ArrayList<Period>> lecturerPeriods = new HashMap<String, ArrayList<Period>>();
		ArrayList<String> lecturerList = new ArrayList<String>();
		Set<String> lecturerSet = new HashSet<String>();

		double res = 0;
		// generate periods for each lecturer
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer().getLecturerSurname();
			if (ind.getChromosomes().get(j).getGroup().getGroupCode()
					.getLecturer().getLecturerSurname().toString()
					.equals(lecturer)) {
				if (lecturerPeriods.containsKey(lecturer)) {
					lecturerPeriods.get(lecturer).add(period);
				} else {
					ArrayList<Period> periodsList = new ArrayList<Period>();
					periodsList.add(period);
					lecturerPeriods.put(lecturer, periodsList);
				}
			}
		}

		// lecturer list
		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer().getLecturerSurname();
			if (lecturerSet.add(lecturer)) {
				lecturerList.add(lecturer);
			}
		}

		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (periodsSet.add(period)) {
				allPeriodsList.add(period);
			}
		}

		// ListOfAllDays
		String[] daysSet = new String[] { "Monday", "Tuesday", "Wednesday",
				"Thursday", "Wednesday" };

		// verify teacherWindows
		for (int i = 0; i < daysSet.length; i++) {
			res = 0.;
			String day = daysSet[i];
			for (int k = 0; k < lecturerList.size(); k++) {
				String lecturer = lecturerList.get(k);
				// int[] tmp = new int[30];
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				int index = 0;
				for (int l = 0; l < lecturerPeriods.get(lecturer).size(); l++) {
					if (lecturerPeriods.get(lecturer).get(l).getDayOfTheWeek()
							.equals(day)) {
						tmp.add(index, lecturerPeriods.get(lecturer).get(l)
								.getNumberOfPeriod());
						index++;
					}
				}
				Collections.sort(tmp);
				// check the difference between to neighboor elements
				for (int w = 0; w < tmp.size(); w++) {
					for (int v = w + 1; v < tmp.size(); v++) {
						int diff = Math.abs(tmp.get(v) - tmp.get(w));
						// no windows
						if (diff == 1) {
							// res = res + 0;
						}
						// one windows
						if (diff == 2) {
							res = res + softRestrictionAmount;
						}
						// more than 1 window
						if (diff > 2) {
							res = res + hardRestrictionAmount;
						}

					}
				}

			}

		}

		return res;
	}

	public static double lessWindowsForGroups(Individual ind,
			double softRestrictionAmount, double hardRestrictionAmount) {

		Set<Period> periodsSet = new HashSet<Period>();
		ArrayList<Period> allPeriodsList = new ArrayList<Period>();
		HashMap<Group, ArrayList<Period>> groupPeriods = new HashMap<Group, ArrayList<Period>>();

		ArrayList<Group> groupList = new ArrayList<Group>();
		Set<Group> groupSet = new HashSet<Group>();

		double res = 0;

		// generate periods for each groups
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			Group group = ind.getChromosomes().get(j).getGroup();
			if (ind.getChromosomes().get(j).getGroup().equals(group)) {
				if (groupPeriods.containsKey(group)) {
					groupPeriods.get(group).add(period);
				} else {
					ArrayList<Period> periodsList = new ArrayList<Period>();
					periodsList.add(period);
					groupPeriods.put(group, periodsList);
				}
			}
		}

		// group list
		for (int j = 0; j < ind.getLength(); j++) {
			Group group = ind.getChromosomes().get(j).getGroup();
			if (groupSet.add(group)) {
				groupList.add(group);
			}
		}

		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (periodsSet.add(period)) {
				allPeriodsList.add(period);
			}
		}

		// ListOfAllDays
		String[] daysSet = new String[] { "Monday", "Tuesday", "Wednesday",
				"Thursday", "Wednesday" };

		// verify teacherWindows

		for (int i = 0; i < daysSet.length; i++) {
			res = 0.;
			String day = daysSet[i];
			for (int k = 0; k < groupList.size(); k++) {
				Group group = groupList.get(k);
				// int[] tmp = new int[] {};
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				int index = 0;
				for (int l = 0; l < groupPeriods.get(group).size(); l++) {
					if (groupPeriods.get(group).get(l).getDayOfTheWeek()
							.equals(day)) {
						tmp.add(index, groupPeriods.get(group).get(l)
								.getNumberOfPeriod());

					}
				}
				Collections.sort(tmp);
				// check the difference between to neighboor elements
				for (int w = 0; w < tmp.size(); w++) {
					for (int v = w + 1; v < tmp.size(); v++) {
						int diff = Math.abs(tmp.get(v) - tmp.get(w));
						// no windows
						if (diff == 1) {
							// res = res + 0;
						}
						// one windows
						if (diff == 2) {
							res = res + softRestrictionAmount;
						}
						// more than 1 window
						if (diff > 2) {
							res = res + hardRestrictionAmount;
						}
					}
				}
			}
		}
		return res;
	}
}
