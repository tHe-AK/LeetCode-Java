public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        Map<Long, Integer>[] map = new Map[A.length];
        int result = 0;

        for (int i = 0; i < len; i++) {
            map[i] = new HashMap<>();
            	
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                int count = map[j].getOrDefault(diff, 0);
                result += count;
                map[i].put(diff, map[i].getOrDefault(diff, 0) + count + 1);
            }
        }
    		
        return result;
    }
}
