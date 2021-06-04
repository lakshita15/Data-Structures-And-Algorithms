
import java.io.*;
	import java.util.*;

	public class Main {

	    public static void unboundedknapsack(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int weight[] = new int[n];
            int val[] = new int[n];
            for(int i=0;i<n;i++){
                val[i] = scn.nextInt();
            }
            for(int i=0;i<n;i++){
                weight[i] = scn.nextInt();
            }
            int tar = scn.nextInt();
    
            
            int dp[] = new int[tar+1];
            for(int i = 0; i <n; i++){ 
            int value = val[i];
            int wgt = weight[i];
            for(int c = wgt ; c <= tar ; c++){
                dp[c] = Math.max(value + dp[c-wgt] , dp[c]);
            }
        } 
        System.out.println(dp[tar]) ;
	    }
	    
	    
	}