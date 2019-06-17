class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        
        for (int i : A) {
            Set<Integer> next = new HashSet<>();
            next.add(i);

            for (int j : curr) {
                next.add(j | i);
            }
            
            curr = next;
            res.addAll(curr);
        }
        
        return res.size();
    }
}
