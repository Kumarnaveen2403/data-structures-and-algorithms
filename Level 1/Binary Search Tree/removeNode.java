  public static int max(Node node) {
      if(node.right == null){
          return node.data; 
      }

      int max = max(node.right);

      return max;
  }

  public static Node remove(Node node, int data) {
    if(node == null){
        return null;
    }
    
    if(node.data < data){
        node.right = remove(node.right, data);
    } else if(node.data > data){
        node.left = remove(node.left, data);
    } else {
        if(node.left == null && node.right == null){
            return null;
        } else if(node.left == null && node.right != null){
            return node.right;
        } else if(node.left != null && node.right == null){
            return node.left;
        } else {
            int max = max(node.left);
            node.data = max;
            remove(node.left, max);
        }
    }

    return node;
  }