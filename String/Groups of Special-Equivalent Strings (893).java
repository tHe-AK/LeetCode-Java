class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> visited = new HashSet<>();
        
        for (String str : A) {
            int[] count = new int[52];
            
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            
            visited.add(Arrays.toString(count));
        }
        
        return visited.size();
    }
}
