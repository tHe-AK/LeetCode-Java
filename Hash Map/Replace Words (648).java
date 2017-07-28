public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        set.addAll(dict);
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            String root = "";
            
            for (int i = 1; i <= word.length(); i++) {
                root = word.substring(0, i);
                
                if (set.contains(root)) {
                    break;
                }
            }
            
            sb.append((sb.length() == 0 ? "" : " ") + root);
        }
        
        return sb.toString();
    }
}
