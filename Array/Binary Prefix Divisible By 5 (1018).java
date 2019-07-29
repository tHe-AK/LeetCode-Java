class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int num = 0;
        List<Boolean> res = new ArrayList<>();
        
        for (int i : A) {
            num = (num * 2 + i) % 5;
            res.add(num == 0);
        }
        
        return res;
    }
}
