import java.util.*;

public class Main{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();

        Node(int data){
            this.data = data;
        }
    }

    public static void levelOrder(Node node){
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(node);

        while(queue.size() > 0){
            Node temp = queue.remove();
            System.out.print(temp.data + " ");

            for(Node child : temp.children){
                queue.add(child);
            }
        }

        System.out.println(".");
  }

  public static void levelOrderLinewise(Node node){
    Queue<Node> queue = new ArrayDeque<Node>();
    Queue<Node> cqueue = new ArrayDeque<Node>();
    queue.add(node);

    while(queue.size() > 0){
        Node temp = queue.remove();

        System.out.print(temp.data + " ");

        for(Node child : temp.children){
            cqueue.add(child);
        }

        if(queue.size() == 0){
            queue = cqueue;
            cqueue = new ArrayDeque<>();
            System.out.println(".");
        }
        
    }

    System.out.println(".");
  }

  public static void levelOrderLinewise2(Node node){
    LinkedList<Node> q = new LinkedList<>();
    q.addLast(node);
    
    while(q.size() != 0){
        int currSize = q.size();
        
        while(currSize-- > 0){
            Node rnode = q.removeFirst();
            System.out.print(rnode.data + " ");
            
            for(Node child : rnode.children){
                q.addLast(child);
            }
        }
        
        System.out.println();
    }
  }

  public static Node construct(int[] arr){
      Stack<Node> stack = new Stack<Node>();
      Node root = null;

      for(int i = 0; i < arr.length; i++){
          if(arr[i] == -1){
              Node temp = stack.pop();
              
              if(stack.size() == 0){
                  root = temp;
              } else {
                  Node top = stack.peek();
                  top.children.add(temp);
              }

          } else {
              Node temp = new Node(arr[i]);
              stack.push(temp);
          }
      }
      
      return root;
  }

  public static void serialize(Node root, ArrayList<Integer> data){

  }

  public static void levelOrderLinewiseZZ(Node node){
    LinkedList<Node> que = new LinkedList<>(); // addLast, removeFirst
    LinkedList<Node> st = new LinkedList<>();  // addFirst, removeFirst
    
    que.addLast(node);
    int level = 0;
    while(que.size() != 0){
        int currSize = que.size();
        while(currSize-->0){
         Node rnode = que.removeFirst();
         System.out.print(rnode.data + " ");
        if(level % 2 == 0){
            for(int i = 0; i < rnode.children.size();i++)
               st.addFirst(rnode.children.get(i));
        }else{
            for(int i = rnode.children.size() - 1; i >= 0; i--)
               st.addFirst(rnode.children.get(i));
        }
        }
        
        level++;
        System.out.println();
        LinkedList<Node> temp = que;
        que = st;
        st= temp;
    }
  }

  public static void main(String[] args){
    int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 
        80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

    Node root = construct(arr);

    ArrayList<Integer> list = new ArrayList<Integer>();
    serialize(root, list);

    System.out.println(list);

    levelOrderLinewiseZZ(root);
  }
}