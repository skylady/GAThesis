package ga.thesis.entities;

import ga.thesis.crossover.PMX;
import ga.thesis.restrictions.HardRestrictions;
import ga.thesis.restrictions.SoftRestrictions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test {
	public static final int STARTPOINT = 10;

	public static void main(String[] args) {
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

		Lecturer lect1 = new Lecturer(1, "Gulaeva", new ArrayList<Period>(
				Arrays.asList(period5, period6, period11, period12)));
		Lecturer lect2 = new Lecturer(1, "Procenko", new ArrayList<Period>(
				Arrays.asList(period7, period27, period28, period29, period30)));
		Lecturer lect3 = new Lecturer(1, "Grechko", new ArrayList<Period>());
		Lecturer lect4 = new Lecturer(1, "Cherkasov",
				new ArrayList<Period>(Arrays.asList(period17, period14,
						period15, period16, period18)));
		Lecturer lect5 = new Lecturer(1, "Gor", new ArrayList<Period>(
				Arrays.asList(period1, period7, period13, period19, period25)));
		Lecturer lect6 = new Lecturer(1, "Fran", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect7 = new Lecturer(1, "Dorosh", new ArrayList<Period>());
		Lecturer lect8 = new Lecturer(1, "Opanasyuk", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect9 = new Lecturer(1, "Zahar", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect10 = new Lecturer(1, "Mytnyk", new ArrayList<Period>());
		Lecturer lect11 = new Lecturer(1, "Pul", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect12 = new Lecturer(1, "Rus", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect13 = new Lecturer(1, "Kryk", new ArrayList<Period>());
		Lecturer lect14 = new Lecturer(1, "OPZ", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect15 = new Lecturer(1, "Sydor", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect16 = new Lecturer(1, "Afo", new ArrayList<Period>());
		Lecturer lect17 = new Lecturer(1, "Boroz", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));

		GroupCode groupCode1 = new GroupCode(0, "GA", "lect", lect1, 11);
		GroupCode groupCode2 = new GroupCode(1, "GA", "prakt", lect1, 11);
		GroupCode groupCode3 = new GroupCode(2, "VDM", "lect", lect2, 11);
		GroupCode groupCode4 = new GroupCode(3, "VDM", "prakt", lect2, 11);
		GroupCode groupCode5 = new GroupCode(4, "PPP", "lect", lect3, 11);
		GroupCode groupCode6 = new GroupCode(5, "PPP", "prakt", lect3, 11);
		GroupCode groupCode7 = new GroupCode(6, "Qos", "lect", lect4, 11);
		GroupCode groupCode8 = new GroupCode(7, "Qos", "prakt", lect4, 11);
		GroupCode groupCode9 = new GroupCode(8, "NDS", "lect", lect5, 11);
		GroupCode groupCode10 = new GroupCode(9, "NDS", "prakt", lect5, 11);
		GroupCode groupCode11 = new GroupCode(10, "Oxorona", "lect", lect6, 11);
		GroupCode groupCode12 = new GroupCode(11, "Oxorona", "prakt", lect6, 11);
		GroupCode groupCode13 = new GroupCode(12, "GWT", "lect", lect7, 11);
		GroupCode groupCode14 = new GroupCode(13, "GWT", "prakt", lect7, 11);

		// ---1 PI
		GroupCode groupCode15 = new GroupCode(0, "PH", "lect", lect8, 60);
		GroupCode groupCode16 = new GroupCode(1, "PH", "prakt", lect8, 10);
		GroupCode groupCode17 = new GroupCode(2, "PH", "prakt", lect8, 10);
		GroupCode groupCode18 = new GroupCode(3, "PH", "prakt", lect8, 10);

		GroupCode groupCode19 = new GroupCode(0, "MA", "lect", lect9, 60);
		GroupCode groupCode20 = new GroupCode(1, "MA", "prakt", lect9, 20);
		GroupCode groupCode21 = new GroupCode(2, "MA", "prakt", lect10, 20);
		GroupCode groupCode22 = new GroupCode(3, "MA", "prakt", lect11, 20);

		GroupCode groupCode23 = new GroupCode(0, "LA", "lect", lect12, 60);
		GroupCode groupCode24 = new GroupCode(1, "LA", "prakt", lect12, 20);
		GroupCode groupCode25 = new GroupCode(2, "LA", "prakt", lect13, 20);
		GroupCode groupCode26 = new GroupCode(3, "LA", "prakt", lect13, 20);

		// 4 ---

		GroupCode groupCode27 = new GroupCode(0, "SP", "lect", lect14, 42);
		GroupCode groupCode28 = new GroupCode(1, "SP", "prakt", lect14, 14);
		GroupCode groupCode29 = new GroupCode(2, "SP", "prakt", lect14, 14);
		GroupCode groupCode30 = new GroupCode(3, "SP", "prakt", lect14, 14);

		GroupCode groupCode31 = new GroupCode(0, "UPP", "lect", lect2, 42);
		GroupCode groupCode32 = new GroupCode(1, "UPP", "prakt", lect2, 14);
		GroupCode groupCode33 = new GroupCode(2, "UPP", "prakt", lect15, 14);
		GroupCode groupCode34 = new GroupCode(3, "UPP", "prakt", lect15, 14);

		GroupCode groupCode35 = new GroupCode(0, "TPZ", "lect", lect16, 42);
		GroupCode groupCode36 = new GroupCode(1, "TPZ", "prakt", lect16, 14);
		GroupCode groupCode37 = new GroupCode(2, "TPZ", "prakt", lect17, 14);
		GroupCode groupCode38 = new GroupCode(3, "TPZ", "prakt", lect16, 14);

		GroupCode groupCode39 = new GroupCode(0, "TM", "lect", lect16, 42);
		GroupCode groupCode40 = new GroupCode(1, "TM", "prakt", lect16, 14);
		GroupCode groupCode41 = new GroupCode(1, "TM", "prakt", lect16, 14);

		Group group1 = new Group(1, groupCode1, 0, "IUST-1");
		Group group2 = new Group(2, groupCode2, 1, "IUST-1");
		Group group3 = new Group(3, groupCode3, 0, "IUST-1");
		Group group4 = new Group(4, groupCode4, 1, "IUST-1");
		Group group5 = new Group(5, groupCode5, 0, "IUST-2");
		Group group6 = new Group(6, groupCode6, 1, "IUST-2");
		Group group7 = new Group(7, groupCode7, 0, "IUST-1");
		Group group8 = new Group(8, groupCode8, 1, "IUST-1");
		Group group9 = new Group(9, groupCode9, 0, "IUST-1");
		Group group10 = new Group(10, groupCode10, 1, "IUST-1");
		Group group11 = new Group(11, groupCode11, 0, "IUST-1");
		Group group12 = new Group(12, groupCode12, 1, "IUST-1");
		Group group13 = new Group(13, groupCode13, 0, "IUST-1");
		Group group14 = new Group(14, groupCode14, 1, "IUST-1");

		Group group15 = new Group(10, groupCode15, 0, "PI-1");
		Group group16 = new Group(11, groupCode16, 1, "PI-1");
		Group group17 = new Group(12, groupCode17, 2, "PI-1");
		Group group18 = new Group(13, groupCode18, 3, "PI-1");

		Group group19 = new Group(10, groupCode19, 0, "PI-1");
		Group group20 = new Group(11, groupCode20, 1, "PI-1");
		Group group21 = new Group(12, groupCode21, 2, "PI-1");
		Group group22 = new Group(13, groupCode22, 3, "PI-1");

		Group group23 = new Group(10, groupCode23, 0, "PI-1");
		Group group24 = new Group(11, groupCode24, 1, "PI-1");
		Group group25 = new Group(12, groupCode25, 2, "PI-1");
		Group group26 = new Group(13, groupCode26, 3, "PI-1");

		// --4
		Group group27 = new Group(10, groupCode27, 0, "PI-4");
		Group group28 = new Group(11, groupCode28, 1, "PI-4");
		Group group29 = new Group(12, groupCode29, 2, "PI-4");
		Group group30 = new Group(13, groupCode30, 3, "PI-4");

		Group group31 = new Group(10, groupCode31, 0, "PI-4");
		Group group32 = new Group(11, groupCode32, 1, "PI-4");
		Group group33 = new Group(12, groupCode33, 2, "PI-4");
		Group group34 = new Group(13, groupCode34, 3, "PI-4");

		Group group35 = new Group(10, groupCode35, 0, "PI-4");
		Group group36 = new Group(11, groupCode36, 1, "PI-4");
		Group group37 = new Group(12, groupCode37, 2, "PI-4");
		Group group38 = new Group(13, groupCode38, 3, "PI-4");

		Group[] group = { group1, group2, group3, group4, group5, group6,
				group7, group8, group9, group10, group11, group12, group13,
				group14, group15, group16, group17, group18, group19, group20,
				group21, group22, group23, group24, group25, group26, group27,
				group28, group29, group30, group31, group32, group33, group34,
				group35, group36, group37, group38 };

		HashMap<Integer, Group> setOfGroups = new HashMap<Integer, Group>();

		for (int i = 0; i < 38; i++) {
			setOfGroups.put(i, group[i]);
		}

		HashMap<Group, Integer> setOfEncodedGroups = Group.setOfEncodedGroups(
				setOfGroups, STARTPOINT);
		System.out.println("set size: " + setOfGroups.size());
		System.out.println("encoded size: " + setOfEncodedGroups.size());
		System.out.println(setOfGroups.get(3).getGroupCode().getSubject());

		Auditory aud1 = new Auditory(3, "223", 100);
		Auditory aud2 = new Auditory(9, "313", 100);
		Auditory aud3 = new Auditory(10, "225", 80);
		Auditory aud4 = new Auditory(11, "3-310", 80);
		Auditory aud5 = new Auditory(8, "310", 30);
		Auditory aud6 = new Auditory(12, "3-220a", 30);
		Auditory aud7 = new Auditory(16, "1-112", 30);
		Auditory aud8 = new Auditory(1, "208", 14);
		Auditory aud9 = new Auditory(2, "206", 14);
		Auditory aud10 = new Auditory(4, "309", 14);
		Auditory aud11 = new Auditory(5, "306", 14);
		Auditory aud12 = new Auditory(6, "307", 14);
		Auditory aud13 = new Auditory(7, "331", 14);
		Auditory aud14 = new Auditory(13, "2-204", 14);
		Auditory aud15 = new Auditory(14, "2-214", 14);
		Auditory aud16 = new Auditory(15, "1-110", 14);

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
		// System.out.println(Individual.generateRandomAuditoriesList(15,
		// setOfAuditories, setOfEncodedAuditories));
		System.out.println("periods:");
		System.out.println(Individual.generateRandomPeriodsList(25,
				setOfPeriods, setOfEncodedPeriods));
		System.out.println("individual:");

		for (int i = 0; i < 20; i++) {
			Individual ind = Individual.generateValidIndividual(
					setOfEncodedGroups, setOfEncodedAuditories,
					setOfEncodedPeriods, setOfGroups, setOfAuditories,
					setOfPeriods);
			System.out.println(ind.getRepresentation());
			System.out.println("Fitness:"
					+ SoftRestrictions.fitnessFunction(ind));
		}

		System.out.println("Fitness Test: "
				+ SoftRestrictions.fitnessFunction(Individual
						.generateValidIndividual(setOfEncodedGroups,
								setOfEncodedAuditories, setOfEncodedPeriods,
								setOfGroups, setOfAuditories, setOfPeriods)));

		// System.out
		// .println(Individual.decode(Individual.generateValidIndividual(
		// setOfEncodedGroups, setOfEncodedAuditories,
		// setOfEncodedPeriods, setOfGroups, setOfAuditories,
		// setOfPeriods), setOfEncodedGroups,
		// setOfEncodedAuditories, setOfEncodedPeriods,
		// setOfGroups, setOfAuditories, setOfPeriods));
		//
		// Individual in1 =
		// Individual.generateValidIndividual(setOfEncodedGroups,
		// setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
		// setOfAuditories, setOfPeriods);
		// Individual in2 =
		// Individual.generateValidIndividual(setOfEncodedGroups,
		// setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
		// setOfAuditories, setOfPeriods);
		// System.out.println("Ind1: " + in1.getRepresentation());
		// System.out.println("Ind2: " + in2.getRepresentation());
		// ArrayList<Individual> res = PMX
		// .doPMX(in1, in2, 1.0, setOfEncodedGroups,
		// setOfEncodedAuditories, setOfEncodedPeriods,
		// setOfGroups, setOfAuditories, setOfPeriods);
		// System.out.println("After Ind1: " + res.get(0).getRepresentation());
		// System.out.println("After Ind2: " + res.get(1).getRepresentation());

	}

	public int calculateAuditoryStartPoint() {
		return 1;
	}

}
