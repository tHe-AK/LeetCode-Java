class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        
        int count = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(A);
        queue.offer(A);
        
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String peek = queue.poll();
                int j = 0;
                
                while (j < peek.length() && peek.charAt(j) == B.charAt(j)) {
                    j++;
                }
                
                int k = j + 1;
                
                while (k < peek.length()) {
                    if (peek.charAt(k) == B.charAt(j)) {
                        String str = swap(peek, j, k);
                        
                        if (str.equals(B)) {
                            return count;
                        }
                        
                        if (visited.add(str)) {
                            queue.offer(str);
                        }
                    }
                    
                    k++;
                }
            }
        }
        
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        char[] array = str.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return new String(array);
    }
}
