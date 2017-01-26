public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            num <<= 2;
            num += map.get(s.charAt(i));
            num &= 0xFFFFF;

            if (i >= 9 && !set.add(num) && duplicate.add(num)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }

        return result;
    }
}
