package ga.thesis.mutation;

import java.util.HashMap;
import java.util.Random;

import ga.thesis.entities.Auditory;
import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Period;

public class InsertionMutation {

	public static Individual insertionMutation(Individual ind,
			double probability, HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		boolean isValid = false;
		Random rand = new Random();
		if (rand.nextDouble() > probability) {
			return ind;
		}
		while (!isValid) {
			int identifier = rand.nextInt(2);
			int mutationPoint1 = rand.nextInt(ind.getLength());
			int mutationPointToPut = rand.nextInt(ind.getLength());

			while (mutationPoint1 == mutationPointToPut) {
				mutationPointToPut = rand.nextInt(ind.getLength());
			}
			System.out.println("iden " + identifier);
			System.out.println("1   " + mutationPoint1);
			System.out.println("   2  " + mutationPointToPut);

			int tmp = ind.getRepresentation().get(identifier)
					.get(mutationPoint1);
			ind.getRepresentation()
					.get(identifier)
					.remove(ind.getRepresentation().get(identifier)
							.get(mutationPoint1));
			ind.getRepresentation().get(identifier)
					.add(mutationPointToPut, tmp);
			

			if (Individual.isValidIndividual(ind, setOfEncodedGroups,
					setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
					setOfAuditories, setOfPeriods)) {
				ind.setFitness(Individual.calculateFitness(ind));
				isValid = true;
			} else {
				isValid = false;
			}
		}
		return ind;
	}

}
