package Level2;

import java.util.Scanner;


import java.util.Scanner;

public class bstfrompost {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    
    static int bstidx;
    public static TreeNode bstFromPostorder(int[] pre , int lr , int rr) {
        if(bstidx <= -1|| pre[bstidx] < lr || pre[bstidx] > rr){
            return null;
        }
        TreeNode node = new TreeNode(pre[bstidx--]);
        node.right =bstFromPostorder(pre , node.val , rr);
        
        node.left = bstFromPostorder(pre , lr , node.val);
        
        return node;
        
    }
    public static TreeNode bstFromPostorder(int[] postorder) {
       bstidx = postorder.length-1;
       return bstFromPostorder(postorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}