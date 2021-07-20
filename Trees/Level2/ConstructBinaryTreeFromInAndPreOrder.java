package Level2;
import java.io.*;
import java.util.Scanner;

public class ConstructBinaryTreeFromInAndPreOrder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    private static TreeNode buildTree(int[] preorder, int[] inorder , int psi , int pei , int isi , int iei) {
       if(psi >pei ){
           return null;
       }
       int val = preorder[psi];
       int idx = isi;
       while(inorder[idx]!=val){
           idx++;
       }
       int tnel = idx-isi;
       
       TreeNode node = new TreeNode(val);
       
       node.left = buildTree(preorder , inorder ,  psi +1 ,  psi+tnel ,  isi ,  idx-1);
       node.right = buildTree(preorder , inorder ,  psi+tnel+1 ,  pei ,  idx+1 ,  iei);
       
       return node;
        
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder , inorder ,  0 , preorder.length-1 ,  0 , inorder.length -1);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}