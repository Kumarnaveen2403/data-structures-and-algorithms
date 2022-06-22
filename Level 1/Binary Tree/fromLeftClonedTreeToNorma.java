  public static Node transBackFromLeftClonedTree(Node node){
    if(node == null){
        return null;
    }

    Node left = transBackFromLeftClonedTree(node.left.left);
    Node right = transBackFromLeftClonedTree(node.right);

    node.left = left;
    
    return node;
  }