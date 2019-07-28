class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] record = new int[60];
        
        for (int i : time) {
            i %= 60;
            int j = i > 0 ? (60 - i) : 0;
            res += record[j];
            record[i]++;
        }
        
        return res;
    }
}
