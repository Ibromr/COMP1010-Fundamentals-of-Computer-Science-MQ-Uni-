package CodingBat;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LearningArrays {
    public static void main(String[] args) {
        System.out.println("Test 1 >>>>>>>>>>");
        System.out.println("merge([10, 70, 90], [20]) → Expected:[10, 20, 70, 90] \nRun:");
        int[] test1 = merge(new int[] { 10, 70, 90 }, new int[] { 20 });
        for (int item : test1) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Test 2 >>>>>>>>>>");
        System.out.println("distanceFromHome(['10N', '10W', '10S', '8E']) → Expected: 2.0 \nRun: "
                + distanceFromHome(new String[] { "10N", "10W", "10S", "8E" }));

        System.out.println("Test 3 >>>>>>>>>>");
        System.out.println("longestEvenRun([10, 60, 71, 120, 80, 100]) →  Expected: [120, 80, 100] \nRun:");
        int[] test3 = longestEvenRun(new int[] { 10, 60, 71, 120, 80, 100 });
        for (int item : test3) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Test 4 >>>>>>>>>>");
        System.out.println("longestAscendingRun([2, 1, 1, 4, 8]) →  Expected: [1, 1, 4, 8] \nRun:");
        int[] test4 = longestAscendingRun(new int[] { 2, 1, 1, 4, 8 });
        for (int item : test4) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Test 5 >>>>>>>>>>");
        System.out.println("oneInEachSubArray([10, 20, 30, 40, 10, 40], 3) → Expected: false \nRun:");
        System.out.println(oneInEachSubArray(new int[] { 10, 20, 30, 40, 10, 40 }, 3));

        System.out.println();
        System.out.println("Test 6 >>>>>>>>>>");
        System.out.println("shortenedIDs([25183, 10183]) → Expected: [5183, 183] \nRun:");
        int[] test5 = shortenedIDs(new int[] { 25183, 10183 });
        for (int item : test5) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /*
     * Define a function that when passed two arrays,
     * ach sorted in ascending order, returns an array
     * that merges the two arrays in an overall ascending order.
     * 
     * Treat a null array as an empty array.
     * 
     * 
     * merge([10, 70, 90], [20]) → [10, 20, 70, 90]
     * merge([], [1, 2, 3, 4, 5, 6]) → [1, 2, 3, 4, 5, 6]
     * merge([1, 2, 3, 4, 5, 6, 7, 8], []) → [1, 2, 3, 4, 5, 6, 7, 8]
     */
    static int[] merge(int[] a, int[] b) {
        if (a == null && b == null) {
            return new int[] {};
        }
        if (a == null) {
            return b; // If a is null, return b
        }
        if (b == null) {
            return a; // If b is null, return a
        }
        int[] result = new int[a.length + b.length];
        int j = 0, k = 0, i = 0;
        while (j < a.length && k < b.length) {
            if (a[j] < b[k]) {
                result[i++] = a[j++];
            } else {
                result[i++] = b[k++];
            }
        }
        while (j < a.length) {
            result[i++] = a[j++];
        }
        while (k < b.length) {
            result[i++] = b[k++];
        }

        return result;
    }

    /*
     * In a legacy system, directions are stored by magnitude followed by direction.
     * Thus, "12E" represents " travel 12 kms towards east, "4N" represents 4kms to
     * the north,
     * "120S" represents 120 kms south and finally "3W" represents 3 kms towards
     * west.
     * 
     * Given an array that holds a collection of individiaul directions, return how
     * far from
     * the starting point will we be.
     * 
     * You can use Integer.parseInt(<String>) to convert a String to int (provided
     * it can be converted).
     * 
     * You will also need String functions such as charAt and substring.
     * 
     * 
     * distanceFromHome(["10N", "10W", "10S", "10E"]) → 0.0
     * distanceFromHome(["10N", "10W", "10S", "8E"]) → 2.0
     * distanceFromHome(["8N", "6W"]) → 10.0
     */
    static double distanceFromHome(String[] directions) {
        double northSouth = 0;
        double eastWest = 0;

        for (String dir : directions) {
            // Get last character (direction)
            char direction = dir.charAt(dir.length() - 1);

            // Extract magnitude (all characters except last)
            int magnitude = Integer.parseInt(dir.substring(0, dir.length() - 1));

            // Update position based on direction
            switch (direction) {
                case 'N':
                    northSouth += magnitude;
                    break;
                case 'S':
                    northSouth -= magnitude;
                    break;
                case 'E':
                    eastWest += magnitude;
                    break;
                case 'W':
                    eastWest -= magnitude;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);
            }
        }

        // Calculate straight-line distance using Pythagorean theorem
        return Math.sqrt(northSouth * northSouth + eastWest * eastWest);
    }

    /*
     * 
     * A frequency table is defined as a table containing each distinct item in a
     * set
     * and its corresponding number of occurrences. Define a function that when
     * passed
     * an integer array, returns the frequency table. The items should occur in
     * order of
     * their first occurrences in the original array. Because of the inability of
     * codingbat
     * to process mutli-dimensional array, the table should be an array of String
     * objects,
     * where each String represents the item and its frequency separated by a comma
     * and a space (", ").
     * 
     * 
     * frequencyTable([10, 70, 20, 70]) → ["10, 1", "70, 2", "20, 1"]
     * frequencyTable([5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]) → ["5, 14"]
     * frequencyTable([1, 2, 3, 4, 1, 2, 3, 4, 4, 3, 2, 1, 1, 3, 2, 4, 4, 2, 3, 1,
     * 5])
     * → ["1, 5", "2, 5", "3, 5", "4, 5", "5, 1"]
     * 
     * 
     * Call this to test :
     * String[] result = frequencyTable(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
     * 5, 5, 5});
     * System.out.println(Arrays.toString(result));
     * 
     */
    static String[] frequencyTable(int[] data) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i])) {
                map.put(data[i], map.get(data[i]) + 1); // Add 1 to existing count
            } else {
                map.put(data[i], 1); // First occurrence
            }
        }

        String[] table = new String[map.size()];

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            table[idx] = "" + entry.getKey() + ", " + entry.getValue() + "";
            idx++;
        }
        return table;
    }

    /*
     * 
     * Define a function that when passed an array, returns,
     * - true, if each item has its negated value (6 and -6 are mutual negatives,
     * for example), and,
     * - false, otherwise.
     * You may add helper function(s).
     * 
     * 
     * nemesisInTheHouse([6, -6, -6]) → true
     * nemesisInTheHouse([0, 0, -5, 8, 3, 5, 5, -8, 8, 8, 8, -8]) → false
     * nemesisInTheHouse([-3, 0, 0, -5, 8, 3, 5, 5, -8, 8, 8, 8, -8, -3]) → true
     */

    static boolean nemesisInTheHouse(int[] data) {
        HashSet<Integer> uIntegers = new HashSet<>();
        Arrays.stream(data).forEach(uIntegers::add);
        for (int i = 0; i < data.length; i++) {
            if (!(uIntegers.contains(-1 * data[i]))) {
                return false;
            }
        }
        return true;
    }

    /*
     * 
     * Define a function that, assuming the parameters:
     * - The daily prices of a particular stock (in chronological order) in an
     * array, and,
     * - An int representing the number of days;
     * Returns the highest profit for that EXACT time range. For example,
     * if prices = {13, 16, 20, 20, 21, 23, 28, 22, 24, 24, 24, 25, 35, 28, 30} and
     * days = 5, return 11 (stock jumping from 24 to 35).
     * 
     * 
     * maxProfit([13, 16, 20, 20, 21, 23, 28, 22, 24, 24, 24, 25, 35, 28, 30], 5) →
     * 11
     * maxProfit([13, 16, 20, 20, 21, 23, 28, 22, 24, 24, 24, 25, 35, 28, 30], 2) →
     * 10
     * maxProfit([13, 16, 20, 20, 21, 23, 28, 22, 24, 24, 24, 25, 35, 28, 30], 1) →
     * 0
     */
    static int maxProfit(int[] prices, int nDays) {
        if (nDays > prices.length) {
            return 0;
        }
        int max = prices[nDays - 1] - prices[0];

        for (int i = 0; i < prices.length - nDays; i++) {
            if (max < prices[nDays + i - 1] - prices[i]) {
                max = prices[nDays + i - 1] - prices[i];
            }
        }
        return max;
    }

    /*
     * 
     * Define a function that when passed an array, returns the longest stretch of
     * even numbers in the array.
     * 
     * In case of a tie, return the sequence occurring first.
     * 
     * 
     * longestEvenRun([]) → []
     * longestEvenRun([10, 60, 71, 120, 80, 100]) → [120, 80, 100]
     * longestEvenRun([1, 7, 3, 9]) → []
     * 
     */
    static int[] longestEvenRun(int[] data) {
        int count = 0;
        int startIdx = 0;
        boolean isStart = true;
        int earliestCount = 0;
        int earliestStartIndx = 0;
        for (int i = 0; i < data.length; i++) {

            if (data[i] % 2 == 0) {

                if (isStart) {
                    startIdx = i;
                    isStart = false;
                }

                count++;

                if (count > earliestCount) {
                    earliestCount = count;
                    earliestStartIndx = startIdx;
                }

                continue;
            }

            if (data[i] % 2 != 0) {
                isStart = true;
                count = 0;
            }

        }
        if (earliestCount == 0) {
            return new int[] {};
        }
        int[] longestEvenRun = new int[earliestCount];

        for (int i = 0; i < longestEvenRun.length; i++) {
            longestEvenRun[i] = data[earliestStartIndx++];

        }
        return longestEvenRun;
    }

    /*
     * Define a function that when passed an array, returns the longest subsequence
     * that is in ascending order in the array.
     * 
     * In case of a tie, return the sequence occurring first.
     * 
     * 
     * longestAscendingRun([]) → []
     * longestAscendingRun([10, 60, 71, 120, 80, 100]) → [10, 60, 71, 120]
     * longestAscendingRun([1, 7, 3, 9]) → [1, 7]
     */
    static int[] longestAscendingRun(int[] data) {
        int count = 1;
        int startIdx = 0;
        boolean isStart = true;
        int earliestCount = 0;
        int earliestStartIndx = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] >= data[i - 1]) {
                if (isStart) {
                    startIdx = i - 1;
                    isStart = false;
                }
                count++;
                if (i != data.length - 1) {
                    continue;
                }
            }
            if (count > earliestCount) {
                earliestCount = count;
                earliestStartIndx = startIdx;
                isStart = true;
                count = 1;
            }
            if (data[i] < data[i - 1]) {
                isStart = true;
                count = 1;
            }
        }
        if (earliestCount == 0) {
            return new int[] {};
        }
        int[] ascendingResult = new int[earliestCount];

        for (int i = 0; i < ascendingResult.length; i++) {
            ascendingResult[i] = data[earliestStartIndx++];

        }
        return ascendingResult;
    }

    /*
     * Define a function that when passed an integer array and a second integer
     * representing
     * the number of sub-arrays in which it should be divided (assume it can be
     * divided evenly),
     * returns true if there is at least one common item in every sub-array, false
     * otherwise.
     * 
     * 
     * oneInEachSubArray([20, 20, 20, 20], 2) → true
     * oneInEachSubArray([20, 20, 20, 10, 10, 10], 2) → false
     * oneInEachSubArray([10, 70, 20, 90, 50, 80, 60, 10, 20, 10, 100, 70], 3) →
     * true
     */
    static boolean oneInEachSubArray(int[] a, int n) {
        if (a.length == 0 || n <= 0)
            return false;

        int subSize = a.length / n; // Size of each subarray

        // Create a set of all elements in first subarray
        HashSet<Integer> commonElements = new HashSet<>();
        for (int i = 0; i < subSize; i++) {
            commonElements.add(a[i]);
        }

        // For each subsequent subarray
        for (int subArray = 1; subArray < n; subArray++) {
            HashSet<Integer> currentSubElements = new HashSet<>();
            int startIdx = subArray * subSize;

            // Track which elements from first subarray appear in this one
            for (int i = 0; i < subSize; i++) {
                int element = a[startIdx + i];
                if (commonElements.contains(element)) {
                    currentSubElements.add(element);
                }
            }

            // If no common elements with first subarray, return false
            if (currentSubElements.isEmpty()) {
                return false;
            }

            // Update common elements to those found in this subarray
            commonElements = currentSubElements;
        }

        return true;
    }

    // static boolean oneInEachSubArray(int[] a, int n) {
    // if (a.length == 0 || n <= 0)
    // return false;

    // int subSize = a.length / n;

    // // Track which positions in first subarray have elements that appear in ALL
    // // subarrays
    // boolean[] commonPositions = new boolean[subSize];
    // // Initially, all positions in first subarray are potential candidates
    // Arrays.fill(commonPositions, true);

    // // For each subsequent subarray
    // for (int subArray = 1; subArray < n; subArray++) {
    // boolean[] newCommonPositions = new boolean[subSize];
    // int startIdx = subArray * subSize;

    // // Check each position in first subarray
    // for (int pos = 0; pos < subSize; pos++) {
    // if (commonPositions[pos]) { // If this position was common so far
    // int firstSubElement = a[pos];

    // // Check if this element appears in current subarray
    // for (int i = 0; i < subSize; i++) {
    // if (a[startIdx + i] == firstSubElement) {
    // newCommonPositions[pos] = true;
    // break;
    // }
    // }
    // }
    // }

    // commonPositions = newCommonPositions;

    // // Early termination: if no common elements left
    // boolean hasCommon = false;
    // for (boolean b : commonPositions) {
    // if (b) {
    // hasCommon = true;
    // break;
    // }
    // }
    // if (!hasCommon)
    // return false;
    // }

    // return true;
    // }

    /*
     * To reduce complexity, a company wants to generate the smallest number of
     * least-significant digits
     * from IDs (customer ID, order ID, staff ID, etc.).
     * 
     * For example, if the original order IDs are {101, 128, 107, 105}, the
     * shortened IDs are {1, 8, 7, 5},
     * and if the original order IDs are {10183, 27, 21183, 127}, the shortened IDs
     * are {183, 27, 1183, 127}.
     * Define a function that when passed an array containing n IDs (all different),
     * returns an array containing
     * the minimum number of least-significant digits to distinctively distinguish
     * them.
     * 
     * 
     * shortenedIDs([101, 128, 107, 105]) → [1, 8, 7, 5]
     * shortenedIDs([25183, 10183]) → [5183, 183]
     * shortenedIDs([10183, 27, 25183, 127]) → [183, 27, 5183, 127]
     * 
     */
     
    // First Version
    // static int[] shortenedIDs(int[] ids) {
    //     int[] result = new int[ids.length];
    //     HashSet<Integer> seenElements = new HashSet<>();
    //     int modulo = 10;
    //     for (int i = 0; i < ids.length; i++) {
    //         result[i] = ids[i] % (modulo);
    //         if (!seenElements.add(ids[i] % (modulo))) {
    //             modulo *= 10;
    //             seenElements.clear();
    //             i = -1;
    //             continue;
    //         }
    //     }
    //     return result;
    // }

    static int[] shortenedIDs(int[] ids) {
    int maxDigits = 0;
    for (int id : ids) {
        maxDigits = Math.max(maxDigits, (int)Math.log10(id) + 1);
    }
        int reqDigits = 1;
        boolean distinct = false;
        while (!distinct) {
            distinct = allUnique(ids, reqDigits);
            if (!distinct && reqDigits <= maxDigits) {
                reqDigits++;
            }
        }

        int[] result = new int[ids.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = lastDigits(ids[i], reqDigits);
        }
        return result;
    }

    static boolean allUnique(int[] data, int d) {
        HashSet<Integer> shortenedIDs = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            if(!shortenedIDs.add(lastDigits(data[i], d))) {
                return false;
            }
        }
        return true;
    }

    static int lastDigits(int n, int d) {
        if (d <= 9) {
            int divisor = 1;
            for (int i = 0; i < d; i++) {
                divisor *= 10;
            }
            return n % divisor;
        }
        return n % (int) Math.pow(10, d);
    }

}
