class Solution {
    public int oddEvenJumps(int[] A) {
        int N = A.length;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N - 1] = even[N - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N - 1], N - 1);
        int count = 1;

        for (int i = N - 2; i >= 0; i--) {
            Integer ceilingKey = map.ceilingKey(A[i]);

            if (ceilingKey != null) {
                odd[i] = even[map.get(ceilingKey)];
            }
            
            Integer floorKey = map.floorKey(A[i]);
            
            if (floorKey != null) {
                even[i] = odd[map.get(floorKey)];
            }
            
            if (odd[i]) {
                count++;
            }
            
            map.put(A[i], i);
        }
        
        return count;
    }
}
