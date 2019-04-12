class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] records = new double[101];
        records[0] = poured;
        
        for (int i = 1; i <= query_row; i++) {
            double[] temp = new double[101];
            
            for (int j = 0; j <= i; j++) {
                if (records[j] > 1) {
                    double half = (records[j] - 1) / 2;
                    temp[j] += half;
                    temp[j + 1] += half;
                }
            }
            
            records = temp;
        }
        
        return Math.min(records[query_glass], 1);
    }
}
