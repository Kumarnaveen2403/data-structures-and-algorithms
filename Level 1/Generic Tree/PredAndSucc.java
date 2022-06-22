 static Node predecessor = null;
 static Node successor = null;
 static int state = 0;

public static void predecessorAndSuccessor(Node node, int data) {
    if(state > 0){
        state++;
    }

    if(node.data == data){
       state = 1;
    }

    if(state > 2){
        return;
    }

    if(state == 2){
        successor = node;
    }

    if(state == 0){
        predecessor = node;
    }

    for(Node child : node.children){
        predecessorAndSuccessor(child, data);
    }
}