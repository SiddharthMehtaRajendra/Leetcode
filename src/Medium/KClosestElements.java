// https://www.youtube.com/watch?v=1otAwCQG7XM

package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
	class Solution {

		class Pair implements Comparable<Pair> {
			int value;
			int gap;

			public Pair(int value, int gap) {
				this.value = value;
				this.gap = gap;
			}

			public int compareTo(Pair o) {
				if (this.gap == o.gap) {
					return this.value - o.value;
				}
				return o.gap - this.gap;
			}
		}

		public List<Integer> findClosestElements(int[] arr, int k, int x) {
			if (arr == null || arr.length == 0)
				return Collections.emptyList();
			PriorityQueue<Pair> pq = new PriorityQueue<>();

			for (int element : arr) {
				if (pq.size() < k) {
					pq.offer(new Pair(element, Math.abs(element - x)));
				} else {
					if (pq.peek().gap > Math.abs(element - x)) {
						pq.poll();
						pq.offer(new Pair(element, Math.abs(element - x)));
					}
				}
			}

			List<Integer> result = new ArrayList<>();
			while (!pq.isEmpty()) {
				result.add(pq.poll().value);
			}
			Collections.sort(result);
			return result;
		}
	}
	
	// https://www.youtube.com/watch?v=6AackEaa0Qs
	
	class BetterSolution { //Passed 60/63 test cases on Leetcode. NOT ALL TEST CASES PASSED.
	    
	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        if(arr == null || arr.length == 0) return Collections.emptyList();
	        int mid = 0, left = 0, right = arr.length - 1;
	        
	        while(left < right){
	            mid = left + (right - left) / 2;
	            
	            if(arr[mid] == x) break;
	            
	            if(arr[mid] < x){
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        
	        left = mid - 1;
	        right = mid;
	        
	        List<Integer> result = new ArrayList<>();
	        while(left >= 0 && right < arr.length && k > 0){
	            int leftAbs = Math.abs(arr[left] - x);
	            int rightAbs = Math.abs(arr[right] - x);
	            
	            if(leftAbs <= rightAbs){
	                result.add(arr[left--]);
	            } else {
	                result.add(arr[right++]);
	            }
	            k--;
	        }
	        
	        while(k > 0 && left >= 0){
	            result.add(arr[left--]);
	            k--;
	        }
	        while(k > 0 && right < arr.length){
	            result.add(arr[right++]);
	            k--;
	        }
	        Collections.sort(result);
	        return result;
	    }
	}
}
