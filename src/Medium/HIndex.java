// https://www.youtube.com/watch?v=CjKJDloMnwE and S30

package Medium;

import java.util.Arrays;

public class HIndex {
	
	// Naive Solution
	class Solution {
	    public int hIndex(int[] citations) {
	        if(citations == null || citations.length == 0) return 0;
	        int n = citations.length;
	        Arrays.sort(citations);
	        
	        for(int i = 0; i < n; i++){
	            if(citations[i] >= (n - i)) return (n - i);
	        }
	        return 0;
	    }
	} 
	
	// https://www.youtube.com/watch?v=CjKJDloMnwE
	class BetterSolution {
	    public int hIndex(int[] citations) {
	        if(citations == null || citations.length == 0) return 0;
	        int n = citations.length;
	        Arrays.sort(citations);
	        int low = 0, mid = 0, high = citations.length - 1;
	        
	        while(low <= high){
	            mid = low + (high - low) / 2;
	            int curr = n - mid;
	            if(citations[mid] == curr) return citations[mid];
	            else if(citations[mid] < curr){
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return n - low;
	    }
	} 
}
