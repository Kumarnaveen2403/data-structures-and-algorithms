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

  static int ceil;
  static int floor;
  public static void ceilAndFloor1(Node node, int data) {
      if(node.data > floor && node.data < data){
          floor = node.data;
      }

      if(node.data < ceil && node.data > data){
          ceil = node.data;
      }

      for(Node child : node.children){
          ceilAndFloor1(child, data);
      }    
  }

  static class Mover {
      int ceil = Integer.MAX_VALUE;
      int floor = Integer.MIN_VALUE;
  }

  public static void ceilAndFloor2(Node node, int data, Mover mover){
      if(node.data < mover.ceil && node.data > data){
          mover.ceil = node.data;
      }

      if(node.data > mover.floor && node.data < data){
          mover.floor = node.data;
      }

      for(Node child : node.children){
          ceilAndFloor2(child, data, mover);
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;
    ceilAndFloor1(root, data);
    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
    

    Mover mover = new Mover();
    ceilAndFloor2(root, data, mover);
    System.out.println("Ceil " + mover.ceil);
    System.out.println("Floor " + mover.floor);
    
  }

}