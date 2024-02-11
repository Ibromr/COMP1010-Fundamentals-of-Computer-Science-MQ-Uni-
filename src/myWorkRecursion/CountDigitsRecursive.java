package myWorkRecursion;

import java.lang.Math;

public class CountDigitsRecursive {

	
	static int countDigitsRecursive(int n) {
		  if(n==0){   // Base case
		    return 0;
		  }
		  
		  int count = 0; 
		  int lastDigits = n/10;
		  
		  count = count + 1 + countDigitsRecursive(lastDigits);
		  
		  return count;
		}
	
	
	public static void main(String[] args) {
		System.out.println("countLastDigitsRecursive result is " + countDigitsRecursive(1729));
		
	}
	
	

}
