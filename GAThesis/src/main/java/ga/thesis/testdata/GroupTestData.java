package ga.thesis.testdata;

import ga.thesis.entities.Group;
import ga.thesis.entities.GroupCode;
import ga.thesis.entities.Individual;
import ga.thesis.entities.Lecturer;
import ga.thesis.entities.Period;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupTestData {
	public static final int STARTPOINT = 100;
	
	
	public static Pair<HashMap<Integer, Group>, HashMap<Group, Integer>> createGroups() {

		Period period1 = new Period(1, 1, "Monday");
		Period period2 = new Period(2, 2, "Monday");
		Period period3 = new Period(3, 3, "Monday");
		Period period4 = new Period(4, 4, "Monday");
		Period period5 = new Period(5, 5, "Monday");
		Period period6 = new Period(6, 6, "Monday");
		Period period7 = new Period(7, 1, "Tuesday");
		Period period8 = new Period(8, 2, "Tuesday");
		Period period9 = new Period(9, 3, "Tuesday");
		Period period10 = new Period(10, 4, "Tuesday");
		Period period11 = new Period(11, 5, "Tuesday");
		Period period12 = new Period(12, 6, "Tuesday");
		Period period13 = new Period(13, 1, "Wednesday");
		Period period14 = new Period(14, 2, "Wednesday");
		Period period15 = new Period(15, 3, "Wednesday");
		Period period16 = new Period(16, 4, "Wednesday");
		Period period17 = new Period(17, 5, "Wednesday");
		Period period18 = new Period(18, 6, "Wednesday");
		Period period19 = new Period(19, 1, "Thursday");
		Period period20 = new Period(20, 2, "Thursday");
		Period period21 = new Period(21, 3, "Thursday");
		Period period22 = new Period(22, 4, "Thursday");
		Period period23 = new Period(23, 5, "Thursday");
		Period period24 = new Period(24, 6, "Thursday");
		Period period25 = new Period(25, 1, "Friday");
		Period period26 = new Period(26, 2, "Friday");
		Period period27 = new Period(27, 3, "Friday");
		Period period28 = new Period(28, 4, "Friday");
		Period period29 = new Period(29, 5, "Friday");
		Period period30 = new Period(30, 6, "Friday");

		Lecturer lect1 = new Lecturer(1, "Гулаєва Н.", new ArrayList<Period>(
				Arrays.asList(period5, period6, period11, period12)));
		Lecturer lect2 = new Lecturer(1, "Проценко В.", new ArrayList<Period>(
				Arrays.asList(period7, period27, period28, period29, period30)));
		Lecturer lect3 = new Lecturer(1, "Гречко А.", new ArrayList<Period>());
		Lecturer lect4 = new Lecturer(1, "Черкасов Д.",
				new ArrayList<Period>(Arrays.asList(period17, period14,
						period15, period16, period18)));
		Lecturer lect5 = new Lecturer(1, "Гороховський С.", new ArrayList<Period>(
				Arrays.asList(period1, period7, period13, period19, period25)));
		Lecturer lect6 = new Lecturer(1, "Франчук О.", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect7 = new Lecturer(1, "Дорош О.", new ArrayList<Period>());
		Lecturer lect8 = new Lecturer(1, "Opanasyuk", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect9 = new Lecturer(1, "Zahariichenko",
				new ArrayList<Period>(Arrays.asList(period7, period8, period9,
						period27, period28, period29, period30)));
		Lecturer lect10 = new Lecturer(1, "Mytnyk", new ArrayList<Period>());
		Lecturer lect11 = new Lecturer(1, "Pul", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect12 = new Lecturer(1, "Rus", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect13 = new Lecturer(1, "Kryukova", new ArrayList<Period>());
		Lecturer lect14 = new Lecturer(1, "Жежерун О.", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect15 = new Lecturer(1, "Сидоренко М.", new ArrayList<Period>(
				Arrays.asList(period7, period8, period9, period27, period28,
						period29, period30)));
		Lecturer lect16 = new Lecturer(1, "Afo", new ArrayList<Period>());
		Lecturer lect17 = new Lecturer(1, "Boroz", new ArrayList<Period>(
				Arrays.asList(period12, period13, period22, period23, period25,
						period24)));
		Lecturer lect18 = new Lecturer(1, "Chornei", new ArrayList<Period>());
		Lecturer lect19 = new Lecturer(1, "Глибовець А.", new ArrayList<Period>());
		Lecturer lect20 = new Lecturer(1, "Myhaluch", new ArrayList<Period>());
		Lecturer lect21 = new Lecturer(1, "Sinicuna", new ArrayList<Period>());
		Lecturer lect22 = new Lecturer(1, "Dyachenko", new ArrayList<Period>());
		Lecturer lect23 = new Lecturer(1, "Oliynyk", new ArrayList<Period>());
		Lecturer lect24 = new Lecturer(1, "Ywenko", new ArrayList<Period>());
		Lecturer lect25 = new Lecturer(1, "Morozov", new ArrayList<Period>());
		Lecturer lect26 = new Lecturer(1, "Dybrovskyu", new ArrayList<Period>());
		Lecturer lect27 = new Lecturer(1, "Wvai", new ArrayList<Period>());
		Lecturer lect28 = new Lecturer(1, "Oletskyi", new ArrayList<Period>());
		Lecturer lect29 = new Lecturer(1, "Meitys", new ArrayList<Period>());
		Lecturer lect30 = new Lecturer(1, "Norkin", new ArrayList<Period>());
		Lecturer lect31 = new Lecturer(1, "Glomozda", new ArrayList<Period>());

		GroupCode groupCode1 = new GroupCode(0, "ГА", "lect", lect1, 11,"(1-14)");
		GroupCode groupCode2 = new GroupCode(1, "ГА", "prakt", lect1, 11, "(1-14)");
		GroupCode groupCode3 = new GroupCode(2, "КО", "lect", lect2, 11,"(1-14)");
		GroupCode groupCode4 = new GroupCode(3, "КО", "prakt", lect2, 11,"(1-14)");
		GroupCode groupCode5 = new GroupCode(4, "ПП", "lect", lect3, 11,"(3-13)");
		GroupCode groupCode6 = new GroupCode(5, "ПП", "prakt", lect3,11, "(3-14)");
		GroupCode groupCode7 = new GroupCode(6, "Qos", "lect", lect4, 11,"(1-15)");
		GroupCode groupCode8 = new GroupCode(7, "Qos", "prakt", lect4, 11,"(1-14)");
		GroupCode groupCode9 = new GroupCode(8, "НДС", "lect", lect5, 11,"(1-14)");
		GroupCode groupCode10 = new GroupCode(9, "НДС", "prakt", lect5, 11,"(1-14)");
		GroupCode groupCode11 = new GroupCode(10, "ОП", "lect", lect6, 11,"(1-3)");
		GroupCode groupCode12 = new GroupCode(11, "ОП", "prakt", lect6, 11,"(3-10)");
		GroupCode groupCode13 = new GroupCode(12, "ДПРБЗ", "lect", lect7, 11,"(1-14)");
		GroupCode groupCode14 = new GroupCode(13, "ДПРБЗ", "prakt", lect7, 11,"(1-14)");

//		// ---1 PI
//		GroupCode groupCode15 = new GroupCode(0, "PH", "lect", lect8, 60);
//		GroupCode groupCode16 = new GroupCode(1, "PH", "prakt", lect8, 10);
//		GroupCode groupCode17 = new GroupCode(2, "PH", "prakt", lect8, 10);
//		GroupCode groupCode18 = new GroupCode(3, "PH", "prakt", lect8, 10);
//
//		GroupCode groupCode19 = new GroupCode(0, "MA", "lect", lect9, 60);
//		GroupCode groupCode20 = new GroupCode(1, "MA", "prakt", lect9, 20);
//		GroupCode groupCode21 = new GroupCode(2, "MA", "prakt", lect10, 20);
//		GroupCode groupCode22 = new GroupCode(3, "MA", "prakt", lect11, 20);
//
//		GroupCode groupCode23 = new GroupCode(0, "LA", "lect", lect12, 60);
//		GroupCode groupCode24 = new GroupCode(1, "LA", "prakt", lect12, 20);
//		GroupCode groupCode25 = new GroupCode(2, "LA", "prakt", lect13, 20);
//		GroupCode groupCode26 = new GroupCode(3, "LA", "prakt", lect13, 20);
//
//		// 4 ---
//
//		GroupCode groupCode27 = new GroupCode(0, "SP", "lect", lect14, 42);
//		GroupCode groupCode28 = new GroupCode(1, "SP", "prakt", lect14, 14);
//		GroupCode groupCode29 = new GroupCode(2, "SP", "prakt", lect14, 14);
//		GroupCode groupCode30 = new GroupCode(3, "SP", "prakt", lect14, 14);
//
//		GroupCode groupCode31 = new GroupCode(0, "UPP", "lect", lect2, 42);
//		GroupCode groupCode32 = new GroupCode(1, "UPP", "prakt", lect2, 14);
//		GroupCode groupCode33 = new GroupCode(2, "UPP", "prakt", lect15, 14);
//		GroupCode groupCode34 = new GroupCode(3, "UPP", "prakt", lect15, 14);
//
//		GroupCode groupCode35 = new GroupCode(0, "TPZ", "lect", lect16, 42);
//		GroupCode groupCode36 = new GroupCode(1, "TPZ", "prakt", lect16, 14);
//		GroupCode groupCode37 = new GroupCode(2, "TPZ", "prakt", lect17, 14);
//		GroupCode groupCode38 = new GroupCode(3, "TPZ", "prakt", lect16, 14);
//
//		GroupCode groupCode39 = new GroupCode(0, "TM", "lect", lect16, 42);
//		GroupCode groupCode40 = new GroupCode(1, "TM", "prakt", lect16, 14);
//		GroupCode groupCode41 = new GroupCode(1, "TM", "prakt", lect16, 14);
//
//		// Prykladna-3
//		GroupCode groupCode42 = new GroupCode(0, "TITS", "lect", lect18, 20);
//		GroupCode groupCode43 = new GroupCode(0, "TITS", "pract", lect18, 20);
//		GroupCode groupCode44 = new GroupCode(0, "YATDF", "lect", lect9, 20);
//		GroupCode groupCode45 = new GroupCode(0, "YATDF", "pract", lect9, 20);
//		GroupCode groupCode46 = new GroupCode(0, "TFKZ", "lect", lect13, 20);
//		GroupCode groupCode47 = new GroupCode(0, "TFKZ", "pract", lect13, 20);
//		GroupCode groupCode48 = new GroupCode(0, "OGeom", "lect", lect19, 20);
//		GroupCode groupCode49 = new GroupCode(0, "OGeom", "pract", lect19, 20);
//		GroupCode groupCode50 = new GroupCode(0, "MMDO", "lect", lect20, 20);
//		GroupCode groupCode51 = new GroupCode(0, "MMDO", "pract", lect20, 20);
//		GroupCode groupCode52 = new GroupCode(0, "BDIS", "lect", lect2, 20);
//		GroupCode groupCode53 = new GroupCode(0, "BDIS", "pract", lect21, 10);
//		GroupCode groupCode54 = new GroupCode(0, "BDIS", "pract", lect2, 10);
//
//		// PRM-1
//		GroupCode groupCode55 = new GroupCode(0, "AG", "lect", lect22, 40);
//		GroupCode groupCode56 = new GroupCode(1, "AG", "prakt", lect22, 20);
//		GroupCode groupCode57 = new GroupCode(2, "AG", "ptakt", lect22, 20);
//		GroupCode groupCode58 = new GroupCode(3, "DM", "lect", lect18, 40);
//		GroupCode groupCode59 = new GroupCode(0, "DM", "prakt", lect23, 20);
//		GroupCode groupCode60 = new GroupCode(1, "DM", "prakt", lect27, 20);
//		GroupCode groupCode61 = new GroupCode(2, "MATA", "lect", lect10, 40);
//		GroupCode groupCode62 = new GroupCode(3, "MATA", "prakt", lect10, 20);
//		GroupCode groupCode63 = new GroupCode(3, "MATA", "prakt", lect22, 20);
//		GroupCode groupCode64 = new GroupCode(0, "AG1", "prakt", lect22, 20);
//		GroupCode groupCode65 = new GroupCode(1, "AG1", "prakt", lect22, 20);
//
//		GroupCode groupCode66 = new GroupCode(2, "Prog1", "lect", lect26, 40);
//		GroupCode groupCode67 = new GroupCode(3, "Prog1", "prakt", lect24, 10);
//		GroupCode groupCode68 = new GroupCode(3, "Prog1", "prakt", lect15, 10);
//		GroupCode groupCode69 = new GroupCode(0, "Prog1", "prakt", lect24, 10);
//		GroupCode groupCode70 = new GroupCode(1, "Prog1", "prakt", lect15, 10);
//		GroupCode groupCode71 = new GroupCode(0, "DRA", "lect", lect25, 40);
//		GroupCode groupCode72 = new GroupCode(1, "DRA", "prakt", lect25, 20);
//		GroupCode groupCode73 = new GroupCode(2, "DRA", "ptakt", lect25, 20);
//
//		GroupCode groupCode74 = new GroupCode(12, "GWT", "prakt", lect7, 11);
//		GroupCode groupCode75 = new GroupCode(13, "PRZYN", "lect", lect20, 11);
//		GroupCode groupCode76 = new GroupCode(13, "PRZYN", "prakt", lect20, 11);
//		GroupCode groupCode77 = new GroupCode(13, "TAK", "lect", lect18, 11);
//		GroupCode groupCode78 = new GroupCode(13, "MNO", "lect", lect18, 11);
//		GroupCode groupCode79 = new GroupCode(13, "MNO", "prakt", lect18, 11);
//		GroupCode groupCode80 = new GroupCode(13, "NDS", "lect", lect18, 11);
//		GroupCode groupCode81 = new GroupCode(13, "NDS1", "lect", lect18, 11);
//
		GroupCode groupCode82 = new GroupCode(13, "ІССД", "lect", lect15, 11,"(1-14)");
//		GroupCode groupCode83 = new GroupCode(13, "ICCD", "prakt", lect15, 11);
//		GroupCode groupCode84 = new GroupCode(13, "SMWI", "lect", lect28, 11);
//		GroupCode groupCode85 = new GroupCode(13, "SMWI", "prakt", lect28, 11);
//		GroupCode groupCode86 = new GroupCode(13, "PZIS", "lect", lect1, 11);
//		GroupCode groupCode87 = new GroupCode(13, "PZIS2", "pract", lect1, 11); // TODO:
//		GroupCode groupCode88 = new GroupCode(13, "SMWI1", "lect", lect28, 11);//TODO:
//		GroupCode groupCode89 = new GroupCode(13, "SMWI1", "prakt", lect28, 11);//TODO:
//		GroupCode groupCode90 = new GroupCode(13, "SPR", "lect", lect18, 11);
//
//		GroupCode groupCode91 = new GroupCode(13, "SPR2", "pract", lect18, 11);// TODO:
		GroupCode groupCode92 = new GroupCode(0, "ІССД", "prakt", lect15, 11,"(1-14)");
		GroupCode groupCode93 = new GroupCode(1, "МРПС", "lect", lect14, 11,"(1-14)");
		GroupCode groupCode94 = new GroupCode(1, "МРПС", "prakt", lect14, 11,"(1-14)");
		GroupCode groupCode95 = new GroupCode(1, "ПО", "lect", lect5, 11,"(1-14)");
		GroupCode groupCode96 = new GroupCode(1, "ПО", "prakt", lect5, 11,"(1-14)");
		GroupCode groupCode97 = new GroupCode(1, "ПВММ", "lect", lect7, 11,"(1-14)");
		GroupCode groupCode98 = new GroupCode(1, "ПВММ", "prakt", lect7, 11,"(1-14)");
		GroupCode groupCode99 = new GroupCode(1, "ПОС", "lect", lect19, 11,"(1-14)");
		GroupCode groupCode100 = new GroupCode(1, "ПОС", "prakt", lect19, 11,"(1-14)");

//		// PZS-1
//		GroupCode groupCode101 = new GroupCode(0, "MRPS2", "lect", lect29, 11);
//		GroupCode groupCode102 = new GroupCode(1, "MRPS2", "prakt", lect29, 11);
//		GroupCode groupCode103 = new GroupCode(2, "YPP", "lect", lect30, 11);
//		GroupCode groupCode104 = new GroupCode(3, "YPP", "prakt", lect30, 11);
//		GroupCode groupCode105 = new GroupCode(4, "PVMM-PZS", "lect", lect31,
//				11);
//		GroupCode groupCode106 = new GroupCode(5, "PVMM-PZS", "prakt", lect31,
//				11);
//		GroupCode groupCode107 = new GroupCode(6, "YD", "lect", lect26, 11);
//		GroupCode groupCode108 = new GroupCode(7, "YD", "prakt", lect26, 11);
//
//		// PZS-2
//		GroupCode groupCode109 = new GroupCode(0, "PD1", "lect", lect1, 11);
//		GroupCode groupCode110 = new GroupCode(1, "PD2", "lect1", lect1, 11);
//		GroupCode groupCode111 = new GroupCode(2, "PD3", "lect2", lect1, 11);
//
//		GroupCode groupCode112 = new GroupCode(3, "KOP", "prakt", lect31, 11);
//		GroupCode groupCode113 = new GroupCode(4, "KOP", "lect", lect31, 11);
//		GroupCode groupCode114 = new GroupCode(5, "OPG", "prakt", lect6, 11);
//
//		GroupCode groupCode115 = new GroupCode(6, "MT", "lect", lect21, 11);
//		GroupCode groupCode116 = new GroupCode(7, "MT", "prakt", lect21, 11);
//		GroupCode groupCode117 = new GroupCode(2, "PASY", "lect", lect26, 11);
//
//		GroupCode groupCode118 = new GroupCode(3, "PASY", "prakt", lect26, 11);
//
//		GroupCode groupCode119 = new GroupCode(4, "NDS-PZS", "lect", lect5, 11);
//		GroupCode groupCode120 = new GroupCode(5, "NDS-PZS", "prakt", lect5, 11);
//
//		GroupCode groupCode121 = new GroupCode(6, "MPKIS", "lect", lect26, 11);
//		GroupCode groupCode122 = new GroupCode(7, "MPKIS", "prakt", lect26, 11);
//
//		GroupCode groupCode123 = new GroupCode(6, "Ajax", "lect", lect21, 11);
//		GroupCode groupCode124 = new GroupCode(7, "Ajax", "prakt", lect21, 11);

		Group group1 = new Group(1, groupCode1, 0, "МП ІУСТ-2");
		Group group2 = new Group(2, groupCode2, 1, "МП ІУСТ-2");
		Group group3 = new Group(3, groupCode3, 0, "МП ІУСТ-2");
		Group group4 = new Group(4, groupCode4, 1, "МП ІУСТ-2");
		Group group5 = new Group(5, groupCode5, 0, "МП ІУСТ-2");
		Group group6 = new Group(6, groupCode6, 1, "МП ІУСТ-2");
		Group group7 = new Group(7, groupCode7, 0, "МП ІУСТ-2");
		Group group8 = new Group(8, groupCode8, 1, "МП ІУСТ-2");
		Group group9 = new Group(9, groupCode9, 0, "МП ІУСТ-2");
		Group group10 = new Group(10, groupCode10, 1, "МП ІУСТ-2");
		Group group11 = new Group(11, groupCode11, 0, "МП ІУСТ-2");
		Group group12 = new Group(12, groupCode12, 1, "МП ІУСТ-2");
		Group group13 = new Group(13, groupCode13, 0, "МП ІУСТ-2");
		Group group14 = new Group(14, groupCode14, 1, "МП ІУСТ-2");

//		Group group15 = new Group(10, groupCode15, 0, "PI-1");
//		Group group16 = new Group(11, groupCode16, 1, "PI-1");
//		Group group17 = new Group(12, groupCode17, 2, "PI-1");
//		Group group18 = new Group(13, groupCode18, 3, "PI-1");
//
//		Group group19 = new Group(10, groupCode19, 0, "PI-1");
//		Group group20 = new Group(11, groupCode20, 1, "PI-1");
//		Group group21 = new Group(12, groupCode21, 2, "PI-1");
//		Group group22 = new Group(13, groupCode22, 3, "PI-1");
//
//		Group group23 = new Group(10, groupCode23, 0, "PI-1");
//		Group group24 = new Group(11, groupCode24, 1, "PI-1");
//		Group group25 = new Group(12, groupCode25, 2, "PI-1");
//		Group group26 = new Group(13, groupCode26, 3, "PI-1");
//
//		// --4
//		Group group27 = new Group(10, groupCode27, 0, "PI-4");
//		Group group28 = new Group(11, groupCode28, 1, "PI-4");
//		Group group29 = new Group(12, groupCode29, 2, "PI-4");
//		Group group30 = new Group(13, groupCode30, 3, "PI-4");
//
//		Group group31 = new Group(10, groupCode31, 0, "PI-4");
//		Group group32 = new Group(11, groupCode32, 1, "PI-4");
//		Group group33 = new Group(12, groupCode33, 2, "PI-4");
//		Group group34 = new Group(13, groupCode34, 3, "PI-4");
//
//		Group group35 = new Group(10, groupCode35, 0, "PI-4");
//		Group group36 = new Group(11, groupCode36, 1, "PI-4");
//		Group group37 = new Group(12, groupCode37, 2, "PI-4");
//		Group group38 = new Group(13, groupCode38, 3, "PI-4");
//
//		Group group42 = new Group(1, groupCode42, 0, "PRM-3");
//		Group group43 = new Group(1, groupCode43, 1, "PRM-3");
//		Group group44 = new Group(1, groupCode44, 0, "PRM-3");
//		Group group45 = new Group(1, groupCode45, 1, "PRM-3");
//		Group group46 = new Group(1, groupCode46, 0, "PRM-3");
//		Group group47 = new Group(1, groupCode47, 1, "PRM-3");
//		Group group48 = new Group(1, groupCode48, 0, "PRM-3");
//		Group group49 = new Group(1, groupCode49, 1, "PRM-3");
//		Group group50 = new Group(1, groupCode50, 0, "PRM-3");
//		Group group51 = new Group(1, groupCode51, 1, "PRM-3");
//		Group group52 = new Group(1, groupCode52, 0, "PRM-3");
//		Group group53 = new Group(1, groupCode53, 1, "PRM-3");
//		Group group54 = new Group(1, groupCode54, 1, "PRM-3");
//
//		// PRM-1
//		Group group55 = new Group(1, groupCode55, 0, "PRM-1");
//		Group group56 = new Group(2, groupCode56, 1, "PRM-1");
//		Group group57 = new Group(3, groupCode57, 2, "PRM-1");
//		Group group58 = new Group(4, groupCode58, 0, "PRM-1");
//		Group group59 = new Group(1, groupCode59, 1, "PRM-1");
//		Group group60 = new Group(2, groupCode60, 2, "PRM-1");
//		Group group61 = new Group(3, groupCode61, 0, "PRM-1");
//		Group group62 = new Group(4, groupCode62, 1, "PRM-1");
//		Group group63 = new Group(4, groupCode63, 2, "PRM-1");
//		Group group64 = new Group(4, groupCode64, 1, "PRM-1");
//		Group group65 = new Group(4, groupCode65, 2, "PRM-1");
//		Group group66 = new Group(1, groupCode66, 0, "PRM-1");
//		Group group67 = new Group(2, groupCode67, 1, "PRM-1");
//		Group group68 = new Group(3, groupCode68, 2, "PRM-1");
//		Group group69 = new Group(4, groupCode69, 3, "PRM-1");
//		Group group70 = new Group(4, groupCode70, 4, "PRM-1");
//		Group group71 = new Group(4, groupCode71, 0, "PRM-1");
//		Group group72 = new Group(4, groupCode72, 1, "PRM-1");
//		Group group73 = new Group(4, groupCode73, 2, "PRM-1");
//		Group group74 = new Group(1, groupCode74, 1, "SMPR-2");
//		Group group75 = new Group(2, groupCode75, 0, "SMPR-2");
//		Group group76 = new Group(3, groupCode76, 1, "SMPR-2");
//		Group group77 = new Group(4, groupCode77, 0, "SMPR-2");
//		Group group78 = new Group(1, groupCode78, 0, "SMPR-2");
//		Group group79 = new Group(2, groupCode79, 1, "SMPR-2");
//		Group group80 = new Group(3, groupCode80, 0, "SMPR-2");
//		Group group81 = new Group(4, groupCode81, 0, "SMPR-2");

		Group group82 = new Group(1, groupCode82, 0, "МП ІУСТ-1");
//		Group group83 = new Group(2, groupCode83, 0, "SMPR-1");
//		Group group84 = new Group(3, groupCode84, 1, "SMPR-1");
//		Group group85 = new Group(4, groupCode85, 0, "SMPR-1");
//		Group group86 = new Group(1, groupCode86, 0, "SMPR-1");
//		Group group87 = new Group(2, groupCode87, 1, "SMPR-1");
//		Group group88 = new Group(3, groupCode88, 0, "SMPR-1");
//		Group group89 = new Group(4, groupCode89, 0, "SMPR-1");
//		Group group90 = new Group(1, groupCode90, 1, "SMPR-1");
//		Group group91 = new Group(2, groupCode91, 0, "SMPR-1");

		Group group92 = new Group(1, groupCode92, 1, "МП ІУСТ-1");
		Group group93 = new Group(2, groupCode93, 0, "МП ІУСТ-1");
		Group group94 = new Group(3, groupCode94, 1, "МП ІУСТ-1");
		Group group95 = new Group(1, groupCode95, 0, "МП ІУСТ-1");
		Group group96 = new Group(2, groupCode96, 1, "МП ІУСТ-1");
		Group group97 = new Group(3, groupCode97, 0, "МП ІУСТ-1");
		Group group98 = new Group(1, groupCode98, 1, "МП ІУСТ-1");
		Group group99 = new Group(2, groupCode99, 0, "МП ІУСТ-1");
		Group group100 = new Group(3, groupCode100,1, "МП ІУСТ-1");
		// PZS-1
//		Group group101 = new Group(0, groupCode101, 0, "PZS-1");
//		Group group102 = new Group(0, groupCode102, 1, "PZS-1");
//		Group group103 = new Group(0, groupCode103, 0, "PZS-1");
//		Group group104 = new Group(0, groupCode104, 1, "PZS-1");
//		Group group105 = new Group(0, groupCode105, 0, "PZS-1");
//		Group group106 = new Group(0, groupCode106, 1, "PZS-1");
//		Group group107 = new Group(0, groupCode107, 0, "PZS-1");
//		Group group108 = new Group(0, groupCode108, 1, "PZS-1");
//		// PZS-2
//		Group group109 = new Group(0, groupCode109, 0, "PZS-2");
//		Group group110 = new Group(0, groupCode110, 0, "PZS-2");
//		Group group111 = new Group(0, groupCode111, 0, "PZS-2");
//		Group group112 = new Group(0, groupCode112, 1, "PZS-2");
//		Group group113 = new Group(0, groupCode113, 0, "PZS-2");
//		Group group114 = new Group(0, groupCode114, 1, "PZS-2");
//
//		Group group115 = new Group(0, groupCode115, 0, "PZS-2");
//		Group group116 = new Group(0, groupCode116, 1, "PZS-2");
//		Group group117 = new Group(0, groupCode117, 0, "PZS-2");
//		Group group118 = new Group(0, groupCode118, 1, "PZS-2");
//		Group group119 = new Group(0, groupCode119, 0, "PZS-2");
//		Group group120 = new Group(0, groupCode120, 1, "PZS-2");
//
//		Group group121 = new Group(0, groupCode121, 0, "PZS-2");
//		Group group122 = new Group(0, groupCode122, 1, "PZS-2");
//		Group group123 = new Group(0, groupCode123, 0, "PZS-2");
//		Group group124 = new Group(0, groupCode124, 1, "PZS-2");
//
		Group[] group = { group1, group2, group3, group4, group5, group6,
				group7, group8, group9, group10, group11, group12, group13,
				group14,
//				///* 
//				  group15, group16, group17, group18, group19, group20,
//				 
//				group21, group22, group23, group24, group25, group26, group27,
//				group28, group29, group30, group31, group32, group33, group34,
//				group35, group36, group37, group38, group42, group43, group44,
//				group45, group46, group47, group48, group49, group50, group51,
//				group52, group53, group54, group55, group56, group57, group58,
//				group59, group60, group61, group62, group63, group64, group65,
//				group66, group67, group68, group69, group70, group71, group72,
//				group73, group74, group75, group76, group77, group78, group79,
//				group80, group81, group82, group83, group84, group85, group86,
//				group87, group88, group89, group90, group91, 
				//*/
				
				 group92, group93,
				group94, group95, group96, group97, group98, group99, group100,
				/*
				group101, group102, group103, group104, group105, group106,
				group107, group108, group109, group110, group111, group112,
				group113, group114, group115, group116, group117, group118,
				group119, group120, group121, group122, group123, group124 
				*/
				 };

		HashMap<Integer, Group> setOfGroups = new HashMap<Integer, Group>();

		for (int i1 = 0; i1 < 21; i1++) {
			setOfGroups.put(i1, group[i1]);
		}

		
		
		HashMap<Group, Integer> setOfEncodedGroups = Group.setOfEncodedGroups(
				setOfGroups, STARTPOINT);
	
		return new Pair<HashMap<Integer, Group>, HashMap<Group, Integer>>(
				setOfGroups, setOfEncodedGroups);
	}
}
