static class Lpair {
    Node node;
    int state;
}
  public static void iterativePrePostInTraversal(Node node) {
      Stack<Lpair> stack = new Stack<>();
      Lpair rootpair = new Lpair();
      rootpair.node = node;
      rootpair.state = 1;
      stack.push(rootpair);

      String preOrder = "";
      String inOrder = "";
      String postOrder = "";

      while(stack.size() > 0){
          Lpair top = stack.peek();

          if(top.state == 1){
            //preorder

            preOrder += top.node.data + " ";

            if(top.node.left != null){
                Lpair lpair = new Lpair();
                lpair.node = top.node.left;
                lpair.state = 1;
                stack.push(lpair);
            }

            top.state++;

          } else if(top.state == 2){
              //inorder

            inOrder += top.node.data + " ";

             if(top.node.right != null){
                Lpair rpair = new Lpair();
                rpair.node = top.node.right;
                rpair.state = 1;
                stack.push(rpair);
            }

            top.state++;

          } else if(top.state == 3){
              //postorder

            postOrder += top.node.data + " ";
            stack.pop();

          }

      }

      System.out.println(preOrder);
      System.out.println(inOrder);
      System.out.println(postOrder);
      
  }