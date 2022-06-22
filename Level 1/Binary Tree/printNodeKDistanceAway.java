  public static void printKLevelsDown(Node node, int k, Node blocker){
      if(node == null || k < 0 || node == blocker){
          return;
      }

      if(k == 0){
          System.out.println(node.data);
          return;
      }

    printKLevelsDown(node.left, k - 1, blocker);
    printKLevelsDown(node.right, k - 1, blocker);
  } 

    public static ArrayList<Node> nodeToRootPath(Node node, int data){
      if(node == null){
          ArrayList<Node> list = new ArrayList<>();
          return list;
      }
      
      if(node.data == data){
          ArrayList<Node> list = new ArrayList<>();
          list.add(node);
          return list;
      }

      ArrayList<Node> llist = nodeToRootPath(node.left, data);
      if(llist.size() > 0){
          llist.add(node);
          return llist;
      }

      ArrayList<Node> rlist = nodeToRootPath(node.right, data);
      if(rlist.size() > 0){
          rlist.add(node);
          return rlist;
      }

      return new ArrayList<Node>();
      
  }
  
  public static void printKNodesFar(Node node, int data, int k) {
      ArrayList<Node> list = nodeToRootPath(node, data);

      for(int i = 0; i < list.size(); i++){
          Node blocker = i == 0 ? null : list.get(i-1);
          printKLevelsDown(list.get(i), k - i, blocker);
      }
  }