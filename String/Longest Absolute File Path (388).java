public class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] rec = new int[lines.length];
        int max = 0;
        
        for (String line : lines) {
            int idx = line.lastIndexOf('\t') + 1;
            rec[idx] = line.length() - idx;
            
            if (idx > 0) {
                rec[idx] += rec[idx - 1];
            }
            
            if (line.contains(".")) {
                max = Math.max(max, rec[idx] + idx);
            }
        }
        
        return max;
    }
}

public class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        List<Integer> rec = new ArrayList<Integer>();
        int max = 0;
        
        for (String line : lines) {
            int idx = line.lastIndexOf('\t') + 1;
            int len = line.length() - idx;
            
            if (idx >= rec.size()) {
                rec.add(len);
            } else {
                rec.set(idx, len);
            }

            if (idx > 0) {
                rec.set(idx, rec.get(idx - 1) + len);
            }
            
            if (line.contains(".")) {
                max = Math.max(max, rec.get(idx) + idx);
            }
        }
        
        return max;
    }
}
