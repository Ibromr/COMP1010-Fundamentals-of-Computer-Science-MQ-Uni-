package CodingBat;

/*
 * Define a function that when passed two integers (say a, b), 
 * returns true if they have any digit in common, false otherwise. 
 * 
 * Note: you should return false if either number is 0, because 0 by itself, contains no digit.


commonDigit(1729, 861350) → true
commonDigit(17, 29) → false
commonDigit(172, 91) → true
 */
public class CommonDigit {
    public static void main(String[] args) {
        System.out.println(commonDigit(172, 91));
        System.out.println("Hello");
    }
    static boolean commonDigit(int a, int b) {
      if (a == 0 || b == 0) {
        return false;
      }
      boolean[] seen = new boolean[10];
      
      while (a > 0) {
        seen[a % 10] = true;
        a = a / 10;
      }
      
      while (b > 0) {
        if(seen[b % 10]) {
          return true;
        }
          b = b / 10;
      }
      return false;
    }
}
