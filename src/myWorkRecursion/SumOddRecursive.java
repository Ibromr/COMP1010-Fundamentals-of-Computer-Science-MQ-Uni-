package myWorkRecursion;

public class SumOddRecursive {

	static int sumOddRecursive(int n) {
		  if(n<=0) {
		    return 0;
		  }
		  
		  int sum =0;
		  
		  sum += (2*n-1);
		  
		  return sum + sumOddRecursive(n-1);
		}

	
	public static void main(String[] args) {
		System.out.println("SumOddRecursive result is " + sumOddRecursive(5));

	}

}
