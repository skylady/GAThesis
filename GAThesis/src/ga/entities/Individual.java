package ga.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Individual {

	private List<Chromosome> chromosomes;
	private static String representation;
	private int length;
	private double fitness;

	public Individual(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;

	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public static String encode(HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		String represe = "";
		for (int i = 0; i < 5; i++) {
			String str = Chromosome.generateRandomChromosome(
					setOfEncodedGroups, setOfEncodedAuditories,
					setOfEncodedPeriods, setOfGroups, setOfAuditories,
					setOfPeriods);
			represe = represe.concat(str);
		}
		return represe;
	}

//	public static String decode(String representation) {
//		String represe = "";
//		for (int i = 0; i < 5; i++) {
//			String str = Chromosome.generateRandomChromosome(
//					setOfEncodedGroups, setOfEncodedAuditories,
//					setOfEncodedPeriods, setOfGroups, setOfAuditories,
//					setOfPeriods);
//			represe = represe.concat(str);
//		}
//		return represe;
//	}
	
	public Individual generateRandomChromosomes(int length, Random random,
			int groupSize, int auditorySize, int periodSize) {

		return null;

	}

}
