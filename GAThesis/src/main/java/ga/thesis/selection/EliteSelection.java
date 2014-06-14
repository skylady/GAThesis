package ga.thesis.selection;

import ga.thesis.entities.Individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EliteSelection implements ISelection {
	@Override
	public List<Individual> performSelection(List<Individual> population,
			int popSize, Random rng) {

        List<Individual> tmp = new ArrayList<Individual>();
        tmp.addAll(population);
        Collections.sort(tmp);
//        Collections.reverse(tmp);

		int size = popSize > tmp.size() ? tmp.size() : popSize;
		return tmp.subList(0, size);
	}
}