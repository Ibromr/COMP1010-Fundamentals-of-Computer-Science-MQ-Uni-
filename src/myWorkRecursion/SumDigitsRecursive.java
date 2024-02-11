package myWorkRecursion;

public class SumDigitsRecursive {

	static int sumDigitsRecursive(int n) {
		  if(n==0){   // Base case
		    return 0;
		  }
		  
		  int sum = 0;
			 if (n<0) {
			    sum += (-n%10);
			 } 
			 else {
			    sum += (n%10);
			 }
			  int leftDigits = n/10;
			  return sum + sumDigitsRecursive(leftDigits);
		}
	
	public static void main(String[] args) {
		System.out.println("sumDigitsRecursive result is " + sumDigitsRecursive(888));

	}

}
