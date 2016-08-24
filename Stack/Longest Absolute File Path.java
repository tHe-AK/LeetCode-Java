public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        
        String[] lines = input.split("\n");
        List<Integer> rec = new ArrayList<Integer>();
        rec.add(0);
        int max = 0;
        
        for (String line : lines) {
            String name = line.replace("\t", "");
            int index = line.length() - name.length() + 1;
            
            if (name.contains(".")) {
                max = Math.max(max, rec.get(index - 1) + name.length());
            } else {
                int count = rec.get(index - 1) + name.length() + 1;
                        
                if (index >= rec.size()) {
                    rec.add(count);
                } else {
                    rec.set(index, count);
                }
            }
        }
        
        return max;
    }
}
