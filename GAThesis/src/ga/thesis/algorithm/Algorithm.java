package ga.thesis.algorithm;


import ga.thesis.entities.Individual;

import java.util.List;
import java.util.Random;

public class Algorithm {
//	final static int N = 1;
//	final static int POP_SIZE = 100; // population size
//	final static int MAX_ITER = 500; // max number of iterations
//	final static double MUTATION_RATE = 0.05; // probability of ga.thesis.mutation
//	final static double CROSSOVER_RATE = 1; // probability of crossover
//
//	final public static int ELITE = 0;
//
//	private static Random m_rand = new Random(); // random-number generator
//	private Individual[] m_population;
//	private double totalFitness;
//	private List<Individual> all;
//
//	public static void main(String[] args) {
//		Algorithm pop = new Algorithm();
//		Individual[] newPop = new Individual[POP_SIZE];
//		Individual[] indiv = new Individual[2];
//		System.out.println("start...");
//		print(pop, 0);
//		// main loop
//		int count;
//		for (int iter = 1; iter <= MAX_ITER; iter++) {
//			count = 0;
//			pop.reEvaluate();
//
//			Random random = new Random(System.currentTimeMillis());
//			List<Individual> selected = new RouleteSelection()
//					.performSelection(pop.getPopulation(),
//							pop.getPopulation().length - ELITE, random);
//			List<Individual> elite = new EliteSelection().performSelection(
//					pop.getPopulation(), ELITE, random);
//			selected.addAll(elite);
//
//			sort(selected, pop.getPopulation());
//			// build new Population
//			while (count < POP_SIZE) {
//				// Selection
//				indiv[0] = selected.get(count);
//				indiv[1] = selected.get(count + 1);
//
//				// Crossover
//				if (m_rand.nextDouble() < CROSSOVER_RATE) {
//					indiv = new CrossoverOperator(indiv[0], indiv[1]).perform();
//				}
//
//				// Mutation
//				if (m_rand.nextDouble() < MUTATION_RATE) {
//					indiv[0] = new Mutation(indiv[0]).perform();
//				}
//				if (m_rand.nextDouble() < MUTATION_RATE) {
//					indiv[0] = new Mutation(indiv[0]).perform();
//				}
//
//				// add to new population
//				newPop[count] = indiv[0];
//				newPop[count + 1] = indiv[1];
//				count += 2;
//			}
//			pop.setPopulation(newPop);
//
//			// reevaluate current population
//			pop.evaluate();
//			// System.out.println(iter + ":Average Fitness = " +
//			// pop.totalFitness / pop.getPopulation().length);
//			// System.out.println("Best = " + printList(pop.best));
//			if (iter % 50 == 0) {
//				print(pop, iter);
//			}
//		}
//		System.out.println(numberOfcalls);
//		System.out.println("End...");
//	}
//
//}
}

