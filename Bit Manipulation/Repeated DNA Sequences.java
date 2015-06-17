public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() < 10) {
            return result;
        }

        HashSet<Integer> rec = new HashSet<Integer>();
        HashSet<Integer> add = new HashSet<Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur <<= 2;
            cur += map.get(s.charAt(i));
            cur &= (1 << 20) - 1;

            if (i >= 9) {
                if (!rec.contains(cur)) {
                    rec.add(cur);
                } else if (!add.contains(cur)) {
                    add.add(cur);
                    result.add(s.substring(i - 9, i + 1));
                } else {
                }
            }
        }

        return result;
    }
}
