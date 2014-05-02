package ga.entities;

import java.util.HashMap;

public class Period {

	private int id;
	private int numberOfPeriod;
	private String dayOfTheWeek;
	private int weekNumber;

	public Period(int id, int numberOfPeriod, String dayOfTheWeek, int weekNumber) {
		this.id = id;
		this.numberOfPeriod = numberOfPeriod;
		this.dayOfTheWeek = dayOfTheWeek;
		// this.weekNumber = weekNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfPeriod() {
		return numberOfPeriod;
	}

	public void setNumberOfPeriod(int numberOfPeriod) {
		this.numberOfPeriod = numberOfPeriod;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public static HashMap<Integer, Period> setOfPeriods(Period Period,
			int length) {
		HashMap<Integer, Period> setOfPeriods = new HashMap<Integer, Period>();
		for (int i = 0; i < length; i++) {
			setOfPeriods.put(i, Period);
		}
		return setOfPeriods;
	}

	public static HashMap<Period, Integer> setOfEncodedPeriods(
			HashMap<Integer, Period> setOfPeriods, Integer startPoint) {
		HashMap<Period, Integer> setOfEncodedPeriods = new HashMap<Period, Integer>();
		for (int i = 0; i < setOfPeriods.size(); i++) {
			setOfEncodedPeriods.put(setOfPeriods.get(i), startPoint);
			startPoint++;
		}
		return setOfEncodedPeriods;
	}
}
