  public static Node createLeftCloneTree(Node node){
      if(node == null){
          return null;
      }

      Node left = createLeftCloneTree(node.left);
      Node right = createLeftCloneTree(node.right);

      Node clone = new Node(node.data, left, null);
      node.left = clone;

      return node;
  }