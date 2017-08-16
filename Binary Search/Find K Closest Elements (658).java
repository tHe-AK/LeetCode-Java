public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int idx = Collections.binarySearch(arr, x);
        
        if (idx < 0) {
            idx = -(idx + 1);
        }
        
        int low = idx - 1;
        int high = idx;
        
        while (k-- > 0) {
            if (low < 0) {
                high++;
            } else if (high >= arr.size()) {
                low--;
            } else if (Math.abs(arr.get(low) - x) <= Math.abs(arr.get(high) - x)) {
                low--;
            } else {
                high++;
            }
        }

        return arr.subList(low + 1, high);
    }
}

public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int start = 0;
        
        for (int i = k; i < arr.size(); i++) {
            int diff = Math.abs(arr.get(i) - x) - Math.abs(arr.get(start) - x);
            
            if (diff > 0) {
                break;
            } else if (diff < 0) {
                start = i - k + 1;
            } else {
                continue;
            }
        }
        
        return arr.subList(start, start + k);
    }
}
