package CodingBat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LearningArrayList {

    public static void main(String[] args) {

        // System.out.println(isNiceOrder(new ArrayList<>(Arrays.asList(10, 20, 20,40))));

        System.out.println(nInARow(new ArrayList<Integer>(Arrays.asList(10, 10, 20, 20, 20, 20, 10, 10)), 4));
    }

    /*
     * Define a function that when passed an ArrayList of 
     * Integer objects and an integer (say, n), returns true if it contains n 
     * identical consecutive items anywhere in the list, false otherwise.


    nInARow([10, 10, 20, 20, 10, 10], 3) → false
    nInARow([10, 10, 20, 20, 10, 10], 2) → true
    nInARow([10, 10, 10, 20, 20, 10, 10], 3) → true
     */
    static boolean nInARow(ArrayList<Integer> list, int n) {
        if(list.size() == 0) {
            return false;
        }
        Integer number = list.get(0);
        int count = n;
        for (Integer item : list) {
            if( item != number) {
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

}
