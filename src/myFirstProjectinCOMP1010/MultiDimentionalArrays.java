package myFirstProjectinCOMP1010;

public class MultiDimentionalArrays {

	public static void main(String[] args) {
		
		int[][] data = {{},{10, 70, 20, 90}, {}};

		 

		if (data.length !=0 && data != null ) {

			for(int i=0; i<data.length; i++) {	
		
						int[] current = data[i];
						for(int k=0; k<current.length; k++){
							if(current.length != 0) {		
								System.out.print(current[k]+" ");
							}
				}
								
			}
			System.out.println();  
		}
		else {
			
		System.out.println("Data is empty or null!!!");
		} 	
		
		 
		
	/*	int[] src = {10, 70, 20, 90};
	    int[] dest = src;
	    
	    int[] a = {10, 70};
	    int[] b = {20, 90, 30};
	    int[] c = {80};

	    int[][] data = {a, b, c}; //since a, b, c are each int[]
	    

	   
	    	
	    	
	    	  for(int i=0; i < data.length; i++) {
	    	        int[] current = data[i]; //current is a reference copy of data[i]
	    	        for(int k=0; k < current.length; k++) { //I (as in Gaurav, not int i) like to use k instead of j
	    	            System.out.print(current[k]+" ");
	    	        }
	    	        System.out.println();
	    	    }
	  */  
		
		
		    
		    
		    
	

	}

}
