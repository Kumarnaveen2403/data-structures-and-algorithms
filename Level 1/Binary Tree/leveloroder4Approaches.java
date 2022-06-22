import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
    
    Node(){
        
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

  public static void levelOrder1(Node node) {
    // write your code here
    ArrayDeque<Node> pq = new ArrayDeque<>();
    ArrayDeque<Node> cq = new ArrayDeque<>();
    
    pq.add(node);
    while(pq.size() > 0){
        Node temp = pq.remove();
        System.out.print(temp.data + " ");
        
        if(temp.left != null){
            cq.add(temp.left);
        }
        
        if(temp.right != null){
            cq.add(temp.right);
        }
        
        if(pq.size() ==  0){
            pq = cq;
            cq = new ArrayDeque<>();
            System.out.println();
        }
    }
  }
  
   public static void levelOrder2(Node node) {
    // write your code here
    ArrayDeque<Node> pq = new ArrayDeque<>();
    pq.add(node);
    
    while(pq.size() > 0){
        int count = pq.size();
        
        for(int i = 0; i < count; i++){
            Node temp = pq.remove();
            System.out.print(temp.data + " ");
            
            if(temp.left != null){
                pq.add(temp.left);
            }
            
            if(temp.right != null){
                pq.add(temp.right);
            }
        }
        
        System.out.println();
    }
  }
  
  public static void levelOrder3(Node node) {
    // write your code here
    ArrayDeque<Node> pq = new ArrayDeque<>();
    pq.add(node);
    
    Node delim = new Node(-1, null, null);
    pq.add(delim);
    
    while(pq.size() > 0){
        Node temp = pq.remove();
        
        if(temp.data == -1){
            System.out.println();
            if(pq.size() > 0){
                pq.add(temp);
            }
            continue;
        }
        
        System.out.print(temp.data + " ");
        
        if(temp.left != null){
            pq.add(temp.left);
        }
        
        if(temp.right != null){
            pq.add(temp.right);
        }

    }
  }

  static class LPair{
    Node node;
    int level;
  }

  public static void levelOrder4(Node node){
    ArrayDeque<LPair> q = new ArrayDeque<>();
    LPair rootp = new LPair();
    rootp.node = node;
    rootp.level = 1;
    q.add(rootp);

    int level = 1;
    while(q.size() > 0){
      LPair top = q.remove();

      if(top.level != level){
        System.out.println();
        level = top.level;
      }
      
      System.out.print(top.node.data + " ");

      if(top.node.left != null){
        LPair lpair = new LPair();
        lpair.node = top.node.left;
        lpair.level = top.level + 1;
        q.add(lpair);
      }

       if(top.node.right != null){
        LPair rpair = new LPair();
        rpair.node = top.node.right;
        rpair.level = top.level + 1;
        q.add(rpair);
      }
    }
  }