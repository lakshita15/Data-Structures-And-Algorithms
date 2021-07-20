package Level1;
import java.io.*;
import java.util.*;

public class FindAndNodeToRootPath {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

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

  public static boolean find(Node node, int data){
      if(node == null){
          return false;
      }
    if(node.data == data){
        return true;
    }
    if(find(node.left , data)==true){
        return true;
    }
    if(find(node.right , data)==true){
        return true;
    }
    return false;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    if (node == null) {
    return new ArrayList<>(); //agr null aagya to return an empty Al

  }
  if (node.data == data) {
    ArrayList list = new ArrayList<>(); //data mila to ek AL bnao
    list.add(node.data); // apne ko us AL me add krao
    return list; // and return krdo
  }
  //agr ni mila to call lga  do left side
  ArrayList llist = nodeToRootPath(node.left, data); //isme aayegi list
  if (llist.size() > 0) { 
 //agr ye list empty na hui to mtlb left me elemnt milgya to apne aap ko add krado and return
    llist.add(node.data);
    return llist;
  }
  //agr ni mila to call lga  do left side
  ArrayList rlist = nodeToRootPath(node.right, data);
  if (rlist.size() > 0) {
    //agr ye list empty na hui to mtlb right me elemnt milgya to apne aap ko add krado and return

    rlist.add(node.data);
    return rlist;
  }
  return new ArrayList<>();
  }

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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    boolean found = find(root, data);
    System.out.println(found);

    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
  }

}