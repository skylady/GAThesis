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
	// dayOfTheWeek) and each lecturer is simultaneously only in one auditory
	public static boolean lecturerUnicity(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		HashMap<String, ArrayList<Period>> lecturerPeriods = new HashMap<String, ArrayList<Period>>();
		HashMap<String, ArrayList<Auditory>> lecturerAuditories = new HashMap<String, ArrayList<Auditory>>();
		ArrayList<Auditory> auditoriesList = new ArrayList<Auditory>();
		ArrayList<Period> periodsList = new ArrayList<Period>();
		ArrayList<Period> periodList = new ArrayList<Period>();
		ArrayList<String> lecturerList = new ArrayList<String>();
		Set<String> lecturerSet = new HashSet<String>();
		Set<Period> periodsSet = new HashSet<Period>();

		// generate periods for each lecturer
		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getGroup().getGroupCode()
						.getLecturer().equals(lecturer)) {
					periodsList.add(ind.getChromosomes().get(j).getPeriod());
				}
			}
			lecturerPeriods.put(lecturer, periodsList);
		}
		// generate auditories for each lecturer
		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getGroup().getGroupCode()
						.getLecturer().equals(lecturer)) {
					auditoriesList.add(ind.getChromosomes().get(j)
							.getAuditory());
				}
			}
			lecturerAuditories.put(lecturer, auditoriesList);
		}

		// lecturer list
		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			if (lecturerSet.add(lecturer)) {
				lecturerList.add(lecturer);
			}
		}
		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (periodsSet.add(period)) {
				periodList.add(period);
			}
		}

		// verify periods lists
		for (int i = 0; i < lecturerPeriods.size(); i++) {
			String lecturer = lecturerList.get(i);
			if (!Utils.isValidList(lecturerPeriods.get(lecturer)))
				return false;
		}

		// verify auditories lists
		// for (int i = 0; i < lecturerAuditories.size(); i++) {
		// String lecturer = lecturerList.get(i);
		// Period period = periodList.get(i);
		// int sum=0;
		// for (int j=0;j<lecturerAuditories.get(lecturer).size();j++){
		// if (lecturerAuditories.get(lecturer).get(j).g)
		// return false;
		// }
		// }
		return true;
	}

	// 2 validator of group number for pair
	public static boolean groupNumberChecker(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		ArrayList<Group> periodGroupsList = new ArrayList<Group>();
		Set<Period> periodsSet = new HashSet<Period>();
		ArrayList<Period> periodList = new ArrayList<Period>();
		HashMap<Period, ArrayList<Group>> periodGroups = new HashMap<Period, ArrayList<Group>>();

		Set<String> subjectsSet = new HashSet<String>();
		ArrayList<String> subjectList = new ArrayList<String>();

		// period -> groups
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getPeriod().equals(period)) {
					periodGroupsList
							.add(ind.getChromosomes().get(j).getGroup());
				}
			}
			periodGroups.put(period, periodGroupsList);
		}

		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (periodsSet.add(period)) {
				periodList.add(period);
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

		// verify lists
		for (int i = 0; i < periodGroups.size(); i++) {
			Period period = periodList.get(i);
			if (!Utils.isValidList(periodGroups.get(period))) {
				return false;
			} else {
				int sum = 0;
				for (int j = 0; j < periodGroups.get(period).size(); j++) {
					String subject = subjectList.get(j);
					if (periodGroups.get(period).get(j).getGroupNumber() == 0) {
						if (periodGroups.get(period).get(j).getGroupCode()
								.getSubject().equals(subject)) {
							sum = sum + 1;
						}
					}
				}
				if (!(sum == 1)) {
					return false;
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
		//	System.out.println(auditoryList.get(i));
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
		//	System.out.println("length from length checker:" +ind.getLength());
			if (!(ind.getChromosomes().get(i).getGroup().getGroupCode()
					.getGroupSize() <= ind.getChromosomes().get(i)
					.getAuditory().getAuditorySize())) {
				return false;
			}
		}
		return true;
	}
}
