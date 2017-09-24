class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] idx = new int[n + 1];
        boolean[] rec = new boolean[n];
        int count = n - 1;
        boolean existed = false;
        
        for (int i = 0; i < n; i++) {
            idx[org[i]] = i;
        }
        
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int y = seq.get(i);
                
                if (y < 1 || y > n) {
                    return false;
                }
                
                existed = true;
                
                if (i > 0) {
                    int x = seq.get(i - 1);
                    
                    if (idx[x] >= idx[y]) {
                        return false;
                    }
                    
                    if (idx[x] + 1 == idx[y] && !rec[idx[y]]) {
                        rec[idx[y]] = true;
                        count--;
                    }
                }
            }
        }
        
        return existed && count == 0;
    }
}
