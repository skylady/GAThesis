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
			ArrayList<Period> periodsList = new ArrayList<Period>();
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			System.out.println(lecturer);
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getGroup().getGroupCode()
						.getLecturer().toString().equals(lecturer)) {
					periodsList.add(ind.getChromosomes().get(i).getPeriod());
				}
			}
			lecturerPeriods.put(lecturer, periodsList);
		}

		// lecturer list
		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
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

			// ArrayList<Group> periodGroupsList = new ArrayList<Group>();
			// Period period = ind.getChromosomes().get(j).getPeriod();
			// for (int i = 0; i < ind.getLength(); i++) {
			// System.out.println(ind.getChromosomes().get(i).getPeriod());
			// if (ind.getChromosomes().get(i).getPeriod().equals(period)) {
			//
			// periodGroupsList.add(ind.getChromosomes().get(i).getGroup());
			// }
			// }
			// periodGroups.put(period, periodGroupsList);
		}

		System.out.println(periodGroups);

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

		System.out.println(subjectList);
		System.out.println("Periods groups:" + periodGroups);
		System.out.println("Periods list" + allPeriodsList);
		return foo(periodGroups, allPeriodsList, subjectList);
		// // verify lists for subjects
		// for (int i = 0; i < periodGroups.size(); i++) {
		// Period period = allPeriodsList.get(i);
		// if (!Utils.isValidList(periodGroups.get(period))) {
		// return false;
		// } else {
		// // different subjects
		// int sum1 = 0;
		// for (int j = 0; j < periodGroups.get(period).size(); j++) {
		// sum1 = sum1 + 1;
		//
		// for (int k = 0; k < periodGroups.get(period).size(); k++) {
		//
		// if (periodGroups.get(period).get(k).getGroupNumber() == 0
		// && ((sum1 != 1))) {
		// return false;
		// }
		// }
		// }
		// // same subjects
		// for (int k = 0; k < subjectList.size(); k++) {
		// int sum = 0;
		// String subject = subjectList.get(k);
		// System.out.println(subject);
		// System.out.println("k=" + k);
		// for (int j = 0; j < periodGroups.get(period).size(); j++) {
		// if (periodGroups.get(period).get(j).getGroupCode()
		// .getSubject().equals(subject)) {
		// sum = sum + 1;
		// }
		// System.out.println(sum);
		// }
		// for (int j = 0; j < periodGroups.get(period).size(); j++) {
		//
		// if (periodGroups.get(period).get(j).getGroupCode()
		// .getSubject().equals(subject)) {
		// if (periodGroups.get(period).get(j)
		// .getGroupNumber() == 0
		// && ((sum != 1))) {
		// return false;
		// }
		// }
		// }
		// }
		// }
		// }
		// return true;
	}

	public static boolean foo(HashMap<Period, ArrayList<Group>> periodGroups,
			ArrayList<Period> allPeriodsList, ArrayList<String> subjectList) {

		// verify lists for subjects
		for (int i = 0; i < periodGroups.size(); i++) {
			Period period = allPeriodsList.get(i);
			ArrayList<Group> groups = periodGroups.get(period);
			if (!Utils.isValidList(groups)) {
				return false;
			} else {
				// different subjects
				// TODO: implement for IUST1 and IUST2
				for (int j = 0; j < groups.size(); j++) {
					if (groups.get(j).getGroupNumber() == 0
							&& (groups.size() != 1)) {
						return false;
					}
				}
				// same subjects
				for (int k = 0; k < subjectList.size(); k++) {
					int sum = 0;
					boolean hasLecture = false;
					String subject = subjectList.get(k);
					for (int j = 0; j < groups.size(); j++) {
						if (groups.get(j).getGroupCode().getSubject()
								.equals(subject)) {
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
		return true;
	}

	// 3: validator of auditory
	public static boolean auditoryUnicity(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		HashMap<String, ArrayList<Period>> auditoryPeriods = new HashMap<String, ArrayList<Period>>();
		ArrayList<Period> periodsList = new ArrayList<Period>();
		ArrayList<Auditory> auditoryList = new ArrayList<Auditory>();
		Set<Auditory> auditoriesSet = new HashSet<Auditory>();

		// generate periods for each auditory
		for (int j = 0; j < ind.getLength(); j++) {
			String auditory = ind.getChromosomes().get(j).getAuditory()
					.getAuditoryNumber();
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getAuditory()
						.getAuditoryNumber().equals(auditory)) {
					periodsList.add(ind.getChromosomes().get(i).getPeriod());
				}
			}
			auditoryPeriods.put(auditory, periodsList);
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
			// System.out.println(auditoryList.get(i));
			String auditory = auditoryList.get(i).getAuditoryNumber();
			if (!Utils.isValidList(auditoryPeriods.get(auditory)))
				return false;
		}

		return true;
	}

	// 4: Size of group < size of auditory
	public static boolean groupSizeLessAuditorySize(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		for (int i = 0; i < ind.getLength(); i++) {
			// System.out.println("length from length checker:"
			// +ind.getLength());
			if (!(ind.getChromosomes().get(i).getGroup().getGroupCode()
					.getGroupSize() <= ind.getChromosomes().get(i)
					.getAuditory().getAuditorySize())) {
				return false;
			}
		}
		return true;
	}
}
