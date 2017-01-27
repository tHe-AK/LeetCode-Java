public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null) {
            throw new IllegalArgumentException();
        }
        
        int len = org.length;
        int[] index = new int[len + 1];
        boolean[] rec = new boolean[len - 1];
        boolean isEmpty = true;
        
        for (int i = 0; i < len; i++) {
            index[org[i]] = i;
        }
        
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                isEmpty = false;
                
                if (seq[i] < 1 || seq[i] > len) {
                    return false;
                }
                
                if (i > 0) {
                    if (index[seq[i - 1]] >= index[seq[i]]) {
                        return false;
                    }
                    
                    if (index[seq[i - 1]] + 1 == index[seq[i]]) {
                        rec[index[seq[i - 1]]] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (!rec[i]) {
                return false;
            }
        }
        
        if (isEmpty) {
            return false;
        }
        
        return true;
    }
}
