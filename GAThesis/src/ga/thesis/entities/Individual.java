package ga.thesis.entities;

import ga.thesis.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Individual {

	private List<Chromosome> chromosomes;
	private ArrayList<ArrayList<Integer>> representation;
	private int length;
	private double fitness;

	public Individual(List<Chromosome> chromosomes,
			ArrayList<ArrayList<Integer>> representation, int length,
			double fitness) {
		this.chromosomes = chromosomes;
		this.representation = representation;
		this.length = length;
		this.fitness = fitness;
	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public ArrayList<ArrayList<Integer>> getRepresentation() {
		return representation;
	}

	public void setRepresentation(ArrayList<ArrayList<Integer>> representation) {
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

	public static ArrayList<Integer> generateRandomGroupsList(
			HashMap<Integer, Group> setOfGroups,
			HashMap<Group, Integer> setOfEncodedGroups) {
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfGroups.size(); i++) {
			resArr.add(setOfEncodedGroups.get(setOfGroups.get(i)));
		}
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static ArrayList<Integer> generateRandomAuditoriesList(
			int groupSize, HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Auditory, Integer> setOfEncodedAuditories) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfAuditories.size(); i++) {
			arr.add(setOfEncodedAuditories.get(setOfAuditories.get(i)));
		}

		for (int i = 0; i < groupSize; i++) {
			// or maybe use shuffle !
			resArr.add(arr.get(r.nextInt(arr.size())));
		}
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static ArrayList<Integer> generateRandomPeriodsList(int groupSize,
			HashMap<Integer, Period> setOfPeriods,
			HashMap<Period, Integer> setOfEncodedPeriods) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfPeriods.size(); i++) {
			arr.add(setOfEncodedPeriods.get(setOfPeriods.get(i)));
		}

		for (int i = 0; i < groupSize; i++) {
			resArr.add(arr.get(r.nextInt(arr.size())));
		}
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static Individual generateIndividual(
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		ArrayList<ArrayList<Integer>> resIndividual = new ArrayList<ArrayList<Integer>>();
		resIndividual.add(generateRandomGroupsList(setOfGroups,
				setOfEncodedGroups));
		resIndividual.add(generateRandomAuditoriesList(setOfGroups.size(),
				setOfAuditories, setOfEncodedAuditories));
		resIndividual.add(generateRandomPeriodsList(setOfGroups.size(),
				setOfPeriods, setOfEncodedPeriods));
		List<Chromosome> chrList = new ArrayList<Chromosome>();

		for (int i = 0; i < setOfGroups.size(); i++) {
			chrList.add(new Chromosome(Utils.getKeyByValue(setOfEncodedGroups,
					resIndividual.get(0).get(i)), Utils.getKeyByValue(
					setOfEncodedAuditories, resIndividual.get(1).get(i)), Utils
					.getKeyByValue(setOfEncodedPeriods, resIndividual.get(2)
							.get(i))));
		}

		return new Individual(chrList, resIndividual, resIndividual.size(), 0.0);
	}

	public static Individual generateValidIndividual(
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		Individual resIndividual = generateIndividual(setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods);
		if (!isValidIndividual(resIndividual, setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods)) {
			resIndividual = generateIndividual(setOfEncodedGroups,
					setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
					setOfAuditories, setOfPeriods);
		}
		// double fitness=0.0;
		resIndividual
				.setFitness(calculateFitness(resIndividual, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods));
		return resIndividual;

	}
	
	public static <T> boolean isValidList(List<T> list) {
		Set<T> set = new HashSet<T>(list.size());
		for (T item: list) {
			if (!set.add(item)) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isValidIndividual(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		int i = 0;
		// 1: Each lecturer has only one period at the same day at the same
		// auditory

		
		
		// 2: Each group can have only one period at the same time and day

		// 3: In the each auditory only one group can have period at the same
		// moment

		// 4: Size of group < size of auditory
		for (i = 0; i < ind.getLength(); i++) {
			if (!(ind.getChromosomes().get(i).getGroup().getGroupCode()
					.getGroupSize() <= ind.getChromosomes().get(i)
					.getAuditory().getAuditorySize())) {
				return false;
			}
		}

		return true;
	}

	public static double calculateFitness(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		// to do
		return 0.0;
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
}
