package CodingBat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Delegation {
    public static void main(String[] args) {

        // System.out.println(isNiceOrder(new ArrayList<>(Arrays.asList(10, 20,
        // 20,40))));

        System.out.println(
                same(new int[] { 1, 8, 2, 4, 6, 3, 5, 9, 7, 0 }, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }

    /*
     * 
     * Using the function that returns the number of times an item occurs in an
     * array,
     * define a function that when passed two arrays, returns true if they contain
     * the exact same items, even if in a different order, false otherwise.
     * Return false if either array is null.
     * 
     * int count(int[] data, int item) {
     * int result = 0;
     * for(int i=0; i < data.length; i++) {
     * if(data[i] == item) {
     * result++;
     * }
     * }
     * return result;
     * }
     * 
     * same([10, 70, 20, 90], [90, 20, 10, 70]) → true
     * same([1, 2, 3], [3, 1, 2]) → true
     * same([10, 70, 20, 90], [90, 20, 20, 70]) → false
     * 
     */
    static boolean same(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (Integer item : map.keySet()) {
            if (count(b, item) != map.get(item)) {
                return false;
            }
        }
        return true;
    }

    static int count(int[] data, int item) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == item) {
                result++;
            }
        }
        return result;
    }
}
