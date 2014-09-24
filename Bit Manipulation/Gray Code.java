public class Solution {
    public List<Integer> grayCode(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < Math.pow(2, n); i++) {
            result.add(i ^ i >> 1);
        }
        
        return result;
    }
}