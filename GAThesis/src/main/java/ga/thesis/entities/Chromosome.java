package ga.thesis.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Chromosome {

	private Group group;
	private Auditory auditory;
	private Period period;
	
	public Chromosome(Group group, Auditory auditory, Period period) {
		this.group = group;
		this.auditory = auditory;
		this.period = period;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Auditory getAuditory() {
		return auditory;
	}

	public void setAuditory(Auditory auditory) {
		this.auditory = auditory;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public String makeChromosome() {
		return null;

	}

	public static String makeChromosome(Group group, Auditory auditory,
			Period period, HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods) {
		String res = String.valueOf(setOfEncodedGroups.get(group))
				.concat(String.valueOf(setOfEncodedAuditories.get(auditory)))
				.concat(String.valueOf(setOfEncodedPeriods.get(period)));

		return res;
	}

	public static String generateRandomChromosome(
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		Random rand = new Random();
		int randGroup = rand.nextInt(setOfGroups.size());
		int randAuditory = rand.nextInt(setOfAuditories.size());
		int randPeriod = rand.nextInt(setOfPeriods.size());
		String res = String
				.valueOf(setOfEncodedGroups.get(setOfGroups.get(randGroup)))
				.concat(String.valueOf(setOfEncodedAuditories
						.get(setOfAuditories.get(randAuditory))))
				.concat(String.valueOf(setOfEncodedPeriods.get(setOfPeriods
						.get(randPeriod))));
		return res;
	}

	public static String representToString(ArrayList<Integer> arr) {
		String res = "";
		for (int i = 0; i < arr.size(); i++) {
			res = res.concat(String.valueOf(arr.get(i)));
		}
		return res;

	}

	@Override
	public String toString() {
		return "Chromosome [group=" + group + ", auditory=" + auditory
				+ ", period=" + period + "]";
	}
}
