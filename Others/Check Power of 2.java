public class Solution {
    public boolean checkPowOf2(int x) {
        return x & x - 1;
    }
}
