import java.util.*;
import java.io.*;

 class Leetcode703 {
    
    public static void main(String[] args) {
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        int k =3;
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest(3, nums , pq);
        System.out.println(addvalue(3 , pq, k));
        System.out.println(addvalue(5 , pq, k));
        System.out.println(addvalue(10 , pq, k));
        System.out.println(addvalue(9 , pq, k));
        System.out.println(addvalue(4, pq, k));

    }
    public static void  KthLargest (int k, int[] nums , PriorityQueue <Integer> pq ) {
    
       
        for(int val : nums){
            addvalue(val , pq , k);
        }
    }
    
    public static int addvalue(int val ,PriorityQueue <Integer> pq , int k  ) {
        pq.add(val);


        if(pq.size()>k){
            pq.peek();
            
            pq.remove();
        }
        return pq.peek();
        } 
}
