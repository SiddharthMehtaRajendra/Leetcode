package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
	class Solution {
		public List<String> topKFrequent(String[] words, int k) {
			if (words == null || words.length == 0)
				return new ArrayList<>();
			List<String> result = new ArrayList<>();
			Map<String, Integer> frequencies = new HashMap<>();

			for (String word : words) {
				frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
			}

			List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencies.entrySet());

			Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
					if (e1.getValue() == e2.getValue()) {
						return e1.getKey().compareTo(e2.getKey());
					}
					return e2.getValue().compareTo(e1.getValue());
				}
			});

			int counter = 0;
			for (Map.Entry<String, Integer> entry : sortedEntries) {
				if (counter >= k)
					break;
				result.add(entry.getKey());
				counter++;
			}
			return result;
		}
	}
}
