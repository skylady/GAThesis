/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.thesis.testdata;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;

/**
 *
 * @author sky_lady
 */
public class TestData {
    
    public static HashMap<String, HashMap<Integer, ArrayList<String>>> testDisplay() {
    HashMap<String, HashMap<Integer, ArrayList<String>>> map = new HashMap<String, HashMap<Integer, ArrayList<String>>>();
ArrayList<String> list1 = new ArrayList<String>();
ArrayList<String> list2 = new ArrayList<String>();
HashMap<Integer, ArrayList<String>> map1 = new HashMap<Integer, ArrayList<String>>();
HashMap<String, HashMap<Integer, ArrayList<String>>> finalMap = new HashMap<String, HashMap<Integer, ArrayList<String>>>();
String test1="ЛП\n(1-15)\nВовк Н.\n223";
String test2="ЛП1"+"   "+"ВП2\n(1-15)"+"   "+"(1-15)\nВовк Н."+"   "+"Олецький О.\n204"+"   "+"206";
list1.add(test1);
list2.add(test2);
map1.put(10,list1);
map1.put(11, list2);
finalMap.put("HH", map1);
return map;
}
}
