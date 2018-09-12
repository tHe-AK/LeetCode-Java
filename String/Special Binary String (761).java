class Solution {
    public String makeLargestSpecial(String S) {
        int start = 0;
        int count = 0;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < S.length(); i++) {
            int bit = S.charAt(i) - '0';
            count += bit == 1 ? 1 : -1;
            
            if (count == 0) {
                list.add("1" + makeLargestSpecial(S.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }
}
