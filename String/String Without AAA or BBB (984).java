class Solution {
    public String strWithout3a3b(int A, int B) {
        char a = 'a';
        char b = 'b';
        StringBuilder sb = new StringBuilder();
        
        if (A < B) {
            a = 'b';
            b = 'a';
            int temp = A;
            A = B;
            B = temp;
        }
                
        while (A > 0) {
            sb.append(a);
            A--;
            
            if (A > B) {
                sb.append(a);
                A--;
            }
            
            if (B > 0) {
                sb.append(b);
                B--;
            }
        }
        
        return sb.toString();
    }
}
