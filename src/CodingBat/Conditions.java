package CodingBat;

public class Conditions {
    public static void main(String[] args) {
    
      
    // Test cases
    System.out.println("median(5, 10, 15) = " + median(10000, 10, 15));
    System.out.println("median(10, 10, 15) = " + median(10, 10, 5));
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

  String getUpdatedTime(int hour1, int minute1, int hoursToAdd, int minutesToAdd) {
  int updatedHour = hour1;
  int updatedMinute = minute1;
  
  if(hoursToAdd > 0) {
    updatedHour = hoursUpdating(updatedHour, hoursToAdd);
  }
  
  while(minutesToAdd > 0){         
    int temp = 0;         
    temp = 60 - updatedMinute;    
    if(temp > 0 ){
      minutesToAdd -= temp;       
      updatedMinute += temp;
      
      if(updatedMinute > 59) {
        minutesToAdd += updatedMinute - 59;
        updatedHour += 1;
        updatedMinute = 0;
        
        if(updatedHour > 23) {
          updatedHour = 0; 
        }
      }
    }
  } 
  
  if(updatedHour == 0) {
     return "00" + ":" + (updatedMinute == 0 ? "00" : updatedMinute);
  }

  return updatedHour+":"+updatedMinute;
}

int hoursUpdating(int updatedHour, int hoursToAdd) {
  while(hoursToAdd > 0){         
    int temp = 0;         
    temp = 24 - updatedHour;    
    if(temp > 0 ){
      hoursToAdd -= temp;       
      updatedHour += temp;
      
      if(updatedHour > 23) {
        hoursToAdd += updatedHour - 23;
        updatedHour = 0;
      }
    }
  } 
  return updatedHour;
}



}
