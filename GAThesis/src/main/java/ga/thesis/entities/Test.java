package ga.thesis.entities;

import ga.thesis.crossover.PMX;
import ga.thesis.mutation.ExchangeMutation;
import ga.thesis.restrictions.HardRestrictions;
import ga.thesis.restrictions.SoftRestrictions;
import ga.thesis.selection.TourtamentSelection;
import ga.thesis.testdata.AuditoriesTestData;
import ga.thesis.testdata.GroupTestData;
import ga.thesis.testdata.Pair;
import ga.thesis.testdata.PeriodTestData;
import ga.thesis.gui.GUIForm;
import ga.thesis.testdata.TestData;
import ga.thesis.textwriter.TableExample;

import java.util.*;

public class Test {

    public static final int STARTPOINT = 10;
    final static int N = 1;
    final static int POP_SIZE = 1300; // population size
    final static int MAX_ITER = 250; // max number of iterations
    final static double MUTATION_RATE = 0.1; // probability of mutation
    final static double CROSSOVER_RATE = 1.0; // probability of crossover
    final public static int ELITE = 1;
    private static Random m_rand = new Random(); // random-number generator
    private Individual[] m_population;
    private double totalFitness;
    private List<Individual> all;
    private static final Random random = new Random(System.currentTimeMillis());

    private GUIForm form;

    public Test(GUIForm form) {
        this.form = form;
    }

    public void main() {
        main(new String[0]);
        form.notifyDone(Individual.decodeIntoGui(best, groups.getVal2(),
                auditories.getVal2(),
                periods.getVal2(),
                groups.getVal1(),
                auditories.getVal1(),
                periods.getVal1()));
//         ArrayList<String> list = new ArrayList<String>();
//        list.add("МП ІУСТ1");
//        list.add("МП ІУСТ2");
        
//         form.notifyDone( TestData.testDisplay());
       
        
//        TableExample.initPdf(list,Individual.decodeIntoGui(best, groups.getVal2(),
//                auditories.getVal2(),
//                periods.getVal2(),
//                groups.getVal1(),
//                auditories.getVal1(),
//                periods.getVal1()));
//                
        
    }

    static Pair<HashMap<Integer, Group>, HashMap<Group, Integer>> groups;
    static Pair<HashMap<Integer, Period>, HashMap<Period, Integer>> periods;
    static Pair<HashMap<Integer, Auditory>, HashMap<Auditory, Integer>> auditories;
    static HashMap<Integer, Group> setOfGroups;
    static HashMap<Group, Integer> setOfEncodedGroups;
    static Individual best;

    public static void main(String[] args) {

        groups = GroupTestData.createGroups();
        periods = PeriodTestData
                .createPeriods();
        auditories = AuditoriesTestData
                .createAuditories();
        setOfGroups = groups.getVal1();
        setOfEncodedGroups = groups.getVal2();

        HashMap<Integer, Auditory> setOfAuditories = auditories.getVal1();
        HashMap<Auditory, Integer> setOfEncodedAuditories = auditories
                .getVal2();
        HashMap<Integer, Period> setOfPeriods = periods.getVal1();
        HashMap<Period, Integer> setOfEncodedPeriods = periods.getVal2();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //	arr.addAll(Arrays.asList(setOfEncodedGroups.get(setOfGroups.get(100))));
        //	Individual validIndividual1 =  Individual.buildIndividualByRepresentation(representation, setOfEncodedGroups, setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups, setOfAuditories, setOfPeriods);

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

                Individual resMutation1 = ExchangeMutation.exchangeMutation(resCrossOver1.get(0), MUTATION_RATE,
                        setOfEncodedGroups, setOfEncodedAuditories,
                        setOfEncodedPeriods, setOfGroups, setOfAuditories,
                        setOfPeriods);
                Individual resMutation2 = ExchangeMutation.exchangeMutation(
                        resCrossOver1.get(1), MUTATION_RATE,
                        setOfEncodedGroups, setOfEncodedAuditories,
                        setOfEncodedPeriods, setOfGroups, setOfAuditories,
                        setOfPeriods);

                newPop.add(resMutation1);
                newPop.add(resMutation2);

                count += 2;

            }

            population = newPop;
            System.out.println("__________________");


            System.out.println("Avarage: " + Test.calculateAvarege(population));
            System.out.println("Min: " + Test.calculateMin(population));

        }

        System.out.println("End...");
        Collections.sort(population);

        System.out.print(population.get(0).getFitness());
        System.out.println("Hard Rest auditory unicity" + HardRestrictions.calcGroupSizeLessAuditorySize(population.get(0), 1.0));
        System.out.println("Hard Rest lect period unicity" + HardRestrictions.calclecturerPeriodUnicity(population.get(0), 1.0));

        System.out.println("Hard Rest  group number checker" + HardRestrictions.calcGroupNumberChecker(population.get(0), 1.0));
        System.out.println("Hard Rest GROUP SIZE LESS" + HardRestrictions.calcGroupSizeLessAuditorySize(population.get(0), 1.0));

        Individual ind = population.get(0);
        System.out.println("Soft Rest auditory order" + SoftRestrictions.auditoryOrder(population.get(0), 0.05, 0.1));
        System.out.println("Soft Rest auditory lect order" + SoftRestrictions.lectPractOrder(ind, 0.1, 0.2));
        System.out.println("Soft Rest lect period" + SoftRestrictions.lecturePeriod(ind, 0.1));
        System.out.println("Soft Rest less windows for teachers" + SoftRestrictions.lessWindowsForTeachers(ind, 0.05, 0.1));
        System.out.println("Soft Rest less windows for groups" + SoftRestrictions.lessWindowsForGroups(ind, 0.001, 0.01));
        System.out.println("Soft Rest cost function for teachers" + SoftRestrictions.costFunnctionForTeachers(ind, 0.1));
        System.out
                .print(Individual.decode(population.get(0), setOfEncodedGroups,
                                setOfEncodedAuditories, setOfEncodedPeriods,
                                setOfGroups, setOfAuditories, setOfPeriods));

        best = population.get(0);
    }

    public static double calculateMin(
            List<ga.thesis.entities.Individual> population) {
        double res = Double.MAX_VALUE;
        for (int i = 0; i < population.size(); i++) {
            Double res1 = population.get(i).getFitness();
            {
                if (res1 < res) {
                    res = res1;
                }
            }
        }
        return res;
    }

    public static double calculateAvarege(
            List<ga.thesis.entities.Individual> population) {
        double res = 0.0;
        for (int i = 0; i < population.size(); i++) {
            res += population.get(i).getFitness();
        }
        return res = res / population.size();

    }

    public static double calculateAvarege(Individual[] resCrossOver) {
        double res = 0.0;
        for (int i = 0; i < resCrossOver.length; i++) {
            res = resCrossOver[i].getFitness()
                    + resCrossOver[i + 1].getFitness();
            i++;
        }
        return res = res / resCrossOver.length;

    }
}
