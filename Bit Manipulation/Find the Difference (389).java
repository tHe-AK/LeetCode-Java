public class Solution {
    public char findTheDifference(String s, String t) {
        int len = s.length();
		char ch = t.charAt(len);
	    
		for (int i = 0; i < len; i++) {
	    	ch ^= s.charAt(i);
	    	ch ^= t.charAt(i);
		}
	    
		return ch;
    }
}
