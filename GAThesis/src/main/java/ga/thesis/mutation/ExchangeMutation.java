package ga.thesis.mutation;

import ga.thesis.entities.Auditory;
import ga.thesis.entities.Group;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Period;

import java.util.HashMap;
import java.util.Random;

public class ExchangeMutation {
    private static Random rand = new Random(System.currentTimeMillis());

	public static Individual exchangeMutation(Individual ind,
			double probability, HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		boolean isValid = false;
		if (rand.nextDouble() > probability) {


//            if (rand.nextDouble() < 0.1) {
//                for (int i = 0; i < 120; i++ ) {
//                    ind.getRepresentation().get(2).set(i, rand.nextInt(29) + 10);
//                }
//            }



            return ind;
		} else {
			while (!isValid) {
//				int identifier = rand.nextInt(3);

				int mutationPoint1 = rand.nextInt(ind.getLength());

				int mutationPoint2 = rand.nextInt(ind.getLength());
				while (mutationPoint1 == mutationPoint2) {
					mutationPoint2 = rand.nextInt(ind.getLength());
				}

                for (int identifier = 0; identifier < 3; identifier++) {

                    int tmp = ind.getRepresentation().get(identifier)
                            .get(mutationPoint1);

                    ind.getRepresentation()
                            .get(identifier)
                            .set(mutationPoint1,
                                    ind.getRepresentation().get(identifier)
                                            .get(mutationPoint2));
                    ind.getRepresentation().get(identifier)
                            .set(mutationPoint2, tmp);
                }

				if (Individual.isValidIndividual(ind, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods)) {
					ind.setFitness(Individual.calculateFitness(ind));
					isValid = true;
				} else {
					isValid = false;
				}
			}
			return ind;
		}
	}
}
