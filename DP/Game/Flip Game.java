public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        
        for (int i = -1; (i = s.indexOf("++", i + 1)) != -1; ) {
            result.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        
        return result;
    }
}
