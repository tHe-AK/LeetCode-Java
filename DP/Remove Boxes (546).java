public class Solution {
    public int removeBoxes(int[] boxes) {
        Map<String, Integer> map = new HashMap<>();
        return remove(boxes, map);
    }
    
    private int remove(int[] boxes, Map<String, Integer> map) {
        String key = Arrays.toString(boxes);
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        if (boxes.length == 0) {
            return 0;
        }
        
        int result = 0;
        
        for (int i = 0; i < boxes.length; i++) {
            if (i == 0 || boxes[i] != boxes[i - 1]) {
                int j = i + 1;
                
                while (j < boxes.length && boxes[j] == boxes[i]) {
                    j++;
                }
                
                int count = j - i;
                int[] newboxes = new int[boxes.length - count];
                int idx = 0;
                
                for (int k = 0; k < boxes.length; k++) {
                    if (k < i || k >= j) {
                        newboxes[idx++] = boxes[k];
                    }
                }
                
                result = Math.max(result, remove(newboxes, map) + count * count);
            }
        }
        
        map.put(key, result);
        return result;
    }
}
