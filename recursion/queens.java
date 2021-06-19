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

    public static int queenCombination1Dsub(int tnb, int bno, int tnq, int qpsf, String ans) {
        if (qpsf == tnq ) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int b = bno;
        if(b < tnb) {
            count += queenCombination1Dsub(tnb, bno + 1, tnq, qpsf + 1, ans + "bno" + b + "q" + qpsf + " ");
            count += queenCombination1Dsub(tnb, bno + 1,tnq,  qpsf, ans);
        }
        return count;

    }

    public static int QueenPermutation_sub(int tnq,int bno,int qno,String ans, boolean[] visited)
    {
        if(qno==tnq)
        {
         System.out.println(ans);
            return 1;
        }
        int count=0;
        if(bno<visited.length)
        {
            if(!visited[bno])
            {
                visited[bno]=true;
                count+=QueenPermutation_sub(tnq,0,qno+1,ans+"B"+bno+"Q"+qno+" ",visited);
                visited[bno]=false;
            }
            count+=QueenPermutation_sub(tnq,bno+1,qno,ans,visited);
        }
        return count;
    }

    public static int queenCombination2Dsub(boolean[][] tnb, int idx, int tnq,String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        int i= bno;
        int r = i / m;
        int c = i % m;

        if (i < n * m) {
            count += queenCombination2Dsub(tnb, i + 1, tnq - 1, ans + "(" + r + "," + c + ") ");
        }
        count += queenCombination2Dsub(tnb, i + 1, tnq - 1, ans + "(" + r + "," + c + ") ");
        return count;
    }

    public static int queenPermutation2Dsub(boolean[][] tnb, int tnq, int bno,String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        int i=bno;
        int r = i / m;
        int c = i % m;
        if(i < n * m) {
            if (!tnb[r][c]) {
                tnb[r][c] = true;
                count += queenPermutation2Dsub(tnb, tnq - 1, 0 , ans + "(" + r + "," + c + ") ");
                tnb[r][c] = false;
            }
            count += queenPermutation2Dsub(tnb, tnq, bno+1 , ans);
        }

        return count;
    }


    public static void queenCombination() {
        // System.out.println(queenCombination1D(4, 0, 2, 0, ""));
        // boolean[] tnb = new boolean[3];
        // System.out.println(QueenPermutation_sub(2 ,0 ,0 , " " , tnb ));


        int n = 4;
        boolean[][] tnb = new boolean[n][n];
        // System.out.println(queenCombination2D(tnb, 0, n, ""));
        System.out.println(queenPermutation2Dsub(tnb, n,0, ""));

    } 
    public static void main(String[] args) {
        queenCombination();
    }
}
