public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = 0;
        
        while (count1 < n1) {
            if (array1[i] == array2[j]) {
                j++;
                
                if (j == array2.length) {
                    j = 0;
                    count2++;
                }
            }
            
            i++;
            
            if (i == array1.length) {
                i = 0;
                count1++;
            }
        }
        
        return count2 / n2;
    }
}
