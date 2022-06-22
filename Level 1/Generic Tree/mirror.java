   public static void mirror(Node node){
      if(node.children == null){
          return;
      }

      int i = 0;
      int j = node.children.size() - 1;
      while(i < j){
          Node left = node.children.get(i);
          Node right = node.children.get(j);

        //   Node temp = left;
          node.children.set(i, right);
          node.children.set(j, left);


          i++;
          j--;
      }

      for(Node child : node.children){
          mirror(child);
      }

  }