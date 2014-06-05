package ga.thesis.crossover;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PMXTest {

	@Test
	public void testCrossOverListsArrayListOfIntegerArrayListOfIntegerDoubleIntInt() {

//		ArrayList<Integer> arr1 = new ArrayList<Integer>();
//		arr1.add(1);
//		arr1.add(2);
//		arr1.add(3);
//		arr1.add(4);
//		arr1.add(5);
//		arr1.add(6);
//		arr1.add(7);
//		arr1.add(8);
//		arr1.add(9);
//
//		ArrayList<Integer> arr2 = new ArrayList<Integer>();
//		arr2.add(4);
//		arr2.add(5);
//		arr2.add(2);
//		arr2.add(1);
//		arr2.add(8);
//		arr2.add(7);
//		arr2.add(6);
//		arr2.add(9);
//		arr2.add(3);
//		
		List<Integer> arr1 = Arrays.asList(154, 100, 112, 172, 167, 135, 151, 148, 163, 178, 133, 203, 158, 205, 169, 139, 206, 213, 107, 111, 179, 156, 106, 130, 218, 129, 105, 188, 202, 121, 208, 177, 192, 123, 193, 190, 173, 131, 153, 142, 219, 118, 160, 194, 159, 196, 162, 125, 128, 140, 109, 184, 197, 209, 146, 217, 149, 101, 102, 147, 216, 200, 175, 141, 210, 134, 120, 170, 199, 215, 166, 111, 143, 124, 102, 125, 130, 120, 119, 194, 185, 139, 209, 131, 204, 217, 178, 134, 122, 136, 129, 167, 182, 112, 117, 180, 214, 185, 186, 207, 195, 161, 174, 144, 115, 201, 136, 126, 165, 189, 204, 198, 137, 124, 127, 145, 150, 119, 168, 122);
		List<Integer> arr2 = Arrays.asList(216, 203, 199, 150, 188, 207, 151, 149, 155, 183, 101, 162, 109, 105, 140, 127, 153, 214, 200, 123, 198, 185, 110, 184, 159, 205, 179, 148, 187, 210, 202, 107, 190, 212, 144, 171, 141, 176, 145, 114, 137, 215, 186, 170, 219, 126, 113, 193, 197, 142, 206, 164, 201, 154, 174, 133, 106, 104, 152, 163, 208, 118, 116, 115, 108, 180, 166, 195, 160, 177, 132, 155, 138, 108, 171, 212, 191, 164, 187, 143, 104, 176, 110, 113, 182, 114, 116, 132, 157, 183, 185, 103, 152, 211, 103, 192, 211, 196, 138, 165, 135, 175, 161, 128, 189, 121, 146, 191, 168, 157, 172, 218, 173, 147, 117, 156, 158, 169, 213, 100);
		
		ArrayList<Integer> g= new ArrayList<Integer>();
		g.addAll(arr1);
		
		ArrayList<Integer> g1 = new ArrayList<Integer>();
		g1.addAll(arr2);
		
		ArrayList<ArrayList<Integer>> resCrossO = PMX.crossOverLists(g,
				g1, 1.0, 71, 93);

		List<Integer> expected1 = Arrays.asList(4, 2, 3, 1, 8, 7, 6, 5, 9);
		List<Integer> expected2 = Arrays.asList(1, 8, 2, 4, 5, 6, 7, 9, 3);

		ArrayList<Integer> actual1 = resCrossO.get(0);
		ArrayList<Integer> actual2 = resCrossO.get(1);

		Assert.assertArrayEquals(arr(actual1), expected1.toArray(),
				actual1.toArray());
		Assert.assertArrayEquals(arr(actual2), expected2.toArray(),
				actual2.toArray());

	}

	public <T> String arr(List<T> a) {
		StringBuilder s = new StringBuilder();
		for (T l : a) {
			s.append(l).append(" ");
		}
		return s.toString();
	}

}

// 4 2 3 1 8 7 6 5 9
// 1 8 2 4 5 6 7 9 3

