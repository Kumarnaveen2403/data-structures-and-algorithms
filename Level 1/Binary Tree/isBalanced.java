//using travel and tweak
public static boolean balanced = true;
public static int isBalanced(Node node){
    if(node == null){
        return -1;
    }

    int lh = isBalanced(node.left);
    int rh = isBalanced(node.right);

    if(Math.abs(lh - rh) > 1){
        balanced = false;
    }

    int h = Math.max(lh, rh) + 1;

    return h;
}

//using heap mover
static class Mover{
    boolean isBalanced = true;
}

public static int isBalanced(Node node, Mover mover){
    if(node == null){
        return -1;
    }

    int lh = isBalanced(node.left, mover);
    int rh = isBalanced(node.right, mover);

    if(Math.abs(lh - rh) > 1){
        mover.isBalanced = false;
    }

    int h = Math.max(lh, rh) + 1;

    return h;
}