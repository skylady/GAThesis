package ga.thesis.testdata;

import ga.thesis.entities.Auditory;

import java.util.HashMap;

public class AuditoriesTestData {
	public static final int STARTPOINT = 10;

	public static Pair<HashMap<Integer, Auditory>, HashMap<Auditory, Integer>> createAuditories() {

		Auditory aud1 = new Auditory(3, "223", 100);
		Auditory aud2 = new Auditory(9, "313", 100);
		Auditory aud3 = new Auditory(10, "225", 80);
		Auditory aud4 = new Auditory(11, "3-310", 80);
		Auditory aud5 = new Auditory(8, "310", 30);
		Auditory aud6 = new Auditory(12, "3-220a", 30);
		Auditory aud7 = new Auditory(16, "1-112", 30);
		Auditory aud8 = new Auditory(15, "1-108", 22);
		Auditory aud9 = new Auditory(1, "208", 14);
		Auditory aud10 = new Auditory(2, "206", 14);
		Auditory aud11 = new Auditory(14, "2-214", 14);
		Auditory aud12 = new Auditory(4, "309", 14);
		Auditory aud13 = new Auditory(5, "306", 14);
		Auditory aud14 = new Auditory(6, "307", 14);
		Auditory aud15 = new Auditory(7, "331", 14);
		Auditory aud16 = new Auditory(13, "2-204", 14);
		Auditory aud17 = new Auditory(15, "1-110", 14);

		Auditory[] araud = { aud1, aud2, aud3, aud4, aud5, aud6, aud7, aud8,
				aud9, aud10, aud11, aud12, aud13, aud14, aud15, aud16, aud17 };

		HashMap<Integer, Auditory> setOfAuditories = new HashMap<Integer, Auditory>();

		for (int i = 0; i < 16; i++) {
			setOfAuditories.put(i, araud[i]);
		}

		HashMap<Auditory, Integer> setOfEncodedAuditories = Auditory
				.setOfEncodedAuditories(setOfAuditories, STARTPOINT);
		return new Pair<HashMap<Integer, Auditory>, HashMap<Auditory, Integer>>(
				setOfAuditories, setOfEncodedAuditories);
	}
}
