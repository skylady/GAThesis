package ga.thesis.selection;

import ga.thesis.entities.Individual;
import ga.thesis.selection.ISelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouleteSelection implements ISelection {
	@Override
	public List<Individual> performSelection(Individual[] population,
			int popSize, Random rng) {

		// Calculate the sum of all fitness values.
		double aggregateFitness = 0;
		for (Individual candidate : population) {
			aggregateFitness += candidate.getFitness();
		}

		List<Individual> selection = new ArrayList<Individual>(popSize);
		// Pick a random offset between 0 and 1 as the starting point for
		// selection.
		double startOffset = rng.nextDouble();
		double cumulativeExpectation = 0;
		int index = 0;
		for (Individual candidate : population) {
			// Calculate the number of times this candidate is expected to
			// be selected on average and add it to the cumulative total
			// of expected frequencies.
			cumulativeExpectation += candidate.getFitness() / aggregateFitness
					* popSize;

			// If f is the expected frequency, the candidate will be selected at
			// least as often as floor(f) and at most as often as ceil(f). The
			// actual count depends on the random starting offset.
			while (cumulativeExpectation > startOffset + index) {
				selection.add(candidate);
				index++;
			}
		}
		assert (selection.size() == popSize);
		return selection;
	}
}
