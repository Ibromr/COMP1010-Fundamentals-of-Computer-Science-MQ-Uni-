package CodingBat;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("fibonacci(10) → expected:55  Run:" + fibonacci(10));
        System.out.println("fibonacci(10) → expected:81  Run:" + tribonacci(10));
        System.out.println("commonDigit(12345, 54321) → expected:true  Run:" + commonDigit(12345, 54321));
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
     * boolean commonDigit(int a, int b) {  // Very concise
        if (a == 0 || b == 0) {
            return false;
        }
        
        if(a%10 == b%10) {
            return true;
        }
        
        if(commonDigit(a, b/10)) {
            return true;
        }
        
        return commonDigit(a/10, b);
        
       }
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

        return commonDigit(a/10, b);
    }

    static boolean isCommon(int tempA, int tempB) {
        if (tempB == 0) {
            return false;
        }
        if (tempA % 10 == tempB % 10) {
            return true;
        } else {
            return isCommon(tempA, tempB/10);
        }
    }

}
