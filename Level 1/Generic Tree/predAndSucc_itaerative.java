static class HeapMover{
    static Node node;
    static Node predecessor;
    static Node successor;
    static int state;
    static int counter;
}
public static void predecessorAndSuccessor(Node node, int data) {
    Stack<HeapMover> stack = new Stack<HeapMover>();
    HeapMover mover = new HeapMover();
    mover.node = node;
    mover.state = -1;
    mover.counter = 0;
    stack.push(mover);

    while(stack.size() > 0){
        HeapMover top = stack.peek();

        if(top.node.data == data){
            counter = 1;
        } else if(counter == 1){
            counter = 2;
        }

        if(counter == 0){
            predecessor = top.node.data;
        }

        if(counter == 2){
            successor = top.node.data;
            counter++;
        }

        if(top.state == -1){
              top.state++;
          } else if(top.state >= 0 && top.state < top.node.children.size()){
              HeapMover childp = new HeapMover();
              childp.state = -1;
              childp.node = top.node.children.get(top.state);
              stack.push(childp);
              top.state++;
          } else if(top.state == top.node.children.size()){
              top.state++;
          } else {
              stack.pop();
          }

    }
}