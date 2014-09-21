public class Solution {
    public int kSumNum(int[] num, int k, int target) {
        if (num == null || num.length == 0 || k < 1 || k > num.length) {
            return 0;
        }
        
        Arrays.sort(num);
        int len = num.length;
        int minK = 0;
        int maxK = 0;
        
        for (int i = 0; i < k; i++) {
            minK += num[i];
            maxK += num[len - i - 1];
        }
        
        if (target < minK || target > maxK) {
            return 0;
        }
        
        int range = maxK - minK + 1;
        int[][][] rec = new int[k][len][range];
        
        for (int i = 0; i < k; i++) {
            for (int j = i; j < len; j++) {
                if (i == 0) {
                    rec[i][j][num[j] - minK] = 1;
                }
                else {
                    for (int l = 0; l < j; l++) {
                        for (int t = 0; t < range; t++) {
                            if (rec[i - 1][l][t] > 0) {
                                rec[i][j][t + num[j]] += rec[i - 1][l][t];
                            }
                        }
                    }
                }
            }
        }
        
        return rec[k - 1][len - 1][target - minK];
    }
}
