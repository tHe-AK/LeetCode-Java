class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            int diff = (S.charAt(i) - 'a' + sum) % 26;
            sb.insert(0, (char) ('a' + diff));
        }
        
        return sb.toString();
    }
}
