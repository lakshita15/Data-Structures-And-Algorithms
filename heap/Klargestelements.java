import java.util.*;
import java.io.*;

public class klargestelements {
    public static void main(String[]args){
       Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //length of array
        int[] arr = new int[n];
  // array input
        for (int i = 0; i < n; i++) {
           arr[i] = scn.nextInt();
        }
  
        int k = scn.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //traverse on array and add k elements exactly in PQ
        for(int val : arr){
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
        
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
      }
    }
