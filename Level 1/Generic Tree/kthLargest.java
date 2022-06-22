  static int largest = Integer.MIN_VALUE;

  public static void floor(Node node, int criteria){
      if(node.data < criteria){
          if(largest < node.data){
              largest = node.data;
          }
      }

      for(Node child : node.children){
          floor(child, criteria);
      }
  }

int klargest = Integer.MAX_VALUE;
for(int i = 0; i < k; i++){
    floor(root, klargest);
    klargest = largest;
    largest = Integer.MIN_VALUE;
}