class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int count = 0;
        
        while (candies > 0) {
            people[count % num_people] += Math.min(candies, ++count);
            candies -= count;
        }
        
        return people;
    }
}
