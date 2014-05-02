package ga.entities;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		Auditory aud1 = new Auditory(0, "223");
		Auditory aud2 = new Auditory(0, "223");
		Auditory aud3 = new Auditory(0, "223");
		Auditory aud4 = new Auditory(0, "223");
		Auditory aud5 = new Auditory(0, "223");
		Auditory aud6 = new Auditory(0, "223");
		Auditory aud7 = new Auditory(0, "223");
		Auditory aud8 = new Auditory(0, "223");
		Auditory aud9 = new Auditory(0, "345");
		Auditory aud10 = new Auditory(0, "223");
		Auditory aud11 = new Auditory(0, "223");
		Auditory aud12 = new Auditory(0, "223");
		Auditory[] araud = { aud1, aud2, aud3, aud4, aud5, aud6, aud7, aud8,
				aud9, aud10, aud11, aud12 };

		HashMap<Integer, Auditory> aud = new HashMap<Integer, Auditory>();
		{
			for (int i = 0; i < 11; i++) {
				aud.put(i, araud[i]);
			}
		}
		{
			HashMap<Auditory, Integer> codeaud = Auditory
					.setOfEncodedAuditories(aud, 10);
			System.out.println(codeaud.get(aud7));
			System.out.println(aud.get(8).getAuditoryNumber());
		}

		Pair timeslot1 = new Pair(0, 1, "Monday", 1);
		GroupCode groupCode1 = new GroupCode(0, 3, "lecture", "Gul", 0);
		Group group1 = new Group(0, groupCode1, 1);
		Chromosome gene1 = new Chromosome(group1, aud1, timeslot1);

	}

	public int calculateAuditoryStartPoint() {
		return 1;
	}
}
