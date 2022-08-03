class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int li;
        int ei;
        
        Pair(int val, int li, int ei){
            this.val = val;
            this.li = li;
            this.ei = ei;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.size(); i++){
            pq.add(new Pair(nums.get(i).get(0), i, 0));
            
            max = Math.max(max, nums.get(i).get(0));
        }
        
        int range = Integer.MAX_VALUE;
        int min = 0;
        while(pq.size() == nums.size()){
            Pair top = pq.remove();
            if( (max - top.val) < range){
                range = max - top.val;
                min = top.val;
            }
            
            if(top.ei + 1 < nums.get(top.li).size()){
               pq.add(new Pair(nums.get(top.li).get(top.ei + 1), top.li, top.ei + 1));
               if(nums.get(top.li).get(top.ei + 1) > max){
                   max = nums.get(top.li).get(top.ei + 1);
               }
            }
   
        }
        
        return new int[]{min, range + min};
    }
}