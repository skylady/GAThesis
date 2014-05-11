package ga.thesis.entities;

import ga.thesis.restrictions.HardRestrictions;
import ga.thesis.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			ArrayList<Integer> groups, HashMap<Integer, Group> setOfGroups,
			HashMap<Group, Integer> setOfEncodedGroups) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfAuditories.size(); i++) {
			arr.add(setOfEncodedAuditories.get(setOfAuditories.get(i)));
		}

		int rand;
		for (int i = 0; i < groupSize; i++) {
			if (Utils.getKeyByValue(setOfEncodedGroups, groups.get(i))
					.getGroupCode().getGroupSize() > 30) {
				rand = (arr.get(r.nextInt(3)));
			} else if (Utils.getKeyByValue(setOfEncodedGroups, groups.get(i))
					.getGroupCode().getGroupSize() > 14) {
				rand = (arr.get(r.nextInt(6)));
//
//			} else if (Utils.getKeyByValue(setOfEncodedGroups, groups.get(i))
//					.getGroupCode().getGroupSize() > 30) {
//				rand = (arr.get(r.nextInt(3)));
			} else {
				rand = arr.get(r.nextInt((arr.size() - 6)) + 6);
			}
			resArr.add(rand);
		}
		// java.util.Collections.shuffle(resArr);
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
		List<Chromosome> chrList = new ArrayList<Chromosome>();
		resIndividual.add(generateRandomGroupsList(setOfGroups,
				setOfEncodedGroups));
		resIndividual.add(generateRandomAuditoriesList(setOfGroups.size(),
				setOfAuditories, setOfEncodedAuditories, resIndividual.get(0),
				setOfGroups, setOfEncodedGroups));
		resIndividual.add(generateRandomPeriodsList(setOfGroups.size(),
				setOfPeriods, setOfEncodedPeriods));

		for (int i = 0; i < setOfGroups.size(); i++) {
			chrList.add(new Chromosome(Utils.getKeyByValue(setOfEncodedGroups,
					resIndividual.get(0).get(i)), Utils.getKeyByValue(
					setOfEncodedAuditories, resIndividual.get(1).get(i)), Utils
					.getKeyByValue(setOfEncodedPeriods, resIndividual.get(2)
							.get(i))));
		}

		return new Individual(chrList, resIndividual, chrList.size(), 0.0);
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
		boolean flag = true;
		while (flag) {
			if (!isValidIndividual(resIndividual, setOfEncodedGroups,
					setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
					setOfAuditories, setOfPeriods)) {
				resIndividual = generateIndividual(setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods);
			} else {
				flag = false;
			}

		}
		// double fitness=0.0;
		resIndividual
				.setFitness(calculateFitness(resIndividual, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods));
		return resIndividual;

	}

	public static boolean isValidIndividual(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		if (!HardRestrictions.lecturerPeriodUnicity(ind)) {
			return false;
		}
		if (!HardRestrictions.groupNumberChecker(ind)) {
			return false;
		}

		if (!HardRestrictions.auditoryUnicity(ind)) {
			return false;
		}
		if (!HardRestrictions.groupSizeLessAuditorySize(ind)) {
			return false;
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

	public static String decode(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		for (int i = 0; i < ind.getLength(); i++) {
			System.out.println("---" + i + "---");
			System.out.print(ind.getChromosomes().get(i).getGroup()
					.getGroupCode().getSubject()
					+ " "
					+ ind.getChromosomes().get(i).getGroup().getGroupNumber()
					+ "___");
			System.out.print(ind.getChromosomes().get(i).getAuditory()
					.getAuditoryNumber()
					+ "___");
			System.out.println(ind.getChromosomes().get(i).getPeriod()
					.getDayOfTheWeek()
					+ " "
					+ ind.getChromosomes().get(i).getPeriod()
							.getNumberOfPeriod() + "___");
		}
		return "done";
	}

	public static Individual buildIndividualByRepresentation(
			ArrayList<ArrayList<Integer>> representation,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		List<Chromosome> chrList = new ArrayList<Chromosome>();
		double fitness = 0.0;

		for (int i = 0; i < setOfGroups.size(); i++) {
			chrList.add(new Chromosome(Utils.getKeyByValue(setOfEncodedGroups,
					representation.get(0).get(i)), Utils.getKeyByValue(
					setOfEncodedAuditories, representation.get(1).get(i)),
					Utils.getKeyByValue(setOfEncodedPeriods, representation
							.get(2).get(i))));
		}
		Individual resIndividual = new Individual(chrList, representation,
				representation.size(), fitness);
		resIndividual
				.setFitness(calculateFitness(resIndividual, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods));
		return resIndividual;

	}

	@Override
	public String toString() {
		return "Individual [chromosomes=" + chromosomes + ", representation="
				+ representation + ", length=" + length + ", fitness="
				+ fitness + "]";
	}
}
