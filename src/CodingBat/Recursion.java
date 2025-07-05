package CodingBat;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("fibonacci(10) → Expected:55  Run:" + fibonacci(10));
        System.out.println("fibonacci(10) → Expected:81  Run:" + tribonacci(10));
        System.out.println("commonDigit(12345, 54321) Expected:true  Run:" + commonDigit(12345, 54321));
        System.out.println("binarySearch([10, 20, 20, 20, 20, 70, 90], 70) Expected:5  Run:"
                + binarySearch(new int[] { 10, 20, 20, 20, 20, 70, 90 }, 70));
        System.out.println("areAnagrams('hi', 'hi!') → Expected:false  Run:" + areAnagrams("hi", "hi!"));
        System.out.println("addSubtractUpTo([10, 70, 20, 90], 170, 0) → Expected:true  Run:"
                + addSubtractUpTo(new int[] { 10, 70, 20, 90 }, 170, 0));
        System.out.println("diffDates1(1, 1, 19, 11) → Expected:322  Run:" + diffDates1(1, 1, 19, 11));
    }

    /*
     * Fibonacci sequence and Fibonacci numbers are extremely famous.
     * The sequence begins with 0, 1 and each subsequent number is the sum
     * of the two numbers before it.
     * Thus fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2).
     * 
     * Define a function that when passed an integer, returns the Fibonacci
     * number at that index.
     * 
     * Note: the difficulty is in solving this problem such that you DON'T
     * call the function two times (during each call).
     * 
     * You will most likely need to add a helper function.
     * 
     * 
     * fibonacci(0) → 0
     * fibonacci(10) → 55
     * fibonacci(20) → 6765
     */

    static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        int result = helperFib(0, 1, n);
        return result;
    }

    static int helperFib(int a, int b, int stepsLeft) {
        if (stepsLeft <= 0) {
            return a;
        }

        return helperFib(a + b, a, stepsLeft - 1);
    }

    /*
     * Fibonacci sequence and Fibonacci numbers are extremely famous.
     * The sequence begins with 0, 1 and each subsequent number is
     * the sum of the two numbers before it.
     * Thus fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2).
     * On the lines of Fibonacci numbers, we will define a Tribonacci
     * sequence as one that starts with 0, 0, 1 and each subsequent
     * number is the sum of the three numbers before it.
     * Thus, tri(0) = 0, tri(1) = 0, tri(2) = 1, tri(n) = well, you know...
     * Define a function that when passed an integer, returns
     * the Tribonacci number at that index. Note: the difficulty is
     * in solving this problem such that you DON'T call the function
     * three times (during each call).
     * 
     * 
     * tribonacci(0) → 0
     * tribonacci(10) → 81
     * tribonacci(20) → 35890
     */

    static int tribonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = helperTri(0, 0, 1, n);
        return result;
    }

    static int helperTri(int a, int b, int c, int stepsLeft) {
        if (stepsLeft <= 1) {
            return a;
        }
        return helperTri(a + b + c, a, b, stepsLeft - 1);
    }

    /*
     * Define a function that when passed two integers,
     * returns true if they have any digit in common, false otherwise.
     * Note: Zero by itself does not contain any digit. So return false
     * if either value is 0.
     * 
     * commonDigit(1729, 234) → true
     * commonDigit(12345, 54321) → true
     * commonDigit(12345, 67890) → false
     * 
     * Sample:
     * boolean commonDigit(int a, int b) { // Very concise
     * if (a == 0 || b == 0) {
     * return false;
     * }
     * 
     * if(a%10 == b%10) {
     * return true;
     * }
     * 
     * if(commonDigit(a, b/10)) {
     * return true;
     * }
     * 
     * return commonDigit(a/10, b);
     * 
     * }
     */

    static boolean commonDigit(int a, int b) {
        if (a == 0) {
            return false;
        }

        int tempA = a;
        int tempB = b;
        if (isCommon(tempA, tempB)) {
            return true;
        }

        return commonDigit(a / 10, b);
    }

    static boolean isCommon(int tempA, int tempB) {
        if (tempB == 0) {
            return false;
        }
        if (tempA % 10 == tempB % 10) {
            return true;
        } else {
            return isCommon(tempA, tempB / 10);
        }
    }

    /*
     * Define a function that when passed an integer array sorted in ascending
     * order,
     * and another integer, performs binary search to return an index, any index,
     * at which the item exists in the array. Return -1 if the item does not exist
     * in the array.
     * Google "binary search" to see the algorithm.
     * 
     * 
     * binarySearch([10, 20, 20, 20, 20, 70, 90], 10) → 0
     * binarySearch([10, 20, 20, 20, 20, 70, 90], 20) → 3
     * binarySearch([10, 20, 20, 20, 20, 70, 90], 70) → 5
     */
    static int binarySearch(int[] a, int val) {
        return binarySearch(a, val, 0, a.length - 1);
    }

    static int binarySearch(int[] a, int val, int first, int last) {
        if (first > last) {
            return -1;
        }
        int mid = (first + last) / 2;
        if (a[mid] == val) {
            return mid;
        }

        if (a[mid] > val) {
            return binarySearch(a, val, first, mid - 1);
        } else {
            return binarySearch(a, val, mid + 1, last);
        }
    }

    /*
     * Define a function that when passed two Strings,
     * returns true if they are anagrams of one another.
     * 
     * 
     * areAnagrams("hello!", "olel!h") → true
     * areAnagrams("", "") → true
     * areAnagrams("superman", "supremAn") → false
     */
    static boolean areAnagrams(String a, String b) {
        if (a.length() == 0 && b.length() == 0) {
            return true;
        }

        if (a.length() <= 0 || b.length() <= 0) {
            return false;
        }

        if (a.charAt(0) == b.charAt(0)) {
            return areAnagrams(a.substring(1, a.length()), b.substring(1, b.length()));
        }

        if (a.charAt(0) != b.charAt(0)) {
            int deletion = helpAnagrams(a, b, -1);
            if (deletion >= b.length()) {
                return areAnagrams(a.substring(1, a.length()), b.substring(0, deletion));
            }
            if (deletion > 0) {
                return areAnagrams(a.substring(1, a.length()),
                        b.substring(0, deletion) + b.substring(deletion + 1, b.length()));
            }

            if (deletion == -1) {
                return false;
            }
        }

        return false;
    }

    static int helpAnagrams(String a, String b, int deletion) {
        if (b.length() <= 0) {
            return -1;
        }

        if (a.charAt(0) == b.charAt(0)) {
            deletion++;
            return deletion;
        }

        else if (a.charAt(0) != b.charAt(0)) {
            deletion++;
            return helpAnagrams(a, b.substring(1), deletion);
        }

        return deletion;
    }
    /*
     * ACTUALLY THERE IS MUCH EASIER OPTION THAN MINE:
     * boolean areAnagrams(String a, String b) {
     * if(a.isEmpty() && b.isEmpty()) {
     * return true;
     * }
     * if(a.length() != b.length()) {
     * return false;
     * }
     * int idx = b.indexOf(a.charAt(0));
     * if(idx < 0) {
     * return false;
     * }
     * return areAnagrams(a.substring(1), b.substring(0, idx) + b.substring(idx+1));
     * }
     * 
     */

    /*
     * Define a function that when passed an array, an integer (say target),
     * and another integer (say idx), returns true if zero or more items
     * in the array, starting at index idx, can be added or subtracted
     * to construct target, false otherwise.
     * 
     * 
     * addSubtractUpTo([], 100, 0) → false
     * addSubtractUpTo([10, 70, 20, 90], 10, 4) → false
     * addSubtractUpTo([10, 70, 20, 90], 170, 0) → true
     * 
     */
    static boolean addSubtractUpTo(int[] data, int target, int idx) {
        if (idx >= data.length) {
            return target == 0;
        }

        if (target == 0) {
            return true;
        }

        return addSubtractUpTo(data, target + data[idx], idx + 1)
                || addSubtractUpTo(data, target - data[idx], idx + 1);
    }
    /*
     * THIS IS MY FIRST ATTEMPT
     * boolean addSubtractUpTo(int[] data, int target, int idx) {
     * if (data.length == 0 || idx >= data.length) {
     * return false;
     * }
     * 
     * if (target == 0) {
     * return true;
     * }
     * 
     * return help(data, target + data[idx], idx + 1)
     * || help(data, target - data[idx], idx + 1);
     * }
     * 
     * boolean help(int[] data, int target, int idx) {
     * if (target == 0) {
     * return true;
     * }
     * 
     * if (idx >= data.length) {
     * return false;
     * }
     * 
     * return help(data, target + data[idx], idx + 1)
     * || help(data, target - data[idx], idx + 1);
     * }
     * 
     */

    /*
     * 
     * Define a recursive function that when passed two dates in the same year
     * (assume non-leap year), returns the difference (in days) between the two.
     * For example, there is a two-day difference between 13/04/2011 and 15/04/2011.
     * You may not use any loops. You may create helper functions if needed.
     * 
     * 
     * diffDates1(25, 7, 17, 8) → 23
     * diffDates1(15, 7, 31, 12) → 169
     * diffDates1(1, 1, 19, 11) → 322
     */
    static int diffDates1(int day1, int month1, int day2, int month2) {
        if (month1 > month2) {
            return diffDates1(day2, month2, day1, month1);
        }
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month1 == month2) {
            return Math.abs(day2 - day1);
        }

        if (month2 == month1 + 1 && day2 < day1) {
            return days[month1] - day1 + day2;
        }

        return days[month1] + diffDates1(day1, month1 + 1, day2, month2);
    }
    /*
     * static int diffDates1(int day1, int month1, int day2, int month2) {
     * int[] months = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
     * };
     * if(month1 > month2) {
     * int temp = month1;
     * month1 = month2;
     * month2 = temp;
     * temp = day1;
     * day1 = day2;
     * day2 = temp;
     * }
     * if(month1 == month2 && day1 > day2) {
     * int temp = day1;
     * day1 = day2;
     * day2 = temp;
     * }
     * int totalDays = day2 - day1;
     * 
     * if (month2 == month1) {
     * return totalDays;
     * }
     * 
     * totalDays = months[month1] - day1 + day2;
     * month1++;
     * if (month2 == month1) {
     * return totalDays;
     * }
     * 
     * totalDays = helpDiffDates1(month1, month2-1, totalDays);
     * 
     * return totalDays;
     * 
     * }
     * 
     * static int helpDiffDates1(int month1, int month2, int totalDays) {
     * int[] months = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
     * };
     * 
     * if (month2 == month1) {
     * return totalDays+months[month1];
     * }
     * 
     * return helpDiffDates1(month1+1, month2, totalDays + months[month1]);
     * }
     */
}
