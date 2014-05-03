package ga.thesis.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public static final int STARTPOINT = 10;

	public static void main(String[] args) {

		GroupCode groupCode1 = new GroupCode(0, "GA", "lecture", "Gul", 11);
		GroupCode groupCode2 = new GroupCode(1, "GA1", "prakt", "Gul", 11);
		GroupCode groupCode3 = new GroupCode(2, "VDM", "lecture", "Pro", 11);
		GroupCode groupCode4 = new GroupCode(3, "VDM", "prakt", "Pro", 11);
		GroupCode groupCode5 = new GroupCode(4, "PPP", "lecture", "Grechko", 11);
		GroupCode groupCode6 = new GroupCode(5, "PPP", "prack", "Grecko", 11);
		GroupCode groupCode7 = new GroupCode(6, "Qos", "lecture", "Cherkasov",
				11);
		GroupCode groupCode8 = new GroupCode(7, "Qos", "Prack", "Cherkasov", 11);

		Group group1 = new Group(0, groupCode1, 0);
		Group group2 = new Group(0, groupCode2, 1);
		Group group3 = new Group(0, groupCode3, 0);
		Group group4 = new Group(0, groupCode4, 1);
		Group group5 = new Group(0, groupCode5, 0);
		Group group6 = new Group(0, groupCode6, 1);
		Group group7 = new Group(0, groupCode7, 0);
		Group group8 = new Group(0, groupCode8, 1);

		Group[] group = { group1, group2, group3, group4, group5, group6,
				group7, group8 };

		HashMap<Integer, Group> setOfGroups = new HashMap<Integer, Group>();

		for (int i = 0; i < 8; i++) {
			setOfGroups.put(i, group[i]);
		}

		HashMap<Group, Integer> setOfEncodedGroups = Group.setOfEncodedGroups(
				setOfGroups, STARTPOINT);
		System.out.println(setOfEncodedGroups.get(group6));
		System.out.println(setOfGroups.get(3).getGroupCode().getSubject());

		Auditory aud1 = new Auditory(1, "208");
		Auditory aud2 = new Auditory(2, "206");
		Auditory aud3 = new Auditory(3, "223");
		Auditory aud4 = new Auditory(4, "309");
		Auditory aud5 = new Auditory(5, "306");
		Auditory aud6 = new Auditory(6, "307");
		Auditory aud7 = new Auditory(7, "331");
		Auditory aud8 = new Auditory(8, "310");
		Auditory aud9 = new Auditory(9, "313");
		Auditory aud10 = new Auditory(10, "225");
		Auditory aud11 = new Auditory(11, "3-310");
		Auditory aud12 = new Auditory(12, "3-220a");
		Auditory[] araud = { aud1, aud2, aud3, aud4, aud5, aud6, aud7, aud8,
				aud9, aud10, aud11, aud12 };

		HashMap<Integer, Auditory> setOfAuditories = new HashMap<Integer, Auditory>();

		for (int i = 0; i < 11; i++) {
			setOfAuditories.put(i, araud[i]);
		}

		HashMap<Auditory, Integer> setOfEncodedAuditories = Auditory
				.setOfEncodedAuditories(setOfAuditories, STARTPOINT
						+ setOfEncodedGroups.size());
		
		
		//Auditory keyByValue = getKeyByValue(setOfEncodedAuditories, 1);
		
		System.out.println(setOfEncodedAuditories.get(aud7));
		System.out.println(setOfAuditories.get(8).getAuditoryNumber());

		Period period1 = new Period(0, 1, "Monday", 1);
		Period period2 = new Period(1, 2, "Monday", 1);
		Period period3 = new Period(2, 3, "Monday", 1);
		Period period4 = new Period(3, 4, "Monday", 1);
		Period period5 = new Period(4, 5, "Monday", 1);
		Period period6 = new Period(5, 6, "Monday", 1);
		Period period7 = new Period(6, 1, "Tuesday", 1);
		Period period8 = new Period(7, 2, "Tuesday", 1);

		Period[] period = { period1, period2, period3, period4, period5,
				period6, period7, period8 };

		HashMap<Integer, Period> setOfPeriods = new HashMap<Integer, Period>();

		for (int i = 0; i < 8; i++) {
			setOfPeriods.put(i, period[i]);
		}

		HashMap<Period, Integer> setOfEncodedPeriods = Period
				.setOfEncodedPeriods(setOfPeriods,
						STARTPOINT + setOfEncodedGroups.size()
								+ setOfEncodedAuditories.size());
		System.out.println(setOfEncodedPeriods.get(period4));
		System.out.println(setOfPeriods.get(6).getDayOfTheWeek());

		Chromosome gene1 = new Chromosome(group1, aud1, period1);
		System.out.println(Chromosome
				.makeChromosome(group6, aud3, period3, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods));
		System.out.println(Chromosome
				.generateRandomChromosome(setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods));
		System.out.println(Individual.encode(setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods));

		System.out.println(Chromosome.represent1(1, 3, 7, setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods));

		// group1.getGroupCode().getLecturer()
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.add(1);
		a.add(2);
		a.add(3);
		a.add(3);
		a.add(5);
		a.add(6);

		java.util.Collections.shuffle(a);
		System.out.println(a);

		System.out.println(Individual.generateRandomAuditoriesList(15,
				setOfAuditories, setOfEncodedAuditories));
		System.out.println(Individual.generateRandomGroupsList(setOfGroups,
				setOfEncodedGroups));
		System.out.println(Individual.generateRandomPeriodsList(25,
				setOfPeriods, setOfEncodedPeriods));

	}

	public int calculateAuditoryStartPoint() {
		return 1;
	}

	
}
