  public static boolean find(Node node, int data){
      if(node == null){
          return false;
      }

      if(node.data == data){
          return true;
      }

      boolean foundInLeft = find(node.left, data);
      if(foundInLeft == true){
          return true;
      }

      boolean foundInRight = find(node.right, data);
      if(foundInRight == true){
          return true;
      }

      return false;
    
  }
  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
      if(node == null){
          ArrayList<Integer> list = new ArrayList<>();
          return list;
      }
      
      if(node.data == data){
          ArrayList<Integer> list = new ArrayList<>();
          list.add(node.data);
          return list;
      }

      ArrayList<Integer> llist = nodeToRootPath(node.left, data);
      if(llist.size() > 0){
          llist.add(node.data);
          return llist;
      }

      ArrayList<Integer> rlist = nodeToRootPath(node.right, data);
      if(rlist.size() > 0){
          rlist.add(node.data);
          return rlist;
      }

      return new ArrayList<Integer>();
      
  }