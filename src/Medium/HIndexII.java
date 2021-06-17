// https://www.youtube.com/watch?v=CjKJDloMnwE

package Medium;

public class HIndexII {
	class Solution {
	    public int hIndex(int[] citations) {
	        if(citations == null || citations.length == 0) return 0;
	        int n = citations.length;
	        int low = 0, high = n - 1;
	        int mid = 0;
	        
	        while(low <= high){
	            mid = low + (high - low) / 2;
	            int curr = n - mid;
	            if(citations[mid] == curr) return citations[mid];
	            if(citations[mid] < curr) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return n - low;
	    }
	}
}
