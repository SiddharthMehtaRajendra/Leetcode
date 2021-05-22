package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap {
	class MyHashMap {

	    class Pair<K,V>{
	        K key;
	        V value;
	        
	        public Pair(K key, V value){
	            this.key = key;
	            this.value = value;
	        }
	        
	        public void setKey(K key){
	            this.key = key;
	        }
	        
	        public void setValue(V value){
	            this.value = value;
	        }
	        
	        public K getKey(){
	            return this.key;
	        }
	        
	        public V getValue(){
	            return this.value;
	        }
	    }
	    
	    class Bucket{
	        List<Pair<Integer, Integer>> list;
	        
	        public Bucket(){
	            this.list = new LinkedList<>();
	        }
	        
	        public void update(int key, int value){
	            boolean found = false;
	            for(Pair<Integer, Integer> pair: this.list){
	                if(pair.getKey().equals(key)){
	                    pair.setValue(value);
	                    found = true;
	                    break;
	                }
	            }
	            if(!found){
	                this.list.add(new Pair(key, value));
	            }
	        }
	        
	        public int get(int key){
	            for(Pair<Integer, Integer> pair: this.list){
	                if(pair.getKey().equals(key)){
	                    return pair.getValue();
	                }
	            }
	            return -1;
	        }
	        
	        public void delete(int key){
	            for(Pair<Integer, Integer> pair: this.list){
	                if(pair.getKey().equals(key)){
	                    this.list.remove(pair);
	                    break;
	                }
	            }
	        }
	    }
	    
	    private int keySpace;
	    private List<Bucket> hashTable;
	    /** Initialize your data structure here. */
	    public MyHashMap() {
	        this.keySpace = 1000;
	        this.hashTable = new ArrayList<>();
	        for(int i = 0; i < this.keySpace; i++){
	            this.hashTable.add(new Bucket());
	        }
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        int hash = this.performHashing(key);
	        this.hashTable.get(hash).update(key, value);
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int hash = this.performHashing(key);
	        return this.hashTable.get(hash).get(key);
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int hash = this.performHashing(key);
	        this.hashTable.get(hash).delete(key);
	    }
	    
	    public int performHashing(int key){
	        return key % this.keySpace;
	    }
	}
}
