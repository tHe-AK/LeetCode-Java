class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26];
        List<String> res = new ArrayList<>();
        
        for (String str : B) {
            int[] curr = helper(str);
            
            for (int i = 0; i < count.length; i++) {
                count[i] = Math.max(count[i], curr[i]);
            }
        }
        
        for (String str : A) {
            int[] curr = helper(str);
            int i = 0;
            
            while (i < count.length) {
                if (count[i] > curr[i]) {
                    break;
                }
                
                i++;
            }
            
            if (i == count.length) {
                res.add(str);
            }
        }
        
        return res;
    }
    
    private int[] helper(String str) {
        int[] count = new int[26];
        
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        
        return count;
    }
}
