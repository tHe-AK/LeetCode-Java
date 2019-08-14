class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int N = values.length;
        Integer[] idx = new Integer[N];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            idx[i] = i;
        }
        
        Arrays.sort(idx, (a, b) -> Integer.compare(values[b], values[a]));
        int i = 0;
        
        while (num_wanted > 0 && i < N) {
            int j = idx[i++];
            int count = map.getOrDefault(labels[j], 0);
            
            if (count < use_limit) {
                sum += values[j];
                map.put(labels[j], count + 1);
                num_wanted--;
            }
        }
        
        return sum;
    }
}
