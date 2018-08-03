/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int x, y, idx;
        
        do {
            x = rand7();
            y = rand7();
            idx = (x - 1) * 7 + y;
        } while (idx > 40);
        
        return (idx - 1) % 10 + 1;
    }
}
