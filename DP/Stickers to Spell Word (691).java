class Solution {
    public int minStickers(String[] stickers, String target) {
        int len = target.length();
        int N = 1 << len;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 0; i < N - 1; i++) {
            if (dp[i] != -1) {                
                for (String sticker : stickers) {
                    int curr = i;

                    for (char ch : sticker.toCharArray()) {
                        for (int j = 0; j < len; j++) {
                            if (((curr >> j) & 1) == 0 && target.charAt(j) == ch) {
                                curr |= 1 << j;
                                break;
                            }
                        }
                    }
                    
                    if (dp[curr] == -1 || dp[curr] > dp[i] + 1) {
                        dp[curr] = dp[i] + 1;
                    }
                }
            }
        }
        
        return dp[N - 1];
    }
}
