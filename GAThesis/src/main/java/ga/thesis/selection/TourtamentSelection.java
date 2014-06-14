package ga.thesis.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ga.thesis.entities.Individual;

public class TourtamentSelection {

	public static Individual selectIndividual(List<Individual> population,
			int tournamentSize) {

		Individual[] tournament = new Individual[tournamentSize];
		double[] tournamentFitness = new double[tournamentSize];
		for (int i = 0; i < tournamentSize; i++) {
			Random rand = new Random();
			int index = (int) (rand.nextInt(population.size()));
			tournament[i] = population.get(index);
			tournamentFitness[i] = population.get(index).getFitness();
		}

		Individual bestIndividual = tournament[0];
		double bestFitness = tournamentFitness[0];
		for (int i = 1; i < tournamentSize; i++)
			if (tournamentFitness[i] < bestFitness) {
				bestIndividual = tournament[i];
				bestFitness = tournamentFitness[i];
			}

		return bestIndividual;
	}

	public static List<Individual> tourtamentSelection(
			List<Individual> population, int tournamentSize, int length) {
		List<Individual> res = new ArrayList<Individual>();
		for (int i = 0; i < length; i++) {

			res.add(selectIndividual(population, tournamentSize));
		}

		return res;
	}

}
