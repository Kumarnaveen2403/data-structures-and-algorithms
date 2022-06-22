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
  
  public static class HeapMover{
      int max = Integer.MIN_VALUE;
      int secondMax = Integer.MIN_VALUE;
  }

  public static void secondLargest(Node node, int depth, HeapMover mover){
    if(mover.max < node.data){
        mover.max = node.data;
    }

    if(mover.secondMax < node.data){
        mover.max = node.data;
    }

      for(Node child : node.children){
          multiSolverWithHeap(child, depth + 1, mover);
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
    HeapMover mover = new HeapMover();
    secondLargest(root, 0, mover);
    
    System.out.println(mover.max);
    System.out.println(mover.secondMax);

  }

}