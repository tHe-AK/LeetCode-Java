public class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int n = senate.length();
        
        for (int i = 0; i < n; i++){
            if (senate.charAt(i) == 'R') {
                queue1.add(i);
            } else {
                queue2.add(i);
            }
        }
        
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int idx1 = queue1.poll();
            int idx2 = queue2.poll();
            
            if (idx1 < idx2) {
                queue1.add(idx1 + n);
            } else {
                queue2.add(idx2 + n);
            }
        }
        
        return (queue1.size() > queue2.size()) ? "Radiant" : "Dire";
    }
}
