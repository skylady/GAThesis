package ga.entities;

import java.util.List;

public class Individual {

	private List<Chromosome> individual;

	public Individual(List<Chromosome> individual) {
		this.individual = individual;
	}

	public List<Chromosome> getIndividual() {
		return individual;
	}

	public void setIndividual(List<Chromosome> individual) {
		this.individual = individual;
	}

}
