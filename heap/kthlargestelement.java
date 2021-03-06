//leetcode 205
//this ques is an another approach tothe ques finding k largest elements here we need to the vaalue that is kth largest 

//***************************INPUT*************************************** */
//6 
//3 2 1 5 6 4 
//2
// 5 output

import java.io.*;
import java.util.*;

public class kthlargestelement {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
         int n = scn.nextInt(); //length of array
         int[] arr = new int[n];
         // array input
         for (int i = 0; i < n; i++) {
             arr[i] = scn.nextInt();
            }  
            
          int k = scn.nextInt();
          int ans =findKthLargest(arr, k);
          System.out.println(ans);
    }
         
         public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //traverse on array and add k elements exactly in PQ
        for(int val : nums){
            if(pq.size() < k){
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
        
       return pq.remove();
    }
}

