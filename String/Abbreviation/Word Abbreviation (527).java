public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int size = dict.size();
        int[] prefix = new int[size];
        String[] result =new String[size];
        
        for (int i = 0; i < size; i++) {
            prefix[i] = 1;
            result[i] = getAbbr(dict.get(i), 1);
        }
        
        for (int i = 0; i < size; i++) {
            while (true) {
                Set<Integer> set = new HashSet<>();
                
                for (int j = i + 1; j < size; j++) {
                    if (result[j].equals(result[i])) {
                        set.add(j);
                    }
                }
                
                if (set.isEmpty()) {
                    break;
                }
                
                set.add(i);

                for (int idx : set) {
                    result[idx] = getAbbr(dict.get(idx), ++prefix[idx]);
                }
            }
        }
        
        return Arrays.asList(result);
    }
    
    private String getAbbr(String s, int k) {
        int len = s.length();
        
        if (k >= len - 2) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, k));
        sb.append(len - 1 - k);
        sb.append(s.charAt(len - 1));
        
        return sb.toString();
    }
}
