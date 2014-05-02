package ga.entities;

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

}
