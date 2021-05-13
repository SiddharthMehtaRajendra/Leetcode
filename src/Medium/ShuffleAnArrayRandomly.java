// https://www.youtube.com/watch?v=4zx5bM2OcvA

package Medium;

import java.util.LinkedList;
import java.util.List;

import java.util.Random;

public class ShuffleAnArrayRandomly {
	
	class NaiveSolution {
		private int[] array;
		private int[] original;
		private int length;

		private Random random = new Random();

		public NaiveSolution(int[] nums) {
			this.array = nums;
			this.original = nums.clone();
			this.length = nums.length;
		}

		public List<Integer> getArrayCopy() {
			List<Integer> nums = new LinkedList<>();
			for (int i = 0; i < this.array.length; i++) {
				nums.add(this.array[i]);
			}
			return nums;
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			this.array = this.original;
			this.original = this.original.clone();
			this.length = this.original.length;
			return this.array;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			List<Integer> copy = this.getArrayCopy();
			for (int i = 0; i < this.length; i++) {
				int randIndex = random.nextInt(copy.size());
				this.array[i] = copy.get(randIndex);
				copy.remove(randIndex);
			}
			return this.array;
		}
	}
	
	class ImprovedSolution {
	    
	    private int[] array;
	    private int[] original;
	    private int length;
	    
	    private Random random = new Random();
	    
	    private int getRandomIndex(int min, int max){
	        return random.nextInt(max - min) + min;
	    }
	    
	    private void swap(int i, int j){
	        int temp = this.array[i];
	        this.array[i] = this.array[j];
	        this.array[j] = temp;
	    }
	    
	    public ImprovedSolution(int[] nums) {
	        this.array = nums;
	        this.original = nums.clone();
	        this.length = nums.length;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        this.array = this.original;
	        this.original = this.original.clone();
	        this.length = this.original.length;
	        return this.array;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        for(int i= 0; i < this.length; i++){
	            int randomIndex = this.getRandomIndex(i, this.length);
	            this.swap(i, randomIndex);
	        }
	        return this.array;
	    }
	}
}
