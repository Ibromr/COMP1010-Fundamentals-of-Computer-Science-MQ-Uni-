package Assignment1Work;

public class IsAscending {
	
	 public static int[] sorted(int[] data) {
		
		  if(data == null  ) { 
				return null;
			}
			
			int[] arr= {};
			if (data.length == 0) {
				return arr;
			}
			
			for (int i = 0; i<data.length-1; i++) {
				for (int j = 0; j<data.length-i-1; j++) {
					if(data[j] > data[j+1]) {
						int temp = data[j];
						data[j] = data[j+1];
						data[j+1] = temp;
					}
					
				}
			}

			return data;
	} 


	public static void main(String[] args) {
		
		int[] data = new int[] { 43, 5, -2, 0, 29, -1, 17, 40}; // Creating an array
		
		//int[] array = new int[] { 3,12,4,67,23,14,89,5 };
		
	/*	sorted(data);
		for (int i : data) {
			System.out.print(i+"");
		}
	*/

		 
	

		
		
		//  Method 1 : Sorting Array Using the Selection Sort
	 	  		 
		for (int i = 0; i <data.length; i++){
			int	index = i;
			for (int j = i ; j < data.length; j++){
				if (data[j] < data[index]){
					index = j;
				}
			}
			int temp = data[i];
			data[i] = data[index];
			data[index] = temp;
		}  
		
		
		
		  // Method 2 : Sorting Array Using the Insertion Sort
		  
	/*	for(int i = 1; i < data.length; i++){
			int keyValue = data[i];
			int j = i - 1;
			while(j >= 0 && data[j] > keyValue){
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = keyValue;
		} 
			*/
	
		
		
		
		// Method 3: Sorting Array Using the Bubble Sort
		/*	for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
			int temp = 0;
			if (data[i] > data[j]) {
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			}
			}
			}

		 */
		
		for (int i = 0; i < data.length; i++){  // for printing only

			System.out.print(data[i] + ",");
		} 
		
	 								
	}
				
}






