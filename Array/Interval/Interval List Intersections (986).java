class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][0]) {
                i++;
            } else if (A[i][0] > B[j][1]) {
                j++;
            } else {
                list.add(new int[] { Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1]) });
                
                if (A[i][1] < B[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        
        return list.toArray(new int[0][0]);
    }
}
