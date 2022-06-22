  public static int size(Node node) {
      if(node == null){
          return 0;
      }

      int ls = size(node.left);
      int rs = size(node.right);

      return ls + rs + 1;
  }

  public static int sum(Node node) {
    if(node == null){
        return 0;
    }

    int ls = sum(node.left);
    int rs = sum(node.right);

    return ls + rs + node.data;
  }

  public static int max(Node node) {
      if(node.right == null){
          return node.data; 
      }

      int max = max(node.right);

      return max;
  }

  public static int min(Node node) {
    if(node.left == null){
          return node.data; 
      }
      
      int min = min(node.left);

      return min;
  }
