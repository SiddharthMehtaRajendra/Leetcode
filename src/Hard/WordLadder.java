package Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        Set<String> set = new HashSet<>(wordList);
	        if(!set.contains(endWord)) return 0;
	        
	        Queue<String> queue = new LinkedList<>();
	        queue.offer(beginWord);
	        int level = 1;
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i = 0; i < size; i++){
	                String currentWord = queue.poll();
	                char[] currentWordChars = currentWord.toCharArray();
	                for(int j = 0; j < currentWordChars.length; j++){
	                    char original = currentWordChars[j];
	                    for(char k = 'a'; k <= 'z'; k++){
	                        if(currentWordChars[j] == k) continue;
	                        currentWordChars[j] = k;
	                        String word = String.valueOf(currentWordChars);
	                        if(word.equals(endWord)) return level + 1;
	                        if(set.contains(word)){
	                            queue.offer(word);
	                            set.remove(word);
	                        }
	                    }
	                    currentWordChars[j] = original;
	                }
	            }
	            level++;
	        }
	        return 0;
	    }
	}
}
