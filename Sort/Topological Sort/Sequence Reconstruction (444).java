public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int len = org.length;
        int[] idx = new int[len + 1];
        boolean[] rec = new boolean[len];

        for (int i = 0; i < len; i++) {
            idx[org[i]] = i;
        }
        
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int y = seq.get(i);
                
                if (y < 1 || y > len) {
                    return false;
                }
                
                if (i == 0) {
                    if (len == 1) {
                        rec[idx[y]] = true;
                    }
                } else {
                    int x = seq.get(i - 1);
                    
                    if (idx[x] >= idx[y]) {
                        return false;
                    }
                    
                    if (idx[x] + 1 == idx[y]) {
                        rec[idx[y]] = true;
                    }
                }
            }
        }
        
        if (len == 1) {
            return rec[0];
        } else {
            for (int i = 1; i < len; i++) {
                if (!rec[i]) {
                    return false;
                }
            }
            
            return true;
        }
    }
}
