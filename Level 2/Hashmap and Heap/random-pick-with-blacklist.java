class Solution {
    int n;
    int[] blacklist;
    
    HashMap<Integer, Integer> map;

    public Solution(int n, int[] blacklist) {
        this.n = n;
        this.blacklist = blacklist;
        
        map = new HashMap<>();
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int val : blacklist){
            set.add(val);
        }
        
        int lastVal = n - 1;
        int lastValidIdx = n - blacklist.length - 1;
        
        for(int i = 0; i < blacklist.length; i++){
            int val = blacklist[i];
            
            if(val <= lastValidIdx){
                while(set.contains(lastVal)){
                    lastVal--;
                }
                
                map.put(val, lastVal);
                set.add(lastVal);
            }
        }
        
    }
    
    public int pick() {
        int numOfVal = n - blacklist.length;
        int rand = (int)(Math.random() * numOfVal);
        
        if(map.containsKey(rand)){
            return map.get(rand);
        } else {
            return rand;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */