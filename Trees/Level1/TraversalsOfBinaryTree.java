package Level1;
import java.io.*;
import java.util.*;

public class TraversalsOfBinaryTree {
    //Make Node Class
    public static class Node{
        //data , left,right
        int data;
        Node left;
        Node right;
        Node(int data  ){
            this.data  =  data;
            // this.left = left;
            // this.right = right;
        }
    }

    //=========================================CONSTRUCT  FUNCTION
    //a classs pair to store node and state
    public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    public static Node construct(Integer[] input){
        Stack <Pair> st = new Stack<>();
        Node root = new Node(input[0]);

        st.push(new Pair(root, 1));
        int idx =1;
        while(st.size() > 0){
            //top find
            //check state 
            //find val and at the same time update state 

            Pair top = st.peek();
            if(top.state==1){
                //value find
                Integer val = input[idx++];
                if(val==null){
                    top.state++;
                }else{
                    //make new node
                    //store top ka left in this
                    //state++
                    //and push this new pair
                    Node newnode = new Node(val);
                    top.node.left = newnode;
                    top.state++;
                    st.push(new Pair(newnode , 1));
                }

            }else if(top.state==2){
                Integer val = input[idx++];
                if(val==null){
                    top.state++;
                }else{
                    //make new node
                    //store top ka right in this
                    //state++
                    //and push this new pair
                    Node newnode = new Node(val);
                    top.node.right = newnode;
                    top.state++;
                    st.push(new Pair(newnode , 1));
                }
            }else if(top.state ==3){
                st.pop();
            }
        }
        return root;
    }
    //===============================display

    public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
      }
      //================================TRAVERSALS
      public static void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" -> ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void postorder(Node node){
      if(node == null){
          return;
      }
      postorder(node.left);
      postorder(node.right);
      System.out.print(node.data+" -> ");
    }
    public static void inorder(Node node){
      if(node == null){
          return;
      }
      inorder(node.left);
      System.out.print(node.data+" -> ");
      inorder(node.right);
    }
    public static void traversals(Node node){
      System.out.print("pre : ");
      preorder(node);
      System.out.print(".\nin :");
      inorder(node);
      System.out.print(".\npost :");
      postorder(node);
      System.out.println(".");
    
          
     }
      //================================MAIN
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        Node root = construct(arr);
        traversals(root);
      }
}
