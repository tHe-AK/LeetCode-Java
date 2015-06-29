public class Solution {
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.size(); i++) {
            if (hashMap.containsKey(nums.get(i))) {
                hashMap.put(nums.get(i), hashMap.get(nums.get(i)) + 1);
            }
            else if (hashMap.size() < k - 1) {
                hashMap.put(nums.get(i), 1);
            }
            else {
                List<Integer> remove = new ArrayList<Integer>();

                for (Integer key : hashMap.keySet()) {
                    int value = hashMap.get(key);

                    if (value > 1) {
                        hashMap.put(key, value - 1);
                    } else {
                        remove.add(key);
                    }
                }

                for (Integer key : remove) {
                    hashMap.remove(key);
                }
            }
        }

        for (int key : hashMap.keySet()) {
            int count = 0;
            
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == key) {
                    count++;
                }
            }
            
            if (count > nums.size() / k) {
                return key;
            }
        }

        throw new RuntimeException("Input is not valid.");
    }
}
