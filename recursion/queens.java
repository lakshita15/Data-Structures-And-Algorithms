import java.io.*;
import java.util.*;


public class queens {
    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < tnb; b++) {
            count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, ans + "b" + b + "q" + qpsf + " ");
        }

        return count;

    }

    public static int queenPermutation1D(boolean[] tnb, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int b = 0; b < tnb.length; b++) {
            if (!tnb[b]) {
                tnb[b] = true;
                count += queenPermutation1D(tnb, tnq, qpsf + 1, ans + "b" + b + "q" + qpsf + " ");
                tnb[b] = false;
            }
        }

        return count;
    }

    public static int queenCombination2D(boolean[][] tnb, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            count += queenCombination2D(tnb, i + 1, tnq - 1, ans + "(" + r + "," + c + ") ");
        }

        return count;
    }

    public static int queenPermutation2D(boolean[][] tnb, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!tnb[r][c]) {
                tnb[r][c] = true;
                count += queenPermutation2D(tnb, tnq - 1, ans + "(" + r + "," + c + ") ");
                tnb[r][c] = false;
            }
        }

        return count;
    }
    public static void queenCombination() {
        System.out.println(queenCombination1D(5, 0, 3, 0, ""));
        // boolean[] tnb = new boolean[5];
        // System.out.println(queenPermutation1D(tnb, 3, 0, ""));


        int n = 4;
        boolean[][] tnb = new boolean[n][n];
        System.out.println(queenCombination2D(tnb, 0, n, ""));
        System.out.println(queenPermutation2D(tnb, n, ""));

    }
    public static void main(String[] args) {
        queenCombination();
    }
}
