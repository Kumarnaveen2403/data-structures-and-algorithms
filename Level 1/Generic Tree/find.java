  public static boolean find(Node node, int data) {
     if(node.data == data){
         return true;
     }

     for(Node child : node.children){
         boolean found = find(child, data);
         if(found == true){
             return true;
         }
     }

    return false;

 }