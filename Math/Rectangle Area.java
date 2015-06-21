public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = 0;
        int hight = 0;

        if (A < E && E < C && C < G) {
            width = C - E;
        }
        else if (E < A && A < G && G < C) {
            width = G - A;
        }
        else if (A <= E && G <= C) {
            width = G - E;
        }
        else if (E <= A && C <= G) {
            width = C - A;
        }
        else {
        }
        
        if (B < F && F < D && D < H) {
            hight = D - F;
        }
        else if (F < B && B < H && H < D) {
            hight = H - B;
        }
        else if (B <= F && H <= D) {
            hight = H - F;
        }
        else if (F <= B && D <= H) {
            hight = D - B;
        }
        else {
        }
        
        return (C - A) * (D - B) + (G - E) * (H - F) - hight * width;
    }
}
