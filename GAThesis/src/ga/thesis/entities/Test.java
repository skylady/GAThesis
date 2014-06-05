package ga.thesis.entities;

import ga.thesis.crossover.PMX;
import ga.thesis.mutation.ExchangeMutation;
import ga.thesis.mutation.InsertionMutation;
import ga.thesis.selection.RouleteSelection;
import ga.thesis.selection.TourtamentSelection;
import ga.thesis.testdata.AuditoriesTestData;
import ga.thesis.testdata.GroupTestData;
import ga.thesis.testdata.Pair;
import ga.thesis.testdata.PeriodTestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Test {
	public static final int STARTPOINT = 10;
	final static int N = 1;
	final static int POP_SIZE = 1500; // population size
	final static int MAX_ITER = 100; // max number of iterations
	final static double MUTATION_RATE = 0.05; // probability of
												// ga.thesis.mutation
	final static double CROSSOVER_RATE = 1.0; // probability of crossover

	final public static int ELITE = 10;

	private static Random m_rand = new Random(); // random-number generator
	private Individual[] m_population;
	private double totalFitness;
	private List<Individual> all;
	private static final Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {

		Pair<HashMap<Integer, Group>, HashMap<Group, Integer>> groups = GroupTestData
				.createGroups();
		Pair<HashMap<Integer, Period>, HashMap<Period, Integer>> periods = PeriodTestData
				.createPeriods();
		Pair<HashMap<Integer, Auditory>, HashMap<Auditory, Integer>> auditories = AuditoriesTestData
				.createAuditories();
		HashMap<Integer, Group> setOfGroups = groups.getVal1();
		HashMap<Group, Integer> setOfEncodedGroups = groups.getVal2();

		HashMap<Integer, Auditory> setOfAuditories = auditories.getVal1();
		HashMap<Auditory, Integer> setOfEncodedAuditories = auditories
				.getVal2();
		HashMap<Integer, Period> setOfPeriods = periods.getVal1();
		HashMap<Period, Integer> setOfEncodedPeriods = periods.getVal2();

		System.out.println("Start: ");
		Individual ind1 = Individual.generateValidIndividual(groups.getVal2(),
				auditories.getVal2(), periods.getVal2(), groups.getVal1(),
				auditories.getVal1(), periods.getVal1());
		Individual ind2 = Individual.generateValidIndividual(groups.getVal2(),
				auditories.getVal2(), periods.getVal2(), groups.getVal1(),
				auditories.getVal1(), periods.getVal1());
		System.out.println(ind1.getRepresentation());
		System.out.println(ind1.getFitness());

		ArrayList<Individual> resCrossOver = PMX
				.doPMX(ind1, ind2, 1.0, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods);

		System.out.println("After:" + resCrossOver.get(0));
		System.out.println(resCrossOver.get(1));

		// Algorithm
		System.out.println("Start...");
		List<Individual> population = new ArrayList<Individual>();
		// Initialization
		for (int i = 0; i < POP_SIZE; i++) {
			Individual ind = Individual.generateValidIndividual(
					setOfEncodedGroups, setOfEncodedAuditories,
					setOfEncodedPeriods, setOfGroups, setOfAuditories,
					setOfPeriods);
			population.add(ind);
		}

		// List<Individual> newPop = new ArrayList<Individual>();
		Individual[] indiv = new Individual[2];
		int count;

		for (int iter = 0; iter < MAX_ITER; iter++) {
			count = 0;
			System.out.println("iter________________" + iter);

			List<Individual> elite = new ga.thesis.selection.EliteSelection()
					.performSelection(population, ELITE, random);

			List<Individual> selected = TourtamentSelection
					.tourtamentSelection(population, 5, population.size()
							- ELITE);
			// List<Individual> selected = new RouleteSelection()
			// .performSelection(population, population.size() - ELITE,
			// random);
			selected.addAll(elite);
			// Collections.sort(selected);
			List<Individual> newPop = new ArrayList<Individual>();

			while (count < POP_SIZE) {
				// Selection
				indiv[0] = selected.get(count);
				indiv[1] = selected.get(count + 1);

				ArrayList<Individual> resCrossOver1 = PMX.doPMX(indiv[0],
						indiv[1], CROSSOVER_RATE, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods);

				Individual resMutation1 = InsertionMutation.insertionMutation(
						resCrossOver1.get(0), MUTATION_RATE,
						setOfEncodedGroups, setOfEncodedAuditories,
						setOfEncodedPeriods, setOfGroups, setOfAuditories,
						setOfPeriods);
				Individual resMutation2 = InsertionMutation.insertionMutation(
						resCrossOver1.get(1), MUTATION_RATE,
						setOfEncodedGroups, setOfEncodedAuditories,
						setOfEncodedPeriods, setOfGroups, setOfAuditories,
						setOfPeriods);

				newPop.add(resMutation1);
				// resCrossOver1.get(0);
				// resMutation1;
				newPop.add(resMutation2);
				// resCrossOver1.get(1);
				// resMutation2;
				count += 2;

			}

			population = newPop;

			// System.out.println(population[0].getFitness());
			System.out.println("__________________");
			for (int g = 0; g < population.size(); g++) {
				System.out.println(g + "  "
						+ population.get(g).getRepresentation());
				System.out.println(population.get(g).getFitness());
			}

			System.out.println("Avarage: " + Test.calculateAvarege(population));

		}

		System.out.println("End...");
		Collections.sort(population);

		System.out.print(population.get(0).getFitness());
		System.out
				.print(Individual.decode(population.get(0), setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods));
	}

	public static double calculateAvarege(
			List<ga.thesis.entities.Individual> population) {
		double res = 0.0;
		for (int i = 0; i < population.size(); i++) {
			res = population.get(i).getFitness()
					+ population.get(i + 1).getFitness();
			i++;
			// i++;

		}
		return res = res / population.size();

	}

	public static double calculateAvarege(Individual[] resCrossOver) {
		double res = 0.0;
		for (int i = 0; i < resCrossOver.length; i++) {
			res = resCrossOver[i].getFitness()
					+ resCrossOver[i + 1].getFitness();
			i++;
			// i++;

		}
		return res = res / resCrossOver.length;

	}

}
