package myFirstProjectinCOMP1010;

public class HelloWorld {

	public static void main(String[] args) {
		/*System.out.println("My First Java Program!");
		System.out.println("Cube of -5 is "+Cube(-5));
		System.out.println(9%10);
		System.out.println("Left yeet: " +lopi(2));  // harder than on the top loop and calculation how much left
		System.out.println("Your nesting : " +nesting(4));  // harder than on the top loop and calculation how much left
		*/
		int[] data = {1, 10, 45, 87, -5, -15, 105};
		System.out.println("index number is : " +indexOf(data, 0));
		
	}


	public static int Cube(int n) {
		int result =n*n*n;
		return result;
	}
	
	public static int lopi(int yeet) {
		for(int i=1; i < 50; i*=4) {
			for(int k=10; k>i; k-=5) { //READ CAREFULLY
				yeet--;
			} 
		}
		return yeet;
	}
	
	public static String nesting(int n) {
		String sum= " ";
		for (int i=1; i<=n; i++) {
			for(int k=1; k<=i; k++) {
			sum+="$";
			}
			if (i<n) {
				sum+=".";
			}
		}
		return sum;
	}
	
	public static int indexOf(int[] data, int target) {
		
		if(data == null || data.length == 0 ) { //if data is null or empty.
				return -2;
		}
			
			
			for(int i=0; i <data.length; i++) {
				if(data[i] == target) {
					
					return i;
				}
				
			}
			
			
		return -1; 
	}
	
	
	
}
