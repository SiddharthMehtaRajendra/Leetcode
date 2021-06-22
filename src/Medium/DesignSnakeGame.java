package Medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame {
	class SnakeGame {
	    
	    class Pair{
	        private Integer row;
	        private Integer column;
	        
	        public Pair(Integer row, Integer column){
	            this.row = row;
	            this.column = column;
	        }
	        
	        public Integer getRow(){
	            return this.row;
	        }
	        
	        public Integer getColumn(){
	            return this.column;
	        }
	        
	        public boolean equals(Object o){
	            if(this == o) return true;
	            Pair pair = (Pair) o;
	            
	            if(this.getRow().equals(pair.getRow())
	               && this.getColumn().equals(pair.getColumn())){
	                return true;
	            }
	            return false;
	        }
	        
	        public int hashCode(){
	            return this.getRow().hashCode() + this.getColumn().hashCode() + 31;
	        }
	    }

	    private Set<Pair> dictionary;
	    private Deque<Pair> snake;
	    private int[][] food;
	    private int foodIndex;
	    private int width;
	    private int height;
	    
	    /** Initialize your data structure here.
	        @param width - screen width
	        @param height - screen height 
	        @param food - A list of food positions
	        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	    public SnakeGame(int width, int height, int[][] food) {
	        this.dictionary = new HashSet<>();
	        this.snake = new LinkedList<>();
	        this.food = food;
	        this.height = height;
	        this.width = width;
	        this.foodIndex = 0;
	        this.snake.offerLast(new Pair(0, 0));
	        this.dictionary.add(new Pair(0, 0));
	    }
	    
	    /** Moves the snake.
	        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	        @return The game's score after the move. Return -1 if game over. 
	        Game over when snake crosses the screen boundary or bites its body. */
	    public int move(String direction) {
	        Pair currentHead = this.snake.peekFirst();
	        int newRow = currentHead.getRow();
	        int newColumn = currentHead.getColumn();

	        switch(direction){
	            case "U":
	                newRow--;
	                break;
	            case "R":
	                newColumn++;
	                break;
	            case "D":
	                newRow++;
	                break;
	            case "L":
	                newColumn--;
	                break;
	        }
	        
	        Pair newHead = new Pair(newRow, newColumn);
	        Pair currentTail = this.snake.peekLast();
	    
	        boolean hasCrashed1 = (newRow < 0 || newRow >= this.height);
	        boolean hasCrashed2 = (newColumn < 0 || newColumn >= this.width);
	        
	        boolean isBitten = this.dictionary.contains(newHead) && !(newRow == currentTail.getRow() && newColumn == currentTail.getColumn());
	        
	        if(hasCrashed1 || hasCrashed2 || isBitten) return -1;
	        
	        if(this.foodIndex < this.food.length
	            && (this.food[this.foodIndex][0] == newRow)
	              && (this.food[this.foodIndex][1] == newColumn)){
	            this.foodIndex++;
	        } else {
	            this.snake.pollLast();
	            this.dictionary.remove(currentTail);
	        }
	        this.snake.addFirst(newHead);
	        this.dictionary.add(newHead);
	        
	        return this.snake.size() - 1;
	    }
	}

	/**
	 * Your SnakeGame object will be instantiated and called as such:
	 * SnakeGame obj = new SnakeGame(width, height, food);
	 * int param_1 = obj.move(direction);
	 */
}
