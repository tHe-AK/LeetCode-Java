class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        
        int i = 0;
        
        while (i < S.length()) {
            if (map.containsKey(i) && S.startsWith(sources[map.get(i)], i)) {
                int j = map.get(i);
                sb.append(targets[j]);
                i += sources[j].length();
            } else {
                sb.append(S.charAt(i++));
            }
        }
        
        return sb.toString();
    }
}
