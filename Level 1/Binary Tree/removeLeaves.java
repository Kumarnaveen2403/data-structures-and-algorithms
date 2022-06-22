  public static Node removeLeaves(Node node){
      if(node == null){
          return null;
      }

      if(node.left == null && node.right == null){
          return null;
      }

      Node left = removeLeaves(node.left);
      Node rigth = removeLeaves(node.right);

      node.left = left;
      node.right = rigth;
      return node;
  }