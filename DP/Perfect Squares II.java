import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> minIntegerSquareSum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> rec = new ArrayList<List<Integer>>();
        
        for (int i = 0; i <= num; i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> result = new ArrayList<Integer>();
            
            for (int j = 1; j * j <= i; j++) {
                int size = rec.get(i - j * j).size();
                
                if (size < min) {
                    min = size;
                    result = new ArrayList<Integer>(rec.get(i - j * j));
                    result.add(j);
                }
            }
            
            rec.add(result);
        }
        
        Collections.sort(rec.get(num));
        
        return rec.get(num);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minIntegerSquareSum(50));
    }
}
