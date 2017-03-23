public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] genes = { 'A', 'T', 'C', 'G' };
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        wordSet.remove(start);
        int len = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            
            for (int i = 0; i < size; i++) {
                String peek = queue.poll();
                List<String> neighbors = getNeighbors(peek, genes);
                
                for (String neighbor : neighbors) {
                    if (wordSet.contains(neighbor)) {
                        if (neighbor.equals(end)) {
                    	    return len;
                    	}
                    	
                        queue.offer(neighbor);
                        wordSet.remove(neighbor);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private List<String> getNeighbors(String str, char[] genes) {
        List<String> neighbors = new ArrayList<>();
        
        for (int j = 0; j < str.length(); j++) {
            StringBuilder sb = new StringBuilder(str);
                    
            for (char ch : genes) {
                if (ch != str.charAt(j)) {
                    sb.setCharAt(j, ch);
                    String neighbor = sb.toString();
                    neighbors.add(neighbor);
                }
            }
        }
        
        return neighbors;
    }
}
