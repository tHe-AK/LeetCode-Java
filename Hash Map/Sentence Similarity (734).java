class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, String> map = new HashMap<>();

        for (String[] pair : pairs) {
            map.put(pair[0], pair[1]);
        }

        for (int i = 0; i < words1.length; ++i) {
            String str1 = words1[i];
            String str2 = words2[i];

            if (!str1.equals(str2) && !(map.containsKey(str1) && map.get(str1).equals(str2))
                    && !(map.containsKey(str2) && map.get(str2).equals(str1))) {
                return false;
            }
        }

        return true;
    }
}
