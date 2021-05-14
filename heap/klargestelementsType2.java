 //INPUT
// A = [11, 3, 4]
// B = 2
//OUTPUT
//[11, 4]

import java.io.*;
import java.util.*;

public class klargestelementsType2 {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
         int n = scn.nextInt(); //length of array
         int[] arr = new int[n];
         // array input
         for (int i = 0; i < n; i++) {
             arr[i] = scn.nextInt();
            }  
            
          int k = scn.nextInt();
          int [] ans = solve(arr, k);
          for(int i=0;i<ans.length;i++)    //length is the property of the array  
           System.out.println(ans[i]);  
         
    }
         
    public static int[] solve(int[] A, int B) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
     //traverse on array and add k elements exactly in PQ
     for(int val : A){
         if(pq.size() < B){
             pq.add(val);
         }else{
             int min = pq.peek();
             if(min < val){
                 // new value is better than smallest value in priority Queue
                 pq.remove(); //  smallest element removed
                 pq.add(val); // add the winning value on its place
             }
         }
         
     }
     
    int ans [] = new int[B];
    for(int i = 0 ; i < B; i++){
        
    ans[i] = pq.remove();
    }
    return ans;
 }
}
