package Medium;

public class CountAndSay {
	class Solution {
		public String countAndSay(int n) {
			if (n == 1)
				return "1";

			String finalString = "1";
			while (n > 1) {
				StringBuilder stringInProgress = new StringBuilder("");
				int characterPointer = 0, countPointer = 0;
				while (countPointer < finalString.length()) {
					while (finalString.charAt(characterPointer) == finalString.charAt(countPointer)) {
						countPointer++;
						if (countPointer >= finalString.length())
							break;
					}
					stringInProgress.append(countPointer - characterPointer);
					stringInProgress.append(finalString.charAt(characterPointer));
					characterPointer = countPointer;
				}
				finalString = stringInProgress.toString();
				n--;
			}
			return finalString;
		}
	}
}
