package ga.entities;

public class Chromosome {

	private Group group;
	private Auditory auditory;
	private Pair pair;

	public Chromosome(Group group, Auditory auditory, Pair pair) {
		this.group = group;
		this.auditory = auditory;
		this.pair = pair;
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

	public Pair getPair() {
		return pair;
	}

	public void setPair(Pair pair) {
		this.pair = pair;
	}

	public String makeChromosome() {
		return null;

	}

}
