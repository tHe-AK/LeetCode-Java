class Solution {
	public int shortestWay(String source, String target) {
		int N = target.length();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (dp[j - 1] >= 0 && isSubsequence(source, target.substring(j - 1, i))) {
					dp[i] = dp[i] >= 0 ? Math.min(dp[i], dp[j - 1] + 1) : dp[j - 1] + 1;
				}
			}

			if (dp[i] == -1) {
				return -1;
			}
		}

		return dp[N];
	}

	private boolean isSubsequence(String source, String target) {
		int i = 0;
		int j = 0;

		while (i < source.length() && j < target.length()) {
			if (source.charAt(i) == target.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}

		return j == target.length();
	}
}
