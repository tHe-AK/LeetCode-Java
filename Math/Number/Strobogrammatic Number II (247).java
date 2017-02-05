public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }
    
    private List<String> findStrobogrammatic(int n, int m) {
        if (m == 0) {
            return Arrays.asList("");
        }
        
        if (m == 1) {
            return Arrays.asList("0", "1", "8");
        }
        
        List<String> result = new ArrayList<String>();
        List<String> list = findStrobogrammatic(n, m - 2);
        
        for (String str : list) {
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
