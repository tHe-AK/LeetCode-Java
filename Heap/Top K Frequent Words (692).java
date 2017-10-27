class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() != b.getValue() ? Integer.compare(a.getValue(), b.getValue()) : b.getKey().compareTo(a.getKey()));
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        while (!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }
        
        Collections.reverse(res);
        return res;
    }
}
