package ga.thesis.entities;

import ga.thesis.restrictions.HardRestrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public static final int STARTPOINT = 10;

	public static void main(String[] args) {

		GroupCode groupCode1 = new GroupCode(0, "GA", "lect", "Gulayeva", 11);
		GroupCode groupCode2 = new GroupCode(1, "GA", "prakt", "Gulayeva", 11);
		GroupCode groupCode3 = new GroupCode(2, "VDM", "lect", "Procenko", 11);
		GroupCode groupCode4 = new GroupCode(3, "VDM", "prakt", "Procenko", 11);
		GroupCode groupCode5 = new GroupCode(4, "PPP", "lect", "Grechko", 11);
		GroupCode groupCode6 = new GroupCode(5, "PPP", "prakt", "Grecko", 11);
		GroupCode groupCode7 = new GroupCode(6, "Qos", "lect", "Cherkasov", 11);
		GroupCode groupCode8 = new GroupCode(7, "Qos", "prakt", "Cherkasov", 11);
		GroupCode groupCode9 = new GroupCode(8, "NDS", "lect", "Gor", 11);
		GroupCode groupCode10 = new GroupCode(9, "NDS", "prakt", "Gor", 11);
		GroupCode groupCode11 = new GroupCode(10, "Oxorona", "lect", "Fran", 11);
		GroupCode groupCode12 = new GroupCode(11, "Oxorona", "prakt", "Fran",
				11);
		GroupCode groupCode13 = new GroupCode(12, "GWT", "lect", "Dorosh", 11);
		GroupCode groupCode14 = new GroupCode(13, "GWT", "prakt", "Dorosh", 11);

		Group group1 = new Group(1, groupCode1, 0);
		Group group2 = new Group(2, groupCode2, 1);
		Group group3 = new Group(3, groupCode3, 0);
		Group group4 = new Group(4, groupCode4, 1);
		Group group5 = new Group(5, groupCode5, 0);
		Group group6 = new Group(6, groupCode6, 1);
		Group group7 = new Group(7, groupCode7, 0);
		Group group8 = new Group(8, groupCode8, 1);
		Group group9 = new Group(9, groupCode9, 0);
		Group group10 = new Group(10, groupCode10, 1);
		Group group11 = new Group(11, groupCode11, 0);
		Group group12 = new Group(12, groupCode12, 1);
		Group group13 = new Group(13, groupCode13, 0);
		Group group14 = new Group(14, groupCode14, 1);

		Group[] group = { group1, group2, group3, group4, group5, group6,
				group7, group8, group9, group10, group11, group12, group13,
				group14 };

		HashMap<Integer, Group> setOfGroups = new HashMap<Integer, Group>();

		for (int i = 0; i < 14; i++) {
			setOfGroups.put(i, group[i]);
		}

		HashMap<Group, Integer> setOfEncodedGroups = Group.setOfEncodedGroups(
				setOfGroups, STARTPOINT);
		System.out.println("set size: " + setOfGroups.size());
		System.out.println("encoded size: " + setOfEncodedGroups.size());
		System.out.println(setOfGroups.get(3).getGroupCode().getSubject());

		Auditory aud1 = new Auditory(1, "208", 12);
		Auditory aud2 = new Auditory(2, "206", 12);
		Auditory aud3 = new Auditory(3, "223", 100);
		Auditory aud4 = new Auditory(4, "309", 12);
		Auditory aud5 = new Auditory(5, "306", 12);
		Auditory aud6 = new Auditory(6, "307", 12);
		Auditory aud7 = new Auditory(7, "331", 14);
		Auditory aud8 = new Auditory(8, "310", 30);
		Auditory aud9 = new Auditory(9, "313", 100);
		Auditory aud10 = new Auditory(10, "225", 80);
		Auditory aud11 = new Auditory(11, "3-310", 60);
		Auditory aud12 = new Auditory(12, "3-220a", 30);
		Auditory aud13 = new Auditory(13, "2-204", 12);
		Auditory aud14 = new Auditory(14, "2-214", 12);
		Auditory aud15 = new Auditory(15, "1-110", 14);
		Auditory aud16 = new Auditory(16, "1-112", 14);

		Auditory[] araud = { aud1, aud2, aud3, aud4, aud5, aud6, aud7, aud8,
				aud9, aud10, aud11, aud12, aud13, aud14, aud15, aud16 };

		HashMap<Integer, Auditory> setOfAuditories = new HashMap<Integer, Auditory>();

		for (int i = 0; i < 16; i++) {
			setOfAuditories.put(i, araud[i]);
		}

		HashMap<Auditory, Integer> setOfEncodedAuditories = Auditory
				.setOfEncodedAuditories(setOfAuditories, STARTPOINT
						+ setOfEncodedGroups.size());

		// Auditory keyByValue = getKeyByValue(setOfEncodedAuditories, 1);

		System.out.println(setOfEncodedAuditories.get(aud7));
		System.out.println(setOfAuditories.get(8).getAuditoryNumber());

		Period period1 = new Period(1, 1, "Monday");
		Period period2 = new Period(2, 2, "Monday");
		Period period3 = new Period(3, 3, "Monday");
		Period period4 = new Period(4, 4, "Monday");
		Period period5 = new Period(5, 5, "Monday");
		Period period6 = new Period(6, 6, "Monday");
		Period period7 = new Period(7, 1, "Tuesday");
		Period period8 = new Period(8, 2, "Tuesday");
		Period period9 = new Period(9, 3, "Tuesday");
		Period period10 = new Period(10, 4, "Tuesday");
		Period period11 = new Period(11, 5, "Tuesday");
		Period period12 = new Period(12, 6, "Tuesday");
		Period period13 = new Period(13, 1, "Wednesday");
		Period period14 = new Period(14, 2, "Wednesday");
		Period period15 = new Period(15, 3, "Wednesday");
		Period period16 = new Period(16, 4, "Wednesday");
		Period period17 = new Period(17, 5, "Wednesday");
		Period period18 = new Period(18, 6, "Wednesday");
		Period period19 = new Period(19, 1, "Thursday");
		Period period20 = new Period(20, 2, "Thursday");
		Period period21 = new Period(21, 3, "Thursday");
		Period period22 = new Period(22, 4, "Thursday");
		Period period23 = new Period(23, 5, "Thursday");
		Period period24 = new Period(24, 6, "Thursday");
		Period period25 = new Period(25, 1, "Friday");
		Period period26 = new Period(26, 2, "Friday");
		Period period27 = new Period(27, 3, "Friday");
		Period period28 = new Period(28, 4, "Friday");
		Period period29 = new Period(29, 5, "Friday");
		Period period30 = new Period(30, 6, "Friday");

		Period[] period = { period1, period2, period3, period4, period5,
				period6, period7, period8, period9, period10, period11,
				period12, period13, period14, period15, period16, period17,
				period18, period19, period20, period21, period22, period23,
				period24, period25, period26, period27, period28, period29,
				period30 };

		HashMap<Integer, Period> setOfPeriods = new HashMap<Integer, Period>();

		for (int i = 0; i < 30; i++) {
			setOfPeriods.put(i, period[i]);
		}

		HashMap<Period, Integer> setOfEncodedPeriods = Period
				.setOfEncodedPeriods(setOfPeriods,
						STARTPOINT + setOfEncodedGroups.size()
								+ setOfEncodedAuditories.size());
		System.out.println(setOfEncodedPeriods.get(period4));
		System.out.println(setOfPeriods.get(6).getDayOfTheWeek());

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

		System.out.println("groups:");
		System.out.println(Individual.generateRandomGroupsList(setOfGroups,
				setOfEncodedGroups));
		System.out.println("auditories:");
		System.out.println(Individual.generateRandomAuditoriesList(15,
				setOfAuditories, setOfEncodedAuditories));
		System.out.println("periods:");
		System.out.println(Individual.generateRandomPeriodsList(25,
				setOfPeriods, setOfEncodedPeriods));
		System.out.println("individual:");

//		System.out.println(Individual
//				.generateValidIndividual(setOfEncodedGroups,
//						setOfEncodedAuditories, setOfEncodedPeriods,
//						setOfGroups, setOfAuditories, setOfPeriods)
//				.getRepresentation());
//		System.out
//				.println(Individual.decode(Individual.generateValidIndividual(
//						setOfEncodedGroups, setOfEncodedAuditories,
//						setOfEncodedPeriods, setOfGroups, setOfAuditories,
//						setOfPeriods), setOfEncodedGroups,
//						setOfEncodedAuditories, setOfEncodedPeriods,
//						setOfGroups, setOfAuditories, setOfPeriods));
		ArrayList<Chromosome> list = new ArrayList<Chromosome>();

		Chromosome chr1 = new Chromosome(group1, aud1, period2);
		Chromosome chr2 = new Chromosome(group2, aud2, period1);
		Chromosome chr3 = new Chromosome(group5, aud3, period3);
	//	Chromosome chr4 = new Chromosome(group6, aud3, period1);
		list.add(chr1);
		list.add(chr2);
		list.add(chr3);
	//	list.add(chr4);
		ArrayList<ArrayList<Integer>> arList = new ArrayList<ArrayList<Integer>>();
		Individual ind = new Individual(list, arList, 3, 0.0);
		if (HardRestrictions.lecturerPeriodUnicity(ind) == true) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		if (HardRestrictions.groupNumberChecker(ind) == true) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

	public int calculateAuditoryStartPoint() {
		return 1;
	}

}
