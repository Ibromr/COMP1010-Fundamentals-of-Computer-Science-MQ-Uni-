package Assignment1Work;

public class MostCommonItem {

	
	public static int mostFrequent(int[] data) {
	
	    // code here
		if(data == null || data.length == 0 ) {			//If data is null or data length is 0.

			return 0;		
		}
		
	    int maxCount = 0;
	    int commonElement = 0;
	    for (int i = 0; i <data.length; i++) {
	        int count = 0;	//  should be 1?
	        for (int j = 0; j<data.length; j++) {
	            if (data[i] == data[j])
	                count++;
	        }
	  
	        if (count > maxCount ) {
	        	maxCount = count;
	        	commonElement = data[i];
	        }
	    }
	  
	    return commonElement;
	}
	
	
	/* 
	 * int maxCount = 0;
    int elementHavingMaxFreq = 0;

    for (int i = 0; i < data.length; i++) {
        int count = 0;

        for (int j = 0; j < data.length; j++) {
            if (data[i] == data[j])
                count++;
        }

        if (count > maxCount || (count == maxCount && data[i] < elementHavingMaxFreq)) {
            maxCount = count;
            elementHavingMaxFreq = data[i];
        }
    }

    return elementHavingMaxFreq;
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		int[] data = {60, 10, 40, 10, -1, -1, -1, 60, 20, 10, 90};
		
		
		int mFre = mostFrequent(data);
		System.out.println(mFre);
		
	}

}
