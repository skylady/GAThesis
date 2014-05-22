package ga.thesis.selection;

import ga.thesis.entities.Individual;
import ga.thesis.selection.ISelection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EliteSelection implements ISelection {
	@Override
	public List<Individual> performSelection(List<Individual> population,
			int popSize, Random rng) {
		//List<Individual> l = Arrays.asList(population);
		// Collections.sort(l);
		// Collections.reverse(l);
		int size = popSize > population.size() ? population.size() : popSize;
		return population.subList(0, size);
	}
}