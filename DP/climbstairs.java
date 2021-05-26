import java.io.*;
import java.util.*;


public  class climbstairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(climbstaircase(n));
        
       }
       public static int climbstaircase(int n) {
           int qb[] = new int[n+1];
           for(int i=0 ; i <=n ; i++){
               if(i==0){
                   qb[i]=1;
               }else if(i==1){
                   qb[i] = qb[i-1];
               }else if(i==2){
                   qb[i] = qb[i-1]+qb[i-2];
               }
               else{
                   qb[i] = qb[i-1] +qb[i-2]+ qb[i-3];
                       
                       
               } 
           }
           return qb[n];
       
       }

    }