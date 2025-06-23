package CodingBat;

public class Conditions {
    public static void main(String[] args) {
    
      
    // Test cases
    System.out.println("median(5, 10, 15) = " + median(10000, 10, 15));
    System.out.println("getUpdatedTime(10, 20, 23, 30) = " + getUpdatedTime(10, 20, 23, 30));
  }

  /**
   * Returns the median value of three integers.
   * The median is the middle value when the three are sorted in ascending or descending order.
   * 
   * Examples:
   * median(10, 10, 10) → 10
   * median(10, 20, 10) → 10
   * median(20, 10, 10) → 10
   */
  public static int median(int a, int b, int c) {
    // The median is the middle value
    // If a is between b and c, then a is the median
    if ((b <= a && a <= c) || (c <= a && a <= b)) {
      return a;
    }
    // If b is between a and c, then b is the median
    else if ((a <= b && b <= c) || (c <= b && b <= a)) {
      return b;
    }
    // Otherwise, c is the median
    else {
      return c;
    }
  }

  public static String getUpdatedTime(int hour1, int minute1, int hoursToAdd, int minutesToAdd) {
    int updatedMinute = minute1 + minutesToAdd;
    int updatedHour = hour1 + hoursToAdd + updatedMinute/60;
    updatedHour %= 24;
    updatedMinute %= 60;
    return (updatedHour < 10 ? "0"+updatedHour : updatedHour) + ":" + (updatedMinute < 10 ? "0"+updatedMinute : updatedMinute);
  }


}
