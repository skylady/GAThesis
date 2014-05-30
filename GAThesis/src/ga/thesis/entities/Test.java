package ga.thesis.entities;

import ga.thesis.crossover.PMX;
import ga.thesis.selection.TourtamentSelection;
import ga.thesis.testdata.AuditoriesTestData;
import ga.thesis.testdata.GroupTestData;
import ga.thesis.testdata.Pair;
import ga.thesis.testdata.PeriodTestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Test {
	public static final int STARTPOINT = 10;
	final static int N = 1;
	final static int POP_SIZE = 1000; // population size
	final static int MAX_ITER = 100; // max number of iterations
	final static double MUTATION_RATE = 1; // probability of ga.thesis.mutation
	final static double CROSSOVER_RATE = 0.9; // probability of crossover

	final public static int ELITE = 0;

	private static Random m_rand = new Random(); // random-number generator
	private Individual[] m_population;
	private double totalFitness;
	private List<Individual> all;

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

		ArrayList<Individual> resCrossOver = PMX
				.doPMX(ind1, ind2, 1.0, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods);

		System.out.println(resCrossOver.get(0));
		System.out.println(resCrossOver.get(1));
		// System.out.println("After: ");
		// Individual ind2 = InsertionMutation
		// .insertionMutation(ind1, MUTATION_RATE, setOfEncodedGroups,
		// setOfEncodedAuditories, setOfEncodedPeriods,
		// setOfGroups, setOfAuditories, setOfPeriods);
		// System.out.println(ind2.getRepresentation());
		// System.out.println(ind2.getFitness());

	//	 Algorithm
		 System.out.println("Start...");
		 Individual[] population = new Individual[POP_SIZE];
		 // Initialization
		 for (int i = 0; i < POP_SIZE; i++) {
		 Individual ind = Individual.generateValidIndividual(
		 setOfEncodedGroups, setOfEncodedAuditories,
		 setOfEncodedPeriods, setOfGroups, setOfAuditories,
		 setOfPeriods);
		 population[i] = ind;
		 // System.out.println(i + "  " + population[i].getRepresentation());
		 // System.out.println(population[i].getFitness());
		 }

		// System.out.println(population[i]);

		 Individual[] newPop = new Individual[POP_SIZE];
		 Individual[] indiv = new Individual[2];
		 int count;
		
		 for (int iter = 0; iter < MAX_ITER; iter++) {
		 count = 0;
		 System.out.println("iter________________" + iter);
		 Random random = new Random(System.currentTimeMillis());
		 Individual[] selected = TourtamentSelection.tourtamentSelection(
		 population, 5);
		 // Arrays.sort(selected, Collections.reverseOrder());
		
		 // for (int i = 0; i < selected.length; i++) {
		 // System.out.println(selected[i].getRepresentation());
		 // }
		
		 // build new Population
		
		 while (count < POP_SIZE) {
		 // Selection
		 indiv[0] = selected[count];
		 indiv[1] = selected[count + 1];
		
		 ArrayList<Individual> resCrossOver1 = PMX.doPMX(indiv[0],
		 indiv[1], CROSSOVER_RATE, setOfEncodedGroups,
		 setOfEncodedAuditories, setOfEncodedPeriods,
		 setOfGroups, setOfAuditories, setOfPeriods);
		
		 // Individual resMutation1 = ExchangeMutation.insertionMutation(
		 // resCrossOver.get(0), MUTATION_RATE);
		 // Individual resMutation2 = ExchangeMutation.insertionMutation(
		 // resCrossOver.get(1), MUTATION_RATE);
		
		 newPop[count] = resCrossOver1.get(0);
		 // resMutation1;
		 newPop[count + 1] = resCrossOver1.get(1);
		 // resMutation2;
		 count += 2;
		
		 }
		
		 population = newPop;
		
		 // System.out.println(population[0].getFitness());
		 System.out.println("__________________");
		 for (int g = 0; g < population.length; g++) {
		 // System.out
		 // .println(g + "  " + population[g].getRepresentation());
		 // System.out.println(population[g].getFitness());
		 }
		 System.out.println("Avarage: " + Test.calculateAvarege(population));
		
		 }
		
		 System.out.println("End...");
		 Arrays.sort(population);
		
		 System.out.print(population[99].getFitness());
		 System.out.print(Individual.decode(population[99],
		 setOfEncodedGroups,
		 setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
		 setOfAuditories, setOfPeriods));
	}

	public static double calculateAvarege(Individual[] list) {
		double res = 0.0;
		for (int i = 0; i < list.length; i++) {
			res = list[i].getFitness() + list[i + 1].getFitness();
			i++;

		}
		return res = res / list.length;

	}

}
