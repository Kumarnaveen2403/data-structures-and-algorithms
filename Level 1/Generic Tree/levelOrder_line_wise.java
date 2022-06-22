  public static void levelOrderLinewise(Node node){
        Queue<Node> queue = new ArrayDeque<Node>();
        Queue<Node> cqueue = new ArrayDeque<Node>();
        queue.add(node);

        while(queue.size() > 0){
            Node temp = queue.remove();

            System.out.print(temp.data + " ");

            for(Node child : temp.children){
                cqueue.add(child);
            }

            if(queue.size == 0){
                queue = cqueue;
                cqueue = new ArrayDeque<>();
                System.out.println(".");
            }
            
        }

        System.out.println(".");
  }