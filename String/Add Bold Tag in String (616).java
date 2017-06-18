public class Solution {
	public String addBoldTag(String s, String[] dict) {
		int len = s.length();
		
		boolean[] bold = new boolean[len];
		
		for (String word : dict) {
			int size = word.length();
				
			if (size > 0) {
				for (int i = 0; i < len - size + 1; i++) {
					if (s.startsWith(word, i)) {
						for (int j = i; j < i + size; j++) {
							bold[j] = true;
						}
					}
				}
			}
		}
		
		StringBuilder res = new StringBuilder();
		int i = 0;
		
		while (i < len) {
			if (bold[i]) {
				res.append("<b>");
				
				while (i < len && bold[i]) {
					res.append(s.charAt(i++));
				}
				
				res.append("</b>");
			} else {
				res.append(s.charAt(i++));
			}
		}
		
		return res.toString();
	}
