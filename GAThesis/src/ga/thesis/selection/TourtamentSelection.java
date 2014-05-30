package ga.thesis.selection;

import java.util.Random;

import ga.thesis.entities.Individual;

public class TourtamentSelection {

	public static Individual selectIndividual(Individual[] population,
			int tournamentSize) {

		Individual[] tournament = new Individual[tournamentSize];
		double[] tournamentFitness = new double[tournamentSize];
		for (int i = 0; i < tournamentSize; i++) {
			Random rand = new Random();
			int index = (int) (rand.nextInt(population.length));
			tournament[i] = population[index];
			tournamentFitness[i] = population[index].getFitness();
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

	public static Individual[] tourtamentSelection(Individual[] population,
			int tournamentSize) {
		Individual[] res = new Individual[population.length];
		for (int i = 0; i < population.length; i++) {
			res[i] = selectIndividual(population, tournamentSize);
		}

		return res;
	}

}
