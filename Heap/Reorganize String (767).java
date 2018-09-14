class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        for (int i = 0; i < len; i++) {
            int ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int key : map.keySet()) {
            int val = map.get(key);
            
            if (val > (len + 1) / 2) {
                return "";
            }
            
            queue.offer(new int[] { key, val });
        }

        while (queue.size() >= 2) {
            int[] peek1 = queue.poll();
            int[] peek2 = queue.poll();
            sb.append((char) peek1[0]);
            sb.append((char) peek2[0]);
            
            if (peek1[1] > 1) {
                peek1[1]--;
                queue.offer(peek1);
            }
            
            if (peek2[1] > 1) {
                peek2[1]--;
                queue.offer(peek2);
            }
        }
        
        if (!queue.isEmpty()) {
            sb.append((char) queue.poll()[0]);
        }

        return sb.toString();
    }
}

class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        for (int i = 0; i < len; i++) {
            int ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int key : map.keySet()) {
            queue.offer(new int[] { key, map.get(key) });
        }

        while (!queue.isEmpty()) {
            List<int[]> next = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                if (!queue.isEmpty()) {
                    int[] peek = queue.poll();
                    sb.append((char) peek[0]);

                    if (peek[1] > 1) {
                        peek[1]--;
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
