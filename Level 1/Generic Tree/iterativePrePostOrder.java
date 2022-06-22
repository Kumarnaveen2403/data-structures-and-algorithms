 static class Pair{
    Node node;
    int state; 
 }
 
  public static void IterativePreandPostOrder(Node node) {
      
      String preorder = "";
      String postorder = "";

      Stack<Pair> stack = new Stack<Pair>();
      Pair rootp = new Pair();
      rootp.node = node;
      rootp.state = -1;
      stack.push(rootp);

      while(stack.size() != 0){
          Pair peekp = stack.peek();

          if(peekp.state == -1){
              preorder += peekp.node.data + " ";
              peekp.state++;
          } else if(peekp.state >= 0 && peekp.state < peekp.node.children.size()){
              Pair childp = new Pair();
              childp.state = -1;
              childp.node = peekp.node.children.get(peekp.state);
              stack.push(childp);
              peekp.state++;
          } else if(peekp.state == peekp.node.children.size()){
              postorder += peekp.node.data + " ";
              peekp.state++;
          } else {
              stack.pop();
          }

      }

      System.out.println(preorder);
      System.out.println(postorder);

    }