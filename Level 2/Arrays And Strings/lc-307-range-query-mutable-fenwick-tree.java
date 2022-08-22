class NumArray {

    class Fenwick {
        int[] farr;
        
        public Fenwick(int[] nums){
            farr = new int[nums.length + 1];
            for(int i = 1; i < farr.length; i++){
                update(i, nums[i - 1]);
            }
        }
        
        private int rsb(int x){
            return x & -x;
        }
        
        public void update(int pos, int delta){
            while(pos < farr.length){
                farr[pos] += delta;
                pos += rsb(pos);
            }
        }
        
        public int sum(int pos){
            int s = 0;
            while(pos > 0){
                s += farr[pos];
                pos -= rsb(pos);
            }
            return s;
        }
    }
    
    Fenwick fen;
    int[] oarr;
    
    public NumArray(int[] nums) {
        fen = new Fenwick(nums);
        oarr = nums;
    }
    
    public void update(int index, int val) {
        int pos = index + 1;
        int delta = val - oarr[index];
        fen.update(pos, delta);
        oarr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int pl = left + 1;
        int pr = right + 1;
        
        int sumUptoRight = fen.sum(pr);
        int sumUptoLeft = fen.sum(pl - 1);
        
        return sumUptoRight - sumUptoLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */