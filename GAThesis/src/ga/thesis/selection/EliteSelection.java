package ga.thesis.selection;

import ga.thesis.entities.Individual;
import ga.thesis.selection.ISelection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EliteSelection implements ISelection {
	@Override
	public List<Individual> performSelection(Individual[] population,
			int popSize, Random rng) {
		List<Individual> l = Arrays.asList(population);
		// Collections.sort(l);
		// Collections.reverse(l);
		int size = popSize > population.length ? population.length : popSize;
		return l.subList(0, size);
	}
}