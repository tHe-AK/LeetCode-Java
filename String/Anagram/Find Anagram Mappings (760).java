class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }

        int[] ans = new int[A.length];
        int i = 0;

        for (int j = 0; j < A.length; j++) {
            ans[j] = map.get(A[i]);
        }

        return ans;
    }
}
