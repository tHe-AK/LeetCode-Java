public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        
    	for (int i = len / 2; i >= 1; i--) {
    		if (len % i == 0) {
    			int count = len / i;
    			String str = s.substring(0, i);
    			StringBuilder sb = new StringBuilder();
    			
    			for (int j = 0; j < count; j++) {
        			sb.append(str);
    			}
    			
    			if (sb.toString().equals(str)) {
    			    return true;
    			}
    		}
    	}
    	
    	return false;
    }
}
