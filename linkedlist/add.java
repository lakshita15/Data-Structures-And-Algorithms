import java.io.*;
import java.util.*;

public class add {
    
 public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
 public static ListNode head;
   public static  void displayReverseHelper(ListNode node){
       if(node == null){
            return;
        }
        displayReverseHelper(node.next);
        
        System.out.print(node.val+" ");
    }

    public static void displayReverse(){
      displayReverseHelper(head.next);
      System.out.println();
    }    

    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       LinkedList<Integer> list = new LinkedList();
        for(int i=0;i<n;i++){
            list.add(n);
        }
      displayReverse();
      
      }
        
    }
       
      

