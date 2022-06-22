  public static Node linearize(Node node){
      if(node.children.size() == 0){
        return node;
      }

      Node lastChild = node.children.get(node.children.size() - 1);
      Node lastTail = linearize(lastChild);

      while(node.children.size() > 1) {
        Node slastChild = node.children.get(node.children.size() - 2);
        Node slastTail = linearize(slastChild);

        slastTail.children.add(lastChild);
        node.children.remove(node.children.size() - 1);
        lastChild = slastChild;
      }

      return lastTail;

  }