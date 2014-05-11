package ga.thesis.crossover;

import ga.thesis.entities.Auditory;
import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Period;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PMX {

	public static ArrayList<ArrayList<ArrayList<Integer>>> crossOver(
			Individual ind1, Individual ind2, double probability) {
		// TODO: bug on recover function - the same data
		ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> resGroups = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> resAuditories = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> resPeriods = new ArrayList<ArrayList<Integer>>();

		// crossover groups
		resGroups = crossOverLists(ind1.getRepresentation().get(0), ind2
				.getRepresentation().get(0), probability);

		// crossover auditories
		resAuditories = TwoPointCrossOver.crossOverLists(ind1
				.getRepresentation().get(1), ind2.getRepresentation().get(1),
				probability);

		// crossover periods
		resPeriods = TwoPointCrossOver.crossOverLists(ind1.getRepresentation()
				.get(2), ind2.getRepresentation().get(2), probability);

		for (int i = 0; i < resGroups.size(); i++) {
			ArrayList<ArrayList<Integer>> res1 = new ArrayList<ArrayList<Integer>>();
			res1.add(resGroups.get(i));
			res1.add(resAuditories.get(i));
			res1.add(resPeriods.get(i));
			res.add(res1);
			// resList.add(new Individual(Individual, res, length, fitness))
		}
		return res;
	}

	public static ArrayList<Individual> doPMX(Individual ind1, Individual ind2,
			double probability, HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		ArrayList<Individual> resIndLst = new ArrayList<Individual>();
		boolean isValid = false;
		while (!isValid) {
			ArrayList<ArrayList<ArrayList<Integer>>> res = crossOver(ind1,
					ind2, probability);
			Individual in1 = Individual.buildIndividualByRepresentation(
					res.get(0), setOfEncodedGroups, setOfEncodedAuditories,
					setOfEncodedPeriods, setOfGroups, setOfAuditories,
					setOfPeriods);
			Individual in2 = Individual.buildIndividualByRepresentation(
					res.get(1), setOfEncodedGroups, setOfEncodedAuditories,
					setOfEncodedPeriods, setOfGroups, setOfAuditories,
					setOfPeriods);
			if (Individual.isValidIndividual(in1, setOfEncodedGroups,
					setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
					setOfAuditories, setOfPeriods)) {
				if (Individual.isValidIndividual(in2, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods)) {
					resIndLst.add(in1);
					resIndLst.add(in2);
					isValid = true;
				}
			} else {
				isValid = false;
			}
		}
		return resIndLst;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<Integer>> crossOverLists(
			ArrayList<Integer> parent1, ArrayList<Integer> parent2,
			double probability) {
		ArrayList<ArrayList<Integer>> offspings = new ArrayList<ArrayList<Integer>>();
		// Should we do the crossover, based on the given probability?
		// If not just return the parents.
		Random rand = new Random();
		if (rand.nextDouble() > probability) {
			offspings.add(parent1);
			offspings.add(parent2);
			return offspings;
		}

		// 1. Choose two different random crossover points

		int crossPoint1 = rand.nextInt(parent1.size());
		int crossPoint2 = rand.nextInt(parent1.size());

		while (crossPoint1 == crossPoint2) {
			crossPoint2 = rand.nextInt(parent1.size());
		}

		// calculate min
		int min = crossPoint1;
		if (crossPoint1 > crossPoint2) {
			min = crossPoint2;
		}

		int crossLength = min + Math.abs(crossPoint2 - crossPoint1) + 1;

		// 2. Offsprings creation

		ArrayList<Integer> child1 = (ArrayList<Integer>) parent1.clone();
		ArrayList<Integer> child2 = (ArrayList<Integer>) parent2.clone();

		// 3. Put segments into childs
		for (int i = min; i < crossLength; i++) {
			child1.set(i, parent2.get(i));
			child2.set(i, parent1.get(i));
		}
		// 4. Recover offsprings
		boolean isValid = false;
		while (!isValid) {
			if (validChild(child1) && validChild(child2)) {
				isValid = true;
			} else if (!validChild(child1)) {
				child1 = recoverChild(min, crossLength, child1, child2);
			} else if (!validChild(child2)) {
				child2 = recoverChild(min, crossLength, child2, child1);
			}
		}

		offspings.add(child1);
		offspings.add(child2);

		return offspings;
	}

	public static ArrayList<Integer> recoverChild(int min, int crossLength,
			ArrayList<Integer> child1, ArrayList<Integer> child2) {
		// System.out.println("recover");
		for (int i = min; i < crossLength; i++) {

			for (int j = 0; j < min; j++) {
				if (child1.get(j).equals(child1.get(i))) {
					child1.set(j, child2.get(i));
				}
			}
			for (int j = crossLength; j < child1.size(); j++) {
				if (child1.get(j).equals(child1.get(i))) {
					child1.set(j, child2.get(i));
				}
			}
		}
		return child1;
	}

	public static boolean validChild(ArrayList<Integer> child1) {
		for (int i = 0; i < child1.size(); i++) {
			for (int j = i + 1; j < child1.size(); j++) {
				if (child1.get(i).equals(child1.get(j))) {
					return false;
				}
			}
		}
		return true;
	}

	public static ArrayList<ArrayList<Integer>> crossOverUnicityLists(
			ArrayList<Integer> listChr1, ArrayList<Integer> listChr2,
			double probability) {

		HashMap<Integer, Integer> tmpHashMap1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> tmpHashMap2 = new HashMap<Integer, Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		int value = 0;
		for (int i = 0; i < listChr1.size(); i++) {
			for (int j = i + 1; j < listChr1.size(); j++) {
				if (listChr1.get(i).equals(listChr1.get(j))) {
					int k = 9 + listChr1.size() + value;
					tmpHashMap1.put(k, listChr1.get(j));
					listChr1.set(j, k);
					value++;
				}
			}
		}
		value = 0;
		for (int i = 0; i < listChr2.size(); i++) {
			for (int j = i + 1; j < listChr2.size(); j++) {
				if (listChr2.get(i).equals(listChr2.get(j))) {
					int k = 9 + listChr2.size() + value;
					tmpHashMap2.put(k, listChr2.get(j));
					listChr2.set(j, k);
					value++;
				}
			}
		}

		System.out.println("1: " + listChr1);
		System.out.println("2: " + listChr2);
		res = crossOverLists(listChr1, listChr2, probability);
		System.out.println("res end");

		value = 0;
		for (int i = 0; i < res.get(0).size(); i++) {
			int k = 9 + res.get(0).size() + value;
			if (res.get(0).get(i).equals(k)) {
				res.get(0).set(i, tmpHashMap1.get(k));
				value++;
			}
		}
		value = 0;
		for (int i = 0; i < res.get(1).size(); i++) {
			int k = 9 + res.get(1).size() + value;
			if (res.get(1).get(i).equals(k)) {
				res.get(1).set(i, tmpHashMap1.get(k));
				value++;
			}
		}
		System.out.println("a cross");
		return res;
	}

}