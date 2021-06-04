
import java.io.*;
import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++){
                int val = values[i - 1];
                int wt = wts[i - 1];

                if(j >= wt){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt] + val);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][cap]);
    }
}
// public static void main(String[] args) throws Exception {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int vls[] = new int[n];
//     for(int i = 0 ; i < n ; i++){
//         vls[i] = scn.nextInt();
//     }
//     int wts[] = new int[n];
//     for(int i = 0 ; i < n ; i++){
//         wts[i] = scn.nextInt();
//     }
//     int cap = scn.nextInt();
    
//     System.out.println(zeroOneKnapsack(wts,vls,cap));
    
// }

// public static int zeroOneKnapsack(int wts[],int vls[],int cap){
//     int nr = wts.length + 1;
//     int nc = cap + 1;
    
//     int[][] ans = new int[nr][nc];
    
//     for(int r = 1; r < nr; r++){
//         int wt = wts[r - 1];
//         int val = vls[r - 1];
//         for(int c = 1; c < nc; c++){
//             int exc = ans[r-1][c];
//             int inc = (c-wt >= 0)? (val + ans[r-1][c-wt]) : 0;
//             ans[r][c] = Math.max(exc,inc);
//         }
//     }

//     return ans[nr-1][nc-1];
// }


                        


                        
                        