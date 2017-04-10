public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        Character[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        Set<Character> set = new HashSet<>(Arrays.asList(vowels));
        
        while (i < j) {
            if (!set.contains(chars[i])) {
                i++;
            } else if (!set.contains(chars[j])) {
                j--;
            } else {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        
        return new String(chars);
    }
}
