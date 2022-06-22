  static int sum = 0;
  public static void rwsol(Node node){
    if(node == null){
        return;
    }

    //right
    rwsol(node.right);

    int data = node.data;
    node.data = sum;
    sum += data;

    //left
    rwsol(node.left);
  }