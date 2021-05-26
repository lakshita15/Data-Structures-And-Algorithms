import java.io.*;
import java.util.*;

public class fibonacci {
    public static void main(String[] args) {

        int n = 5;
        long starttime = System.currentTimeMillis();
        System.out.println(fibt(n));
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime);
    }

    // RECURSIVE//
    // public static int fibr(int n ){
    // if(n==1){
    // return 0;
    // }
    // if(n==2){
    // return 1;
    // }
    // int f1 = fibr(n-1);
    // int f2 = fibr(n-2);
    // int ans = f1+f2;
    // return ans;
    // }
    // ==MEMOIZED===//
    // public static int fibm(int n , int qb[]){
    // if(n==1){
    // return qb[1]=0;
    // }
    // if(n==2){
    // return qb[2]=1;
    // }
    // if(qb[n] != 0){
    //     return qb[n];
    // }
    // int f1 = fibr(n-1);
    // int f2 = fibr(n-2);
    // int ans = f1+f2;
    // return qb[n]=ans;
    // }
    /***** TABULATION****** */
    public static int fibt(int n) {
        int qb[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                qb[i] = 0;

            } else if (i == 2) {
                qb[i] = 1;
            } else {
                qb[i] = qb[i - 1] + qb[i - 2];
            }
        }
return qb[n];
    }
}