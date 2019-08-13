class Solution {
    public int sumOfDigits(int[] A) {
        int min = Arrays.stream(A).min().getAsInt();
        
        int sum = 0;
        
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        
        return 1 - (sum % 2);
    }
}
