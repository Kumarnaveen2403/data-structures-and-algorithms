  public static Node add(Node node, int data) {
    if(node == null){
        Node newNode = new Node(data, null, null);
        return newNode;
    }

    if(node.data > data){
        node.left = add(node.left, data);
    } else if(node.data < data){
        node.right = add(node.right, data);
    }

    return node;
  }