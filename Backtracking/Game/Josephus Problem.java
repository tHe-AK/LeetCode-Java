public class Solution {
    public int josephus(int n, int k) {
        return n == 1 ? 1 : (josephus(n - 1, k) + 1) % n + 1;
    }
}
