public class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        List<String> result = new ArrayList<String>();
        
        if (n == 0) {
            result.add("");
            return result;
        }
        
        if (n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }
        
        List<String> cur = helper(n - 2, m);
        
        for (String str : cur) {
            if (n != m) {
                result.add("0" + str + "0");
            }
            
            result.add("1" + str + "1");
            result.add("8" + str + "8");
            result.add("6" + str + "9");
            result.add("9" + str + "6");
        }
        
        return result;
    }
}
