package ga.thesis.crossover;

import ga.thesis.entities.Auditory;
import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Period;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PMX {

	public static ArrayList<ArrayList<ArrayList<Integer>>> crossOver(
			Individual ind1, Individual ind2, double probability) {
		ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> resGroups = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> resAuditories = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> resPeriods = new ArrayList<ArrayList<Integer>>();
		Random rand = new Random();

		resGroups = crossOverLists(ind1.getRepresentation().get(0), ind2
				.getRepresentation().get(0), probability);

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

	private static Random rand = new Random(System.currentTimeMillis());

	public static ArrayList<ArrayList<Integer>> crossOverLists(
			ArrayList<Integer> parent1, ArrayList<Integer> parent2,
			double probability) {
		return crossOverLists(parent1, parent2, probability, -1, -1);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<Integer>> crossOverLists(
			ArrayList<Integer> parent1, ArrayList<Integer> parent2,
			double probability, int crosspoint1, int crosspoint2) {
		ArrayList<ArrayList<Integer>> offspings = new ArrayList<ArrayList<Integer>>();
		if (rand.nextDouble() > probability) {
			offspings.add(parent1);
			offspings.add(parent2);
			return offspings;
		}

		// 1. Choose two different random crossover points

		int crossPoint1 = crosspoint1 > 0 ? crosspoint1 : rand.nextInt(parent1
				.size());
		int crossPoint2 = crosspoint2 > 0 ? crosspoint2 : rand.nextInt(parent1
				.size());

		while (crossPoint1 == crossPoint2) {
			crossPoint2 = rand.nextInt(parent1.size());
		}

		// calculate min
		int min = crossPoint1;
		if (crossPoint1 > crossPoint2) {
			min = crossPoint2;
		}

		int max = crossPoint2;
		if (crossPoint1 > crossPoint2) {
			max = crossPoint1;
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
			} else {
				List<ArrayList<Integer>> recovered = recoverChild_1(min, max,
						child1, child2);
				child1 = recovered.get(0);
				child2 = recovered.get(1);
			}
		}
		offspings.add(child1);
		offspings.add(child2);
		return offspings;
	}

	public static List<ArrayList<Integer>> recoverChild_1(int min,
			int crossLength, ArrayList<Integer> child1,
			ArrayList<Integer> child2) {

		for (int i = min; i <= crossLength; i++) {
			int conflict = hasConflict(child1.get(i), min, crossLength, child1);
			if (conflict >= 0) {
				child1.set(conflict, child2.get(i));
				Integer toChange = child2.get(i);
				int conflictIn2 = hasConflict(toChange, min, crossLength,
						child2);
				if (conflictIn2 >= 0) {
					child2.set(conflictIn2, child1.get(i));
				}
			}
		}

		for (int i = min; i <= crossLength; i++) {
			int conflict = hasConflict(child2.get(i), min, crossLength, child2);
			if (conflict >= 0) {
				child2.set(conflict, child1.get(i));
				Integer toChange = child1.get(i);
				int conflictIn2 = hasConflict(toChange, min, crossLength,
						child1);
				if (conflictIn2 >= 0) {
					child1.set(conflictIn2, child2.get(i));
				}
			}
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(child1);
		result.add(child2);

		return result;
	}

	public static int hasConflict(Integer elem, int min, int crossLength,
			ArrayList<Integer> child) {
		for (int i = 0; i < min; i++) {
			if (child.get(i).equals(elem)) {
				return i;
			}
		}
		for (int i = crossLength + 1; i < child.size(); i++) {
			if (child.get(i).equals(elem)) {
				return i;
			}
		}
		return -1;
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
}