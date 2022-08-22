class NumArray {
    
    class Node {
        int start;
        int end;
        
        Node left;
        Node right;
        
        int val;
    }

    Node root;
    
    Node construct(int[] nums, int lo, int hi){
        if(lo == hi){
            Node node = new Node();
            node.start = node.end = lo;
            node.val = nums[lo];
            return node;
        }
        
        Node node = new Node();
        
        int mid = (lo + hi) / 2;
        node.start = lo;
        node.end = hi;
        
        node.left = construct(nums, lo, mid);
        node.right = construct(nums, mid + 1, hi);
        
        node.val = node.left.val + node.right.val;
        
        return node;
        
    }
    
    public NumArray(int[] nums) {
        this.root = construct(nums, 0, nums.length - 1);
    }
    
    void update(Node root, int index, int val){
        if(root.start == root.end){
            root.val = val;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if(index <= mid){
            update(root.left, index, val);
        } else {
            update(root.right, index, val);
        }
        
        root.val = root.left.val + root.right.val;
    }
    
    void update(int index, int val) {
        update(root, index, val);
    }
    
    int query(Node root, int left, int right){
        if(root.start >= left && root.end <= right){
            return root.val;
        } else if(right < root.start || left > root.end){
            return 0;
        } else {
            int leftSum = query(root.left, left, right);
            int rightSum = query(root.right, left, right);
            
            return leftSum + rightSum;
        }
    }
    
    public int sumRange(int left, int right) {
        return query(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */