class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split("\\s+", 2);
            String[] split2 = log2.split("\\s+", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if (isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1) {
                return 1;
            } else if (isDigit2) {
                return -1;
            } else {
                int cmp = split1[1].compareTo(split2[1]);
                return cmp != 0 ? cmp : split1[0].compareTo(split2[0]);
            }
        });
        
        return logs;
    }
}
