// https://www.youtube.com/watch?v=-LNwE2E-8eE

package Medium;

import java.util.Stack;

public class DecodeString {
	class Solution {

		class Pair {
			private String str;
			private int value;

			public Pair(String str, int val) {
				this.str = str;
				this.value = val;
			}

			public void setStr(String str) {
				this.str = str;
			}

			public void setValue(int value) {
				this.value = value;
			}

			public String getStr() {
				return this.str;
			}

			public int getValue() {
				return this.value;
			}
		}

		public String decodeString(String s) {
			if (s == null || s.length() == 0)
				return "";
			Stack<Pair> st = new Stack<>();
			String num = "";

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (Character.isDigit(ch)) {
					num += ch;
				} else if (Character.isAlphabetic(ch)) {
					if (!st.isEmpty()) {
						st.peek().setStr(st.peek().getStr() + ch);
					} else {
						st.push(new Pair(String.valueOf(ch), 1));
					}
				} else if (ch == '[') {
					st.push(new Pair("", Integer.parseInt(num)));
					num = "";
				} else if (ch == ']') {
					Pair pair = st.pop();
					String temp = pair.getStr();
					StringBuilder res = new StringBuilder();
					for (int k = 0; k < pair.getValue(); k++) {
						res.append(temp);
					}
					if (!st.isEmpty()) {
						st.peek().setStr(st.peek().getStr() + res.toString());
					} else {
						st.push(new Pair(res.toString(), 1));
					}
				}
			}
			return st.peek().getStr();
		}
	}
}
