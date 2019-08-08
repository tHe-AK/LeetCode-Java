class Solution {
    public int shortestWay(String source, String target) {
        int i = 0;
        int count = 0;
        
        while (i < target.length()) {
            int start = i;
            int j = 0;
            
            while (i < target.length() && j < source.length()) {
                if (target.charAt(i) == source.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            
            if (i == start) {
                return -1;
            }
            
            count++;
        }
        
        return count;
    }
}
