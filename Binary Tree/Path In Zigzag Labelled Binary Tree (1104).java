class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;

        while (label >= (1 << level)) {
            level++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        while (level > 0) {
            list.add(0, label);
            level--;
            label = (1 << (level - 1)) + (1 << level) - 1 - label / 2;
        }
               
        return list;
    }
}
