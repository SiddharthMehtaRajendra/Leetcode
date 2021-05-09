package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	
	class NonOptimizedMedianFinder {
	    private List<Integer> list;
	    
	    /** initialize your data structure here. */
	    public NonOptimizedMedianFinder() {
	        this.list = new ArrayList<>();
	    }
	    
	    public void addNum(int num) {
	        list.add(num);
	        Collections.sort(list);
	    }
	    
	    public double findMedian() {
	        int n = list.size();
	        if(n % 2 == 0){
	            int indexOne = (n/2) - 1;
	            int indexTwo = (n/2);
	            int elementOne = list.get(indexOne);
	            int elementTwo = list.get(indexTwo);
	            return (double) (elementOne + elementTwo) / 2;
	        } else {
	            int index = (n/2);
	            return list.get(index);
	        }
	    }
	}


	
	class OptimizedMedianFinder {
		private PriorityQueue<Integer> smallNumbers;
		private PriorityQueue<Integer> largeNumbers;

		/** initialize your data structure here. */
		public OptimizedMedianFinder() {
			this.smallNumbers = new PriorityQueue<>((a, b) -> (b - a)); // Max Heap
			this.largeNumbers = new PriorityQueue<>((a, b) -> (a - b)); // Min Heap
		}

		public void addNum(int num) {
			smallNumbers.offer(num);

			if (!largeNumbers.isEmpty() && smallNumbers.peek() > largeNumbers.peek()) {
				int element = smallNumbers.poll();
				largeNumbers.offer(element);
			}

			if (largeNumbers.size() > smallNumbers.size() + 1) {
				int element = largeNumbers.poll();
				smallNumbers.offer(element);
			} else if (smallNumbers.size() > largeNumbers.size() + 1) {
				int element = smallNumbers.poll();
				largeNumbers.offer(element);
			}
		}

		public double findMedian() {
			if (smallNumbers.size() > largeNumbers.size()) {
				return smallNumbers.peek();
			} else if (largeNumbers.size() > smallNumbers.size()) {
				return largeNumbers.peek();
			} else {
				int elementSmall = smallNumbers.peek();
				int elementLarge = largeNumbers.peek();
				return (double) (elementSmall + elementLarge) / 2;
			}
		}
	}
}
