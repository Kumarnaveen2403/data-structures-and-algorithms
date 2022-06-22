static class BPair{
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean isBST = true;
}

public static BPair isBST(Node node){
    if(node == null){
        BPair p = new BPair();
        return p;
    }

    BPair lp = isBST(node.left);
    BPair rp = isBST(node.right);

    BPair mp = new BPair();

    mp.min = Math.min(Math.min(lp.min, rp.min), node.data);
    mp.max = Math.max(Math.max(lp.max, rp.max), node.data);

    if(node.data > lp.max && node.data < rp.min && lp.isBST == true && rp.isBST == true){
        mp.isBST = true;
    } else {
        mp.isBST = false;
    }
    
    return mp;
}