package ga.thesis.entities;

import ga.thesis.restrictions.HardRestrictions;
import ga.thesis.restrictions.SoftRestrictions;
import ga.thesis.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Individual implements Comparable<Individual> {

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
		java.util.Collections.shuffle(resArr);
		java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static ArrayList<Integer> generateRandomAuditoriesList(
			int groupSize, HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			ArrayList<Integer> groups, HashMap<Integer, Group> setOfGroups,
			HashMap<Group, Integer> setOfEncodedGroups) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		for (int i = 0; i < setOfAuditories.size(); i++) {
			arr.add(setOfEncodedAuditories.get(setOfAuditories.get(i)));
		}

		int rand;
		for (int i = 0; i < groupSize; i++) {
			if (Utils.getKeyByValue(setOfEncodedGroups, groups.get(i))
					.getGroupCode().getGroupSize() > 30) {
				rand = (arr.get(r.nextInt(3)));
			} else if (Utils.getKeyByValue(setOfEncodedGroups, groups.get(i))
					.getGroupCode().getGroupSize() > 14) {
				rand = (arr.get(r.nextInt(7)));
				//
				// } else if (Utils.getKeyByValue(setOfEncodedGroups,
				// groups.get(i))
				// .getGroupCode().getGroupSize() > 30) {
				// rand = (arr.get(r.nextInt(3)));
			} else {
				rand = arr.get(r.nextInt((arr.size() - 7)) + 7);
			}
			resArr.add(rand);
		}
		// java.util.Collections.shuffle(resArr);
		return resArr;
	}

	public static ArrayList<Integer> extendedGenerateRandomPeriodsList(
			HashMap<Integer, Period> setOfPeriods,
			HashMap<Period, Integer> setOfEncodedPeriods,
			ArrayList<Integer> groups, HashMap<Integer, Group> setOfGroups,
			HashMap<Group, Integer> setOfEncodedGroups) {
		Random r = new Random(System.currentTimeMillis());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> resArr = new ArrayList<Integer>();
		Set<String> courseSet = new HashSet<String>();
		ArrayList<String> courseList = new ArrayList<String>();
		for (int i = 0; i < setOfPeriods.size(); i++) {
			arr.add(setOfEncodedPeriods.get(setOfPeriods.get(i)));
		}

		for (int i = 0; i < groups.size(); i++) {
			if (resArr.size() == 0) {
				resArr.add(arr.get(r.nextInt(arr.size())));
			} else {
				int period = arr.get(r.nextInt(arr.size()));
				for (int j = 0; j < resArr.size(); j++) {
					if (!resArr.contains(period)) {
						resArr.add(period);
						break;
					} else if (resArr.contains(period)) {
						if (Utils.getKeyByValue(setOfEncodedGroups,
								groups.get(i)).getCourse() == Utils
								.getKeyByValue(setOfEncodedGroups,
										groups.get(j)).getCourse()) {
							if (Utils.getKeyByValue(setOfEncodedGroups,
									groups.get(i)).getGroupNumber() == 0) {
								while (period == resArr.get(j)) {

									period = arr.get(r.nextInt(arr.size()));

								}
								resArr.add(period);
								break;
							} else {
								resArr.add(period);
								break;
							}
						} else {
							resArr.add(period);
							break;
						}
					}
				}

			}
		}

		//System.out.println("Finish ");
		// java.util.Collections.shuffle(resArr);
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
		List<Chromosome> chrList = new ArrayList<Chromosome>();
		resIndividual.add(generateRandomGroupsList(setOfGroups,
				setOfEncodedGroups));
		resIndividual.add(generateRandomAuditoriesList(setOfGroups.size(),
				setOfAuditories, setOfEncodedAuditories, resIndividual.get(0),
				setOfGroups, setOfEncodedGroups));
		// resIndividual.add(generateRandomPeriodsList(setOfGroups.size(),
		// setOfPeriods, setOfEncodedPeriods));
		resIndividual.add(extendedGenerateRandomPeriodsList(setOfPeriods,
				setOfEncodedPeriods, resIndividual.get(0), setOfGroups,
				setOfEncodedGroups));

		for (int i = 0; i < setOfGroups.size(); i++) {
			chrList.add(new Chromosome(Utils.getKeyByValue(setOfEncodedGroups,
					resIndividual.get(0).get(i)), Utils.getKeyByValue(
					setOfEncodedAuditories, resIndividual.get(1).get(i)), Utils
					.getKeyByValue(setOfEncodedPeriods, resIndividual.get(2)
							.get(i))));
		}

		return new Individual(chrList, resIndividual, chrList.size(), 0.0);
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
		boolean flag = true;
		while (flag) {
			if (!isValidIndividual(resIndividual, setOfEncodedGroups,
					setOfEncodedAuditories, setOfEncodedPeriods, setOfGroups,
					setOfAuditories, setOfPeriods)) {
				resIndividual = generateIndividual(setOfEncodedGroups,
						setOfEncodedAuditories, setOfEncodedPeriods,
						setOfGroups, setOfAuditories, setOfPeriods);
			} else {
				flag = false;
			}

		}
		// double fitness=0.0;
		resIndividual.setFitness(calculateFitness(resIndividual));
		return resIndividual;

	}

	public static boolean isValidIndividual(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		 if (!HardRestrictions.lecturerPeriodUnicity(ind)) {
		 System.out.println("1 rest");
		 return false;
		 }
		System.out.println("isValid call_____");
		if (!HardRestrictions.groupNumberChecker(ind)) {
			System.out.println("2 rest");
			return false;
		}

		 if (!HardRestrictions.auditoryUnicity(ind)) {
		 System.out.println("3 rest");
		 return false;
		 }
		 if (!HardRestrictions.groupSizeLessAuditorySize(ind)) {
		 System.out.println("4 rest");
		 return false;
		 }

		return true;
	}

	public static double calculateFitness(Individual ind) {
		double res = 0.0;

		double restValue = SoftRestrictions.lecturePeriod(ind, 0.4)
				+ SoftRestrictions.lessWindowsForTeachers(ind, 0.2, 0.5)
				+ SoftRestrictions.lessWindowsForGroups(ind, 0.05, 0.1);
		SoftRestrictions.costFunnctionForTeachers(ind, 0.6);
		res = res + restValue;

		return res;
	}

	public static String decode(Individual ind,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {

		for (int i = 0; i < ind.getLength(); i++) {
			System.out.println("---" + i + "---");
			System.out.print(ind.getChromosomes().get(i).getGroup().getCourse()+"   teach "+ind.getChromosomes().get(i).getGroup().getGroupCode().getLecturer().getLecturerSurname()+"  "+ind.getChromosomes().get(i).getGroup()
					.getGroupCode().getSubject()
					+ " "
					+ ind.getChromosomes().get(i).getGroup().getGroupNumber()
					+ "___");
			System.out.print(ind.getChromosomes().get(i).getAuditory()
					.getAuditoryNumber()
					+ "___");
			System.out.println(ind.getChromosomes().get(i).getPeriod()
					.getDayOfTheWeek()
					+ " "
					+ ind.getChromosomes().get(i).getPeriod()
							.getNumberOfPeriod() + "___");
		}
		return "done";
		
		
		
	}

	public static Individual buildIndividualByRepresentation(
			ArrayList<ArrayList<Integer>> representation,
			HashMap<Group, Integer> setOfEncodedGroups,
			HashMap<Auditory, Integer> setOfEncodedAuditories,
			HashMap<Period, Integer> setOfEncodedPeriods,
			HashMap<Integer, Group> setOfGroups,
			HashMap<Integer, Auditory> setOfAuditories,
			HashMap<Integer, Period> setOfPeriods) {
		List<Chromosome> chrList = new ArrayList<Chromosome>();
		double fitness = 0.0;

		for (int i = 0; i < setOfGroups.size(); i++) {
			chrList.add(new Chromosome(Utils.getKeyByValue(setOfEncodedGroups,
					representation.get(0).get(i)), Utils.getKeyByValue(
					setOfEncodedAuditories, representation.get(1).get(i)),
					Utils.getKeyByValue(setOfEncodedPeriods, representation
							.get(2).get(i))));
		}
		Individual resIndividual = new Individual(chrList, representation,
				chrList.size(), fitness);
		resIndividual.setFitness(calculateFitness(resIndividual));
		return resIndividual;
	}

	@Override
	public String toString() {
		return "Individual [chromosomes=" + chromosomes + ", representation="
				+ representation + ", length=" + length + ", fitness="
				+ fitness + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chromosomes == null) ? 0 : chromosomes.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fitness);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + length;
		result = prime * result
				+ ((representation == null) ? 0 : representation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individual other = (Individual) obj;
		if (chromosomes == null) {
			if (other.chromosomes != null)
				return false;
		} else if (!chromosomes.equals(other.chromosomes))
			return false;
		if (Double.doubleToLongBits(fitness) != Double
				.doubleToLongBits(other.fitness))
			return false;
		if (length != other.length)
			return false;
		if (representation == null) {
			if (other.representation != null)
				return false;
		} else if (!representation.equals(other.representation))
			return false;
		return true;
	}

	@Override
	public int compareTo(Individual ind) {
		return Double.compare(fitness, ind.fitness);
	}
}
