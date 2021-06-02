
import java.io.*;
import java.util.*;

public class goldmine {

    public static void main(String[] args) throws Exception {
        // write your code here
       Scanner scn = new Scanner(System.in);
      int nr = scn.nextInt();
       int nc = scn.nextInt();
       int [][]mine = new int[nr][nc];
       for(int i = 0 ; i <nr ; i++){
           for(int j =0 ; j <nc ; j++){
               mine[i][j] = scn.nextInt();
           }
       }  
       System.out.println( maxGold(mine));
    }
    
    public static int maxGold(int mine[][]) {
        int nr = mine.length, nc = mine[0].length;
        int dp[][] = new int[nr][nc];
        for (int c = nc - 1; c >= 0; c--) {
            for (int r = 0; r < nr; r++) {
                if (c == nc - 1) {
                    dp[r][c] = mine[r][c];
                } else {
                    int du = (r - 1 >= 0) ? dp[r - 1][c + 1] : 0;
                    int dd = (r + 1 < nr) ? dp[r + 1][c + 1] : 0;
                    dp[r][c] = Math.max(dp[r][c + 1], Math.max(du, dd)) + mine[r][c];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < nr; r++) {
            max = Math.max(max, dp[r][0]);
        }
        return max;
    }
    }

   