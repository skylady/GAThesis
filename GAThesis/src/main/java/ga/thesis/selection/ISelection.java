package ga.thesis.selection;

import ga.thesis.entities.Individual;

import java.util.List;
import java.util.Random;

public interface ISelection {
	List<Individual> performSelection(List<Individual> population, int popSize,
			Random rng);
}
