class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int low = 0;
        int high = people.length - 1;
        
        while (low <= high) {
            ans++;
            
            if (people[low] + people[high] <= limit) {
                low++;
            }
            
            high--;
        }
        
        return ans;
    }
}
