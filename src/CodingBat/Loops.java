package CodingBat;

public class Loops {
  public static void main(String[] args) {
    System.out.println("primeCombination(893) = " + primeCombination(893));
    System.out.println(nearlyPrime(77));
    System.out.println("Hello");
  }

  /*
   * 
    Solve this problem first: "sumPrimes" Define a function that when passed an integer, 
    returns true if it can be split in a way that the left and right parts are both prime, false otherwise.

    For example, you can split 7313 right down the middle and the left part - 73, and the right part 13, 
    are both primes. BTW, you can also split it after the 7 so that both 7 and 313 are prime.

    Similarly, 893 split after the 9 results in primes on either side - 89 and 3.

    However, 277 cannot be split in a way that the left and right parts are prime.


    primeCombination(277) → false
    primeCombination(893) → true
    primeCombination(7313) → true
   */
  static boolean primeCombination(int n) {
    if (n < 100) {
        return false;
    }
    
    int divisor = 10;
    int temp = n;
    
    // Iterate through possible divisions
    while (temp / 10 > 0) {
        int left = n / divisor;
        int right = n % divisor;
        
        if (isPrime(left) && isPrime(right)) {
            return true;
        }
        
        divisor *= 10;
        temp /= 10;
    }
    
    return false;
  }

  /*
   * First, solve the problem at isPrime and then come to this one.
   * A number is called "nearly-prime" if besides, 1 and itself, it's
   * divisible by exactly one other integer.
   * Define a function that when passed an integer, returns true
   * if it is nearly-prime, false otherwise.
   * 
   * nearlyPrime(77) → false
   * nearlyPrime(32) → false
   * nearlyPrime(62710561) → true
   */
  static boolean nearlyPrime(int n) {
    if (n < 2) {
      return false;
    }

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return n == i * i;
      }
    }
    return false;
  }
  /*
   * WHY THIS IS NOT GOOD SOLUTION!
   * 
   * NOTE:
   * Using modulo operations with doubles (from Math.sqrt())
   * can cause precision problems, and simply checking if a number
   * is a perfect square is incomplete - we need to verify it's
   * a perfect square of a prime number to ensure exactly three divisors.
   * 
   * DO NOT USE THIS:
   * boolean nearlyPrime(int n) {
   * if (isPrime(n)) { return false;}
   * if(n % Math.sqrt(n) == 0 ) { return true; }
   * 
   * return false;
   * }
   */

  /*
   * Solve this problem first: isPrime()
   * Define a function that when passed an integer,
   * returns the sum of all prime numbers from 2 to that integer
   * (inclusive on both sides).
   * 
   * 
   * sumPrimes(10) → 17
   * sumPrimes(20) → 77
   * sumPrimes(100) → 1060
   */
  static int sumPrimes(int n) {
    if (n < 2) {
      return 0;
    }
    int sum = 2; // Starting with 2 (first prime)

    // Loop through numbers from 3 to n
    for (int i = 3; i <= n; i++) {
      // Only check odd numbers (even numbers > 2 can't be prime)
      if (i % 2 != 0) {
        // Add to sum if prime
        if (isPrime(i)) {
          sum += i;
        }
      }
    }
    return sum;
  }

  /*
   * Define a function that when passed an integer,
   * returns the single-digit sum of its digits.
   * For example, if n = 999999997, the sum of the
   * digits is 79, but since its not a single-digit number,
   * we compute the sum of its digits, which is 16.
   * It's still not a single-digit number, so we repeat
   * the process, finally yielding 7.
   * 
   * 
   * singleDigitSum(999999997) → 7
   * singleDigitSum(39) → 3
   * singleDigitSum(100) → 1
   */
  static int singleDigitSum(int n) {
    // Handle negative numbers
    n = Math.abs(n);
    // If n is 0, return 0
    if (n == 0)
      return 0;
    // Keep calculating sum until we get a single digit
    while (n > 9) {
      int sum = 0;
      while (n > 0) {
        sum += n % 10;
        n /= 10;
      }
      n = sum;
    }
    return n;
  }
  // Efficient with mathematical formula
  // int singleDigitSum(int n) {
  // // Handle negative numbers
  // n = Math.abs(n);
  // // If n is 0, return 0
  // if (n == 0) return 0;
  // // Mathematical formula for digital root (If you use this you do not need
  // // While loop)
  // if (n % 9 == 0) return 9;
  // return n & 9;
  // }

  /*
   * Collatz number is defined as the number of steps it
   * takes to reduce a number to 1 using the following
   * steps: 1. if the number is even, divide it be 2. 2.
   * if the number is odd, multiply it by 3 and add 1 to it.
   * Define a function that when passed an integer, returns
   * its collatz number. You may assume the number is 1 or more.
   * 
   * 
   * collatz(1) → 0
   * collatz(20) → 7
   * collatz(100) → 25
   */
  static int collatz(int n) {
    int steps = 0;
    while (n > 1) {
      if (n % 2 == 0) {
        n = n / 2;
        steps++;
      } else {
        n = n * 3 + 1;
        steps++;
      }
    }
    return steps;
  }

  // Multiply WITHOUT using *
  static int multiply(int a, int b) {
    int product = b;
    while (a > 1) {
      product += b;
      a--;
    }
    return product;
  }

  /*
   * A number is called prime if it is more than 1,
   * and is divisible only by 1 and itself. Define a
   * function that when passed an integer, returns true
   * if it is prime, false otherwise. If you are not sure
   * where to begin, just search on wikipedia
   * (yes, wikipedia is awesome!) for "prime numbers".
   * 
   * 
   * isPrime(77) → false
   * isPrime(73) → true
   * isPrime(103) → true
   */
  static boolean isPrime(int n) {
    if (n < 2 || n % 2 == 0){
      return false;
    }
    int i = 3;
    while (i * i <= n) {
      if (n % i == 0) {
        return false;
      }
      i += 2;
    }
    return true;
  }

}
