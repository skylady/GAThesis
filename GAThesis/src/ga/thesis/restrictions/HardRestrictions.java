package ga.thesis.restrictions;

import ga.thesis.entities.Auditory;
import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Period;
import ga.thesis.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HardRestrictions {
	// 1: Each lecturer has only one period at the same time (periodNumber,
	// dayOfTheWeek)
	public static boolean lecturerPeriodUnicity(Individual ind) {

		HashMap<String, ArrayList<Period>> lecturerPeriods = new HashMap<String, ArrayList<Period>>();
		ArrayList<String> lecturerList = new ArrayList<String>();
		Set<String> lecturerSet = new HashSet<String>();

		// generate periods for each lecturer
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer().getLecturerSurname();
			if (ind.getChromosomes().get(j).getGroup().getGroupCode()
					.getLecturer().getLecturerSurname().toString().equals(lecturer)) {
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
		// verify periods lists
		for (int i = 0; i < lecturerPeriods.size(); i++) {
			String lecturer = lecturerList.get(i);
			if (!Utils.isValidList(lecturerPeriods.get(lecturer)))
				return false;
		}
		return true;
	}

	// 2 validator of group number for pair
	public static boolean groupNumberChecker(Individual ind) {

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

		// verify lists for subjects
		for (int i = 0; i < periodGroups.size(); i++) {
			Period period = allPeriodsList.get(i);
			ArrayList<Group> groups = periodGroups.get(period);
			if (!Utils.isValidList(groups)) {
				return false;
			} else {
				// different subjects
				for (int l = 0; l < courseList.size(); l++) {
					String course = courseList.get(l);
					int sum1 = 0;
					boolean hasLecture1 = false;
					for (int j = 0; j < groups.size(); j++) {
						// course
						if (groups.get(j).getCourse().equals(course)) {
							sum1 = sum1 + 1;

							if (groups.get(j).getGroupNumber() == 0) {
								hasLecture1 = true;
							}
						}
					}
					if (hasLecture1 && sum1 != 1) {
						return false;
					}
					// same subjects
					for (int k = 0; k < subjectList.size(); k++) {
						int sum = 0;
						boolean hasLecture = false;
						String subject = subjectList.get(k);
						for (int j = 0; j < groups.size(); j++) {
							if (groups.get(j).getCourse().equals(course)
									&& groups.get(j).getGroupCode()
											.getSubject().equals(subject)) {
								sum = sum + 1;

								if (groups.get(j).getGroupNumber() == 0) {
									hasLecture = true;
								}
							}
						}
						if (hasLecture && sum != 1) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	// 3: validator of auditory
	// in each auditory only one period simultaneously
	public static boolean auditoryUnicity(Individual ind) {

		HashMap<String, ArrayList<Period>> auditoryPeriods = new HashMap<String, ArrayList<Period>>();
		ArrayList<Auditory> auditoryList = new ArrayList<Auditory>();
		Set<Auditory> auditoriesSet = new HashSet<Auditory>();

		// generate periods for each auditory
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			String auditory = ind.getChromosomes().get(j).getAuditory()
					.getAuditoryNumber();
			if (ind.getChromosomes().get(j).getAuditory().getAuditoryNumber()
					.equals(auditory)) {
				if (auditoryPeriods.containsKey(auditory)) {
					auditoryPeriods.get(auditory).add(period);
				} else {
					ArrayList<Period> periodsList = new ArrayList<Period>();
					periodsList.add(period);
					auditoryPeriods.put(auditory, periodsList);
				}

			}
		}

		// set of auditory
		for (int j = 0; j < ind.getLength(); j++) {
			Auditory auditory = ind.getChromosomes().get(j).getAuditory();
			if (auditoriesSet.add(auditory)) {
				auditoryList.add(auditory);
			}
		}

		// verify auditory lists
		for (int i = 0; i < auditoryPeriods.size(); i++) {
			String auditory = auditoryList.get(i).getAuditoryNumber();
			if (!Utils.isValidList(auditoryPeriods.get(auditory)))
				return false;
		}
		return true;
	}

	// 4: Size of group < size of auditory
	public static boolean groupSizeLessAuditorySize(Individual ind) {

		for (int i = 0; i < ind.getLength(); i++) {
//			System.out.println("i="
//					+ i
//					+ "GR size:"
//					+ ind.getChromosomes().get(i).getGroup().getGroupCode()
//							.getGroupSize());
//			System.out.println("Aud size: "
//					+ ind.getChromosomes().get(i).getAuditory()
//							.getAuditorySize());
			if ((ind.getChromosomes().get(i).getGroup().getGroupCode()
					.getGroupSize() > ind.getChromosomes().get(i)
					.getAuditory().getAuditorySize())) {
			//	System.out.println("________________");
				return false;
				
			}
		}
		
		return true;
	}
}
