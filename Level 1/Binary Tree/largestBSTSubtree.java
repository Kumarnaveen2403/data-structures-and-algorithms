static class Mover{
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean isBST = true;
    Node lsr = null;
    int numOfNodes = 0;
    int numOfNodesOfBST = 0;
}
public static Mover largestBSTSubtree(Node node){
    if(node == null){
        Mover m = new Mover();
        return m;
    }

    Mover lm = largestBSTSubtree(node.left);
    Mover rm = largestBSTSubtree(node.right);
    
    Mover mm = new Mover();

    mm.min = Math.min(Math.min(lm.min, rm.min), node.data);
    mm.max = Math.max(Math.max(lm.max, rm.max), node.data);

    if(node.data > lm.max && node.data < rm.min && lm.isBST == true && rm.isBST == true){
        mm.isBST = true;
    } else {
        mm.isBST = false;
    }

    mm.numOfNodes = lm.numOfNodes + rm.numOfNodes + 1;

    if(mm.isBST == true){
        mm.lsr = node;
        mm.numOfNodesOfBST = mm.numOfNodes;
    }

    return mm;
}