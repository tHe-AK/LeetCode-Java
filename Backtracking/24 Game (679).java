class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        
        for (int num : nums) {
            list.add((double) num);
        }
        
        return dfs(list);
    }
    
    private boolean dfs(List<Double> list) {
        int n = list.size();
        
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double x = list.get(i);
                        double y = list.get(j);
                        List<Double> next = new ArrayList<>();

                        for (int k = 0; k < n; k++) {
                            if (k != i && k != j) {
                                next.add(list.get(k));
                            }
                        }

                        for (int k = 0; k < 4; k++) {
                            if (k == 0) {
                                next.add(x + y);
                            } else if (k == 1) {
                                next.add(x - y);
                            } else if (k == 2) {
                                next.add(x * y);
                            } else if (y != 0) {
                                next.add(x / y);
                            } else {
                                continue;
                            }
                            
                            if (dfs(next)) {
                                return true;
                            }

                            next.remove(next.size() - 1);
                        }
                    }
                }
            }
            
            return false;
        }
    }
}
