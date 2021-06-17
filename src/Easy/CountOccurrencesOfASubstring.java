package Easy;

public class CountOccurrencesOfASubstring {

	
	public static void main(String[] args) {
		String s1 = "abcdabdfjkosjdfababab";
		String key = "ab";
		System.out.println(countOccurrences(s1, key));
	}
	
	private static int countOccurrences(String s1, String key) {
		int len = key.length();
		int count = 0;
		for(int i = 0; i < s1.length() - len + 1; i++) {
			String substr = s1.substring(i, i + len);
			if(substr.equals(key)) {
				count++;
			}
		}
		return count;
	}
	
}
