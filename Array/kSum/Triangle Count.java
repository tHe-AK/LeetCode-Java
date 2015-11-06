public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        if (S == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(S);
        int count = 0;
        
        for (int i = 2; i < S.length; i++) {
            int low = 0;
            int high = i - 1;
            
            while (low < high) {
                if (S[low] + S[high] > S[i]) {
                    count += high - low;
                    high--;
                } else {
                    low++;
                }
            }
        }
        
        return count;
    }
}

