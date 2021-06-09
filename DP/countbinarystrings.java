
import java.io.*;
import java.util.*;

public class countbinarystrings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    //   int dp [][] = new int[2][n+1];
    //   for(int len = 1 ; len<= n ; len++){
    //       if(len ==1){
    //           dp[0][1] = dp[1][1] = 1;
    //       }else{
    //         dp[0][len] = dp[1][len-1] ;
    //         dp[1][len] = dp[0][len-1] + dp[1][len-1] ;
    //       }
    //   }
    //   System.out.println(dp[0][n] + dp[1][n]);
    
       
      int zeroes = 1;
      int ones = 1;
      for(int i = 2; i <= n; i++){
         int nzeroes = ones;
         int nones = ones + zeroes;

         zeroes = nzeroes;
         ones = nones;
      }

      System.out.println(zeroes + ones);
    }

}
