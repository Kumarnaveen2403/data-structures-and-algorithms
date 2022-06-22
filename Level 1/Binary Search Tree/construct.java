public static Node construct(int[] arr, int lo, int hi){
    if(lo > hi){
        return null;
    }

    int mid = (lo + hi) / 2;
    Node node = new Node();
    node.data = arr[mid];
    node.left = construct(arr, lo, mid - 1);
    node.right = construct(arr, mid + 1, hi);

    return node;
}