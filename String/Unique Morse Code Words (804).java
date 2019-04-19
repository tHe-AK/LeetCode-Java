class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] base = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for (Character ch : word.toCharArray()) {
                sb.append(base[ch - 'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
