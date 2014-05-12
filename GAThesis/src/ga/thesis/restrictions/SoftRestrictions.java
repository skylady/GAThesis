package ga.thesis.restrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ga.thesis.entities.Chromosome;
import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Period;
import ga.thesis.utils.Utils;

public class SoftRestrictions {

	public double fitnessFunction(Individual ind) {
		double res = 0.0;
		// for (int i=0;i<ind.getLength();)

		return res;
	}

	public double lecturePeriod(Individual ind, double restrictionAmount) {
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
									&& groups.get(j).getGroupCode()
											.getSubject().equals(subject)) {
								sum = sum + 1;

								if (groups.get(j).getGroupNumber() == 0) {
									hasLecture = true;
								}
							}
						}
						if (hasLecture && sum != 1) {
						//	return false;
						}
					}
				}
			}
		return res;
	}
}
