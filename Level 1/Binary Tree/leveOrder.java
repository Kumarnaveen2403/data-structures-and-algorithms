  public static void levelOrder(Node node) {
      Queue<Node> q = new ArrayDeque<>();
      Queue<Node> q2 = new ArrayDeque<>();

    q.add(node);

    while(q.size() > 0){
        Node top = q.remove();
        if(top.left != null){
            q2.add(top.left);
        }

        System.out.print(top.data + " ");

        if(top.right != null){
            q2.add(top.right);
        }


        if(q.size() == 0){
            q = q2;
            q2 = new ArrayDeque<>();
            System.out.println();
        }

    }
  }