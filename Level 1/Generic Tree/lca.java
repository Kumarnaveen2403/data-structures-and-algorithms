  public static int lca(Node node, int d1, int d2) {
    ArrayList<Integer> l1 = nodeToRootPath(node, d1);
    ArrayList<Integer> l2 = nodeToRootPath(node, d2);
    
    int i = l1.size() - 1;
    int j = l2.size() - 1;
    int latestAncestor = -1;

    while(i >= 0 && j >= 0){
        if(l1.get(i) == l2.get(j)){
            latestAncestor = l1.get(i);
        } else {
            break;
        }

        i--;
        j--;
    }

    return latestAncestor;
  }