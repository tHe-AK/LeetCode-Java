public class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        
        while (list.size() != 1) {
            List<String> next = new ArrayList<>();
            
            for (int i = 0; i < list.size() / 2; i++) {
                next.add("(" + list.get(i) + "," + list.get(list.size() - i - 1) + ")");
            }
            
            list = next;
        }
        
        return list.get(0);
    }
}
