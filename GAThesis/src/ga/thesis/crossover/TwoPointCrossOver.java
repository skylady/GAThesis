package ga.thesis.crossover;

import java.util.ArrayList;
import java.util.Random;

public class TwoPointCrossOver {

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

		offspings.add(child1);
		offspings.add(child2);
		return offspings;
	}

}
