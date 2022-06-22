  public static int size(Node node) {
    if(node == null){
      return 0;
    }

    int leftSize = size(node.left);
    int rightSize = size(node.right);

    return leftSize + rightSize + 1;
//  return (node == null ? 0 : size(node.left) + size(right) + 1);
  }

  public static int sum(Node node) {
    if(node == null){
      return 0;
    }

    int leftSum = sum(node.left);
    int rightSum = sum(node.right);

    return leftSum + rightSum + node.data;
//  return (node == null ? 0 : sum(node.left) + sum(right) + node.data);

  }

  public static int max(Node node) {
    if(node == null){
      return Integer.MIN_VALUE;
    }
    
    int leftMax = max(node.left);
    int rightMax = max(node.right);

    int newMax = leftMax > rightMax ? leftMax :  rightMax;

    if(newMax > node.data){
      return newMax;
    } else {
      return node.data;
    }
  }

  public static int height(Node node) {
    if(node == null){
      return -1;
    }

    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    if(leftHeight > rightHeight){
      return leftHeight + 1;
    } else {
      return rightHeight + 1;
    }
  }