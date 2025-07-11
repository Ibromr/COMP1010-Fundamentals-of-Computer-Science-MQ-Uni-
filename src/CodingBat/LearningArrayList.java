package CodingBat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LearningArrayList {

    public static void main(String[] args) {
        System.out.println(nInARow(new ArrayList<Integer>(Arrays.asList(10, 10, 20, 20, 20, 20, 10, 10)), 4));
        System.out.println("generate2D(2, 3) → Expected:[[0, 0, 0], [0, 0, 0]] -> Run:" + generate2D(2, 3));
        System.out.println("frequencyTable([10, 70, 20, 90, 70, 70, 20, 70, 20, 20, 20, 90, 20]) " +
                "→ Expected:[[10, 1], [70, 4], [20, 6], [90, 2]] " +
                " -> Run:"
                + frequencyTable(new ArrayList<Integer>(List.of(10, 70, 20, 90, 70, 70, 20, 70, 20, 20, 20, 90, 20))));
    }

    /*
     * Define a function that when passed an ArrayList of
     * Integer objects and an integer (say, n), returns true if it contains n
     * identical consecutive items anywhere in the list, false otherwise.
     * 
     * 
     * nInARow([10, 10, 20, 20, 10, 10], 3) → false
     * nInARow([10, 10, 20, 20, 10, 10], 2) → true
     * nInARow([10, 10, 10, 20, 20, 10, 10], 3) → true
     */
    static boolean nInARow(ArrayList<Integer> list, int n) {
        if (list.size() == 0) {
            return false;
        }
        Integer number = list.get(0);
        int count = n;
        for (Integer item : list) {
            if (item != number) {
                count = n;
                number = item;
            }
            if (item == number) {
                count--;
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isNiceOrder(ArrayList<Integer> list) {
        if (list.size() <= 1 || list.size() <= 2) {
            return true;
        }

        for (int i = 1; i < list.size() - 2; i++) {
            if (list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Given two integers (say n and p), return a homogenous ArrayList of ArrayList
     * of Integer
     * objects such that it holds n ArrayLists, each containing p zeroes.
     * 
     * 
     * generate2D(2, 3) → [[0, 0, 0], [0, 0, 0]]
     * generate2D(3, 2) → [[0, 0], [0, 0], [0, 0]]
     * generate2D(1, 5) → [[0, 0, 0, 0, 0]]
     */
    static ArrayList<ArrayList<Integer>> generate2D(int n, int p) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList();
            for (int k = 0; k < p; k++) {
                temp.add(0);
            }
            list.add(temp);
        }
        return list;
    }

    /*
     * Define a function that when passed an ArrayList of Integer objects,
     * returns an ArrayList containing the frequency table. That is a list
     * containing tuples,
     * the first value being the item, and the second its count in the passed list.
     * See the input-output mappings to understand this further.
     * 
     * 
     * frequencyTable([10, 70, 20, 90, 70, 70, 20, 70, 20, 20, 20, 90, 20])
     * → [[10, 1], [70, 4], [20, 6], [90, 2]]
     * frequencyTable([10, 10, 10, 10, 10]) → [[10, 5]]
     * frequencyTable([]) → []
     * 
     */
    // static ArrayList frequencyTable(ArrayList<Integer> list) {
    // ArrayList<ArrayList<Integer>> frenqList = new ArrayList();

    // int count = 1;
    // for (int i = 0; i < list.size(); i++) {
    // boolean found = false;
    // for (ArrayList<Integer> row: frenqList) {
    // if(row.get(0).equals(list.get(i))) {
    // row.set(1, row.get(1) + 1);
    // found = true;
    // break;
    // }
    // }
    // if(!found) {
    // ArrayList<Integer> num = new ArrayList();
    // num.add(list.get(i));
    // num.add(1);
    // frenqList.add(num);
    // }
    // }

    // return frenqList;
    // }
    static ArrayList frequencyTable(ArrayList<Integer> list) {
        LinkedHashMap<Integer, Integer> frenqList = new LinkedHashMap<>();

        for (Integer item : list) {
            if (frenqList.containsKey(item)) {
                frenqList.put(item, frenqList.get(item) + 1);
            } else {
                frenqList.put(item, 1);
            }
        }

        ArrayList<ArrayList<Integer>> frenqArrayList = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : frenqList.entrySet()) {
            ArrayList<Integer> num = new ArrayList();
            num.add(entry.getKey());
            num.add(entry.getValue());
            frenqArrayList.add(num);
        }
        return frenqArrayList;
    }

}
