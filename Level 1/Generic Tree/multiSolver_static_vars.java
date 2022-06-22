import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  static int sum = 0;
  static int height = -1;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;

  public static void multiSolverWithStaticVars(Node node, int depth){
      sum += node.data;
      if(height < depth){
          height = depth;
      }

    if(min > node.data){
        min = node.data;
    }

    if(max < node.data){
        max = node.data;
    }
    
      for(Node child : node.children){
          multiSolverWithStaticVars(child, depth + 1 );
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    multiSolverWithStaticVars(root, 0);
    
    System.out.println(sum);
    System.out.println(height);
    System.out.println(max);
    System.out.println(min);

  }

}