class Solution {
    public int uniqueLetterString(String S) {
        int N = 1_000_000_007;
        int count = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }
        
        for (List<Integer> val : map.values()) {
            for (int i = 0; i < val.size(); i++) {
                int curr = val.get(i);
                int prev = i == 0 ? -1 : val.get(i - 1);
                int next = i == val.size() - 1 ? S.length() : val.get(i + 1);
                count = (count + ((curr - prev) * (next - curr) % N)) % N;
            }
        }
        
        return count;
    }
}
