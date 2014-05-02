package ga.entities;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
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

		HashMap<Integer, Auditory> aud = new HashMap<Integer, Auditory>();
		
			for (int i = 0; i < 11; i++) {
				aud.put(i, araud[i]);
			}
		
		
			HashMap<Auditory, Integer> codeaud = Auditory
					.setOfEncodedAuditories(aud, 10);
			System.out.println(codeaud.get(aud7));
			System.out.println(aud.get(8).getAuditoryNumber());
		

		Period period1 = new Period(0, 1, "Monday", 1);
		Period period2 = new Period(1, 2, "Monday", 1);
		Period period3 = new Period(2, 3, "Monday", 1);
		Period period4 = new Period(3, 4, "Monday", 1);
		Period period5 = new Period(4, 5, "Monday", 1);
		Period period6 = new Period(5, 6, "Monday", 1);
		Period period7 = new Period(6, 1, "Tuesday", 1);
		Period period8 = new Period(7, 2, "Tuesday", 1);
		
		
		Period[] period = { period1, period2, period3, period4, period5, period6, period7, period8};

		HashMap<Integer, Period> perioda = new HashMap<Integer, Period>();
		
			for (int i = 0; i < 8; i++) {
				perioda.put(i, period[i]);
			}
		
		
			HashMap<Period, Integer> codePeriod = Period
					.setOfEncodedPeriods(perioda, 0);
			System.out.println(codePeriod.get(period4));
			System.out.println(perioda.get(6).getDayOfTheWeek());
		
		
		GroupCode groupCode1 = new GroupCode(0, 3, "lecture", "Gul", 0);
		Group group1 = new Group(0, groupCode1, 1);
		Chromosome gene1 = new Chromosome(group1, aud1, period1);

	}

	public int calculateAuditoryStartPoint() {
		return 1;
	}
}
