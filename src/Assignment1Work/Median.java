package Assignment1Work;

public class Median {

	
	public static int[] sorted(int[] data) {
		if(data == null  ) { 
			return null;
		}
		
		int[] arr= {};
		if (data.length == 0) {
			return arr;
		}
		
		

		 for (int i = 1; i < data.length; i++) {  // Sorting Array Using the Insertion Sort Method		        
 			 	int keyValue = data[i];
		        int j = i - 1;		       
		        
		        while (j >= 0 && data[j] > keyValue) {
		        	data[j + 1] = data[j];
		            j--;
		        }
		        
		        data[j + 1] = keyValue;
		 }
		    
		 return data; // Return the sorted copy 
	}
	
	public static int median(int[] data) {
		if(data == null || data.length == 0) { 
			return 0;
		}

		
		
		if(data.length%2 == 0) {
			return data[(data.length/2)-1];
			
		}
		
		
		return data[data.length/2];   //-100 is just a placeholder to satisfy the "contract", to be completed
	}
	
	public static void main(String[] args) {
		int[] data = new int[] { 43, 5, -2, 29, 17};
	
	
		sorted(data);
		

		System.out.print(median(data));

	}

}


