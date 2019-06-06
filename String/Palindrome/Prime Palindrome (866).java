class Solution {
    public int primePalindrome(int N) {
        if (N >= 8 && N <= 11) {
            return 11;
        }
        
        for (int i = 1; i < 20_000; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            int num = Integer.parseInt(sb.toString() + sb.reverse().toString().substring(1));
            
            if (num >= N && isPrime(num)) {
                return num;
            }
        }
        
        return -1;
    }
    
    private boolean isPrime(int num) {
        if (num <= 2) {
            return num == 2;
        }
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
