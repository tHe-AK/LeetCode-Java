/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        int start = 1;
        int end = n;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);
            
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        throw new IllegalArgumentException();
    }
}
