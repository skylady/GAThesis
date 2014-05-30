package ga.thesis.testdata;

import ga.thesis.entities.Period;

import java.util.HashMap;

public class PeriodTestData {
	public static final int STARTPOINT = 10;

	public static Pair<HashMap<Integer, Period>, HashMap<Period, Integer>> createPeriods() {

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
				.setOfEncodedPeriods(setOfPeriods, STARTPOINT);
		return new Pair<HashMap<Integer, Period>, HashMap<Period, Integer>>(
				setOfPeriods, setOfEncodedPeriods);
	}
}
