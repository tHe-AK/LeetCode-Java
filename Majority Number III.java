public class Solution {
    public int majorityNumber(int[] num, int k) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < num.length; i++) {
            if (hashMap.size() < k - 1 && !hashMap.containsKey(num[i])) {
                hashMap.put(num[i], 1);
            }
            else if (hashMap.containsKey(num[i])) {
                hashMap.put(num[i], hashMap.get(num[i]) + 1);
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
            
            for (int i = 0; i < num.length; i++) {
                if (num[i] == key) {
                    count++;
                }
            }
            
            if (count > num.length / k) {
                return key;
            }
        }

        throw new RuntimeException("Input is not valid.");
    }
}
