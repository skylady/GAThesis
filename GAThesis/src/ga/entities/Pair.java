package ga.entities;

public class Pair {

	private int id;
	private int numberOfPair;
	private String dayOfTheWeek;
	private int weekNumber;

	public Pair(int id, int numberOfPair, String dayOfTheWeek, int weekNumber) {
		this.id = id;
		this.numberOfPair = numberOfPair;
		this.dayOfTheWeek = dayOfTheWeek;
		//this.weekNumber = weekNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfPair() {
		return numberOfPair;
	}

	public void setNumberOfPair(int numberOfPair) {
		this.numberOfPair = numberOfPair;
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

	// HashMap
}
