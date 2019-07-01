class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            String str = local[0].replace(".", "") + "@" + parts[1];
            set.add(str);
        }
        
        return set.size();
    }
}
