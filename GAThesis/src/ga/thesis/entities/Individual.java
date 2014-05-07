package ga.thesis.entities;

import ga.thesis.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Individual {

	private List<Chromosome> chromosomes;
	private ArrayList<ArrayList<Integer>> representation;
	private int length;
	private double fitness;

	public Individual(List<Chromosome> chromosomes,
			ArrayList<ArrayList<Integer>> representation, int length,
			double fitness) {
		this.chromosomes = chromosomes;
		this.representation = representation;
		this.length = length;
		this.fitness = fitness;
	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public ArrayList<ArrayList<Integer>> getRepresentation() {
		return representation;
	}

	public void setRepresentation(ArrayList<ArrayList<Integer>> representation) {
		this.representation = representation;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public static ArrayList<Integer> generateRandomGroupsList(
			HashMap<Integer, Group> setOfGroups,
			HashMap<Group, Integer> setOfEncodedGroups) {
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfGroups.size(); i++) {
			resArr.add(setOfEncodedGroups.get(setOfGroups.get(i)));
		}
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static ArrayList<Integer> generateRandomAuditoriesList(
			int groupSize, HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Auditory, Integer> setOfEncodedAuditories) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfAuditories.size(); i++) {
			arr.add(setOfEncodedAuditories.get(setOfAuditories.get(i)));
		}

		for (int i = 0; i < groupSize; i++) {
			// or maybe use shuffle !
			resArr.add(arr.get(r.nextInt(arr.size())));
		}
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static ArrayList<Integer> generateRandomPeriodsList(int groupSize,
			HashMap<Integer, Period> setOfPeriods,
			HashMap<Period, Integer> setOfEncodedPeriods) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfPeriods.size(); i++) {
			arr.add(setOfEncodedPeriods.get(setOfPeriods.get(i)));
		}

		for (int i = 0; i < groupSize; i++) {
			resArr.add(arr.get(r.nextInt(arr.size())));
		}
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static Individual generateIndividual(
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		ArrayList<ArrayList<Integer>> resIndividual = new ArrayList<ArrayList<Integer>>();
		resIndividual.add(generateRandomGroupsList(setOfGroups,
				setOfEncodedGroups));
		resIndividual.add(generateRandomAuditoriesList(setOfGroups.size(),
				setOfAuditories, setOfEncodedAuditories));
		resIndividual.add(generateRandomPeriodsList(setOfGroups.size(),
				setOfPeriods, setOfEncodedPeriods));
		List<Chromosome> chrList = new ArrayList<Chromosome>();

		for (int i = 0; i < setOfGroups.size(); i++) {
			chrList.add(new Chromosome(Utils.getKeyByValue(setOfEncodedGroups,
					resIndividual.get(0).get(i)), Utils.getKeyByValue(
					setOfEncodedAuditories, resIndividual.get(1).get(i)), Utils
					.getKeyByValue(setOfEncodedPeriods, resIndividual.get(2)
							.get(i))));
		}

		return new Individual(chrList, resIndividual, resIndividual.size(), 0.0);
	}

	public static Individual generateValidIndividual(
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		Individual resIndividual = generateIndividual(setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods);
		if (!isValidIndividual(resIndividual, setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods)) {
			resIndividual = generateIndividual(setOfEncodedGroups,
					setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
					setOfAuditories, setOfPeriods);
		}
		// double fitness=0.0;
		resIndividual
				.setFitness(calculateFitness(resIndividual, setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods));
		return resIndividual;

	}

	public static <T> boolean isValidList(List<T> list) {
		Set<T> set = new HashSet<T>(list.size());
		for (T item : list) {
			if (!set.add(item)) {
				return false;
			}
		}
		return true;
	}

	// 1: Each lecturer has only one period at the same time (periodNumber,
	// dayOfTheWeek)
	public static boolean lecturerHasOnePeriodSimultaneously(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		HashMap<String, ArrayList<Period>> lecturerPeriods = new HashMap<String, ArrayList<Period>>();
		ArrayList<Period> periodsList = new ArrayList<Period>();
		Set<String> lecturerSet = new HashSet<String>();
		ArrayList<String> lecturerList = new ArrayList<String>();
		Set<String> subjectsSet = new HashSet<String>();
		ArrayList<String> subjectList = new ArrayList<String>();

		// generate periods for each lecturer
		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getGroup().getGroupCode()
						.getLecturer().equals(lecturer)) {
					periodsList.add(ind.getChromosomes().get(j).getPeriod());
				}
			}
			lecturerPeriods.put(lecturer, periodsList);
		}

		// !!!! lecturer list

		for (int j = 0; j < ind.getLength(); j++) {
			String lecturer = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getLecturer();
			if (!lecturerSet.add(lecturer)) {
				lecturerList.add(lecturer);
			}
		}

		// verify lists
		for (int i = 0; i < lecturerPeriods.size(); i++) {
			String lecturer = lecturerList.get(i);
			if (!isValidList(lecturerPeriods.get(lecturer)))
				return false;
		}
		return true;
	}

	public static boolean groupNumberChecker(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		ArrayList<Group> periodGroupsList = new ArrayList<Group>();
		ArrayList<Period> periodList = new ArrayList<Period>();
		HashMap<Period, ArrayList<Group>> periodGroups = new HashMap<Period, ArrayList<Group>>();
		Set<Period> periodsSet = new HashSet<Period>();
		Set<String> subjectsSet = new HashSet<String>();
		ArrayList<String> subjectList = new ArrayList<String>();

		// period -> groups
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			for (int i = 0; i < ind.getLength(); i++) {
				if (ind.getChromosomes().get(i).getPeriod().equals(period)) {
					periodGroupsList
							.add(ind.getChromosomes().get(j).getGroup());
				}
			}
			periodGroups.put(period, periodGroupsList);
		}

		// periods list
		for (int j = 0; j < ind.getLength(); j++) {
			Period period = ind.getChromosomes().get(j).getPeriod();
			if (!periodsSet.add(period)) {
				periodList.add(period);
			}
		}

		// group subject list
		for (int j = 0; j < ind.getLength(); j++) {
			String subject = ind.getChromosomes().get(j).getGroup()
					.getGroupCode().getSubject();
			if (!subjectsSet.add(subject)) {
				subjectList.add(subject);
			}
		}

		// verify lists
		for (int i = 0; i < periodGroups.size(); i++) {
			Period period = periodList.get(i);
			if (!isValidList(periodGroups.get(period))) {
				return false;
			} else {
				int sum = 0;
				for (int j = 0; j < periodGroups.get(period).size(); j++) {
					String subject = subjectList.get(j);
					if (periodGroups.get(period).get(j).getGroupNumber() == 0) {
						if (periodGroups.get(period).get(j).getGroupCode()
								.getSubject().equals(subject)) {
							sum = sum + 1;
						}
					}
				}
				if (!(sum == 1)) {
					return false;
				}
			}
		}

		return true;
	}

	// public static boolean groupHasOnePeriodSimultaneously(Individual ind,
	// HashMap<Group, Integer> setOfEncodedGroups,
	// HashMap<Auditory, Integer> setOfEncodedAuditories,
	// HashMap<Period, Integer> setOfEncodedPeriods,
	// HashMap<Integer, Group> setOfGroups,
	// HashMap<Integer, Auditory> setOfAuditories,
	// HashMap<Integer, Period> setOfPeriods) {
	//
	// ArrayList<Period> subjectPeriodsList = new ArrayList<Period>();
	// ArrayList<Group> subjectGroupsList = new ArrayList<Group>();
	// Set<String> subjectsSet = new HashSet<String>();
	// ArrayList<String> subjectList = new ArrayList<String>();
	//
	// HashMap<String, ArrayList<Period>> subjectPeriods = new HashMap<String,
	// ArrayList<Period>>();
	// HashMap<String, ArrayList<Group>> subjectGroups = new HashMap<String,
	// ArrayList<Group>>();
	//
	// // map subject -> periods
	//
	// for (int j = 0; j < ind.getLength(); j++) {
	// String subject = ind.getChromosomes().get(j).getGroup()
	// .getGroupCode().getSubject();
	// for (int i = 0; i < ind.getLength(); i++) {
	// if (ind.getChromosomes().get(i).getGroup().getGroupCode()
	// .getSubject().equals(subject)) {
	// subjectPeriodsList.add(ind.getChromosomes().get(j)
	// .getPeriod());
	// }
	// }
	// subjectPeriods.put(subject, subjectPeriodsList);
	// }
	//
	// // map subject -> group List
	//
	// for (int j = 0; j < ind.getLength(); j++) {
	// String subject = ind.getChromosomes().get(j).getGroup()
	// .getGroupCode().getSubject();
	// for (int i = 0; i < ind.getLength(); i++) {
	// if (ind.getChromosomes().get(i).getGroup().getGroupCode()
	// .getSubject().equals(subject)) {
	// subjectGroupsList.add(ind.getChromosomes().get(j)
	// .getGroup());
	// }
	// }
	// subjectGroups.put(subject, subjectGroupsList);
	// }
	//
	// // group subject list
	// for (int j = 0; j < ind.getLength(); j++) {
	// String subject = ind.getChromosomes().get(j).getGroup()
	// .getGroupCode().getSubject();
	// if (!subjectsSet.add(subject)) {
	// subjectList.add(subject);
	// }
	// }
	//
	// for (int i = 0; i < subjectPeriods.size(); i++) {
	// String tmp = subjectList.get(i);
	//
	// for (int j = 0; j < subjectGroups.get(tmp).size(); j++) {
	// if (subjectGroups.get(tmp).get(j).getGroupNumber() == 0) {
	//
	// }
	// }
	// }
	//
	// // if (subjectPeriods.get(key))
	// // return false;
	//
	// return true;
	// }

	// 4: Size of group < size of auditory
	public static boolean groupSizeLessAuditorySize(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		for (int i = 0; i < ind.getLength(); i++) {
			if (!(ind.getChromosomes().get(i).getGroup().getGroupCode()
					.getGroupSize() <= ind.getChromosomes().get(i)
					.getAuditory().getAuditorySize())) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidIndividual(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		// 1:
		if (!lecturerHasOnePeriodSimultaneously(ind, setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods)) {
			return false;
		}
		// 2

		// 4
		if (!groupSizeLessAuditorySize(ind, setOfEncodedGroups,
				setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
				setOfAuditories, setOfPeriods)) {
			return false;
		}

		return true;
	}

	public static double calculateFitness(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		// to do
		return 0.0;
	}

	public static String encode(HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		String represe = "";
		for (int i = 0; i < 5; i++) {
			String str = Chromosome.generateRandomChromosome(
					setOfEncodedGroups, setOfEncodedAuditories,
					setOfEncodedPeriods, setOfGroups, setOfAuditories,
					setOfPeriods);
			represe = represe.concat(str);
		}
		return represe;
	}
}
