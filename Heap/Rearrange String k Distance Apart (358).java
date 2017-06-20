public class Solution {
    public String rearrangeString(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() != b.getValue()
                ? Integer.compare(b.getValue(), a.getValue()) : Character.compare(a.getKey(), b.getKey()));
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        queue.addAll(map.entrySet());
        
        while (!queue.isEmpty()) {
            List<Map.Entry<Character, Integer>> next = new ArrayList<>();
            
            for (int i = 0; i < k; i++) {
                if (!queue.isEmpty()) {
                    Map.Entry<Character, Integer> peek = queue.poll();
                    sb.append(peek.getKey());
                    
                    if (peek.getValue() > 1) {
                        peek.setValue(peek.getValue() - 1);
                        next.add(peek);
                    }
                } else {
                    if (next.isEmpty()) {
                        break;
                    } else {
                        return "";
                    }
                }
            }
            
            queue.addAll(next);
        }
        
        return sb.toString();
    }
}

public class Solution {
    public String rearrangeString(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++){
            int idx = findValidIdx(count, valid, i);
            
            if (idx == -1) {
                return "";
            }
            
            count[idx]--;
            valid[idx] = i + k;
            sb.append((char) ('a' + idx));
        }
        
        return sb.toString();
    }
    
    private int findValidIdx(int[] count, int[] valid, int curr) {
        int max = 0;
        int idx = -1;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && curr >= valid[i]) {
                max = count[i];
                idx = i;
            }
        }
        
        return idx;
   }
}
