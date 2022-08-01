class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currSum = 0;
        int totalSum = 0;
        int sidx = 0;
        for(int i = 0; i < gas.length; i++){
            int delta = gas[i] - cost[i];
            
            currSum += delta;
            totalSum += delta;
            
            if(currSum < 0){
                sidx = i + 1;
                currSum = 0;
            }
        }
        
        return totalSum >= 0 ? sidx : -1;
    }
}