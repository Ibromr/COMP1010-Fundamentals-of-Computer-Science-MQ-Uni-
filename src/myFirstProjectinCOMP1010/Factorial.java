package myFirstProjectinCOMP1010;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Factorial is:"+factorial(4));
		System.out.println("Factorial1 is:"+factorial1(4));

	}
	
	public static int factorial(int n) {
		
		int factor = 1;
		for (int i=1; i<=n; i++) {
			factor *= i;
		}
		return factor;
	}
	
	public static int factorial1(int n) {
		
		if(n==0) {
			return 1;
		}
		return n * factorial1(n-1);
	}

}
