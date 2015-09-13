import java.util.*;
import java.io.*;

class Solution {
    public int taskTime(int[] task, int N){
        if (task == null || N <= 0) {
            throw new IllegalArgumentException();
        }
        
        int count = 0;
        Map<Integer, Integer> rec = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < task.length; i++) {
            int key = task[i];
            
            if (rec.containsKey(key)) {
                int val = rec.get(key);
                
                if (count - val > N) {
                    rec.put(key, val + 1);
                    count++;
                } else {
                    count = val + N + 1;
                    rec.put(key, count);
                    count++;
                }
            } else {
                rec.put(key, count);
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.taskTime(new int[] {1, 2, 1, 2, 3}, 2));
    }
}
