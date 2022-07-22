class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] fmap = new int[60];
        int pairs = 0;
        
        for(int i = 0; i < time.length; i++){
            int val = time[i] % 60;
            
            if(val == 0){
                pairs += fmap[0];
            } else {
                pairs += fmap[60 - val];
            }
            
            fmap[val]++;
        }
        
        return pairs;
    }
}