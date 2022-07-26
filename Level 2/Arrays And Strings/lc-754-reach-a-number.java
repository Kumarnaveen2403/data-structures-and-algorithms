class Solution {
    public int reachNumber(int target) {
        
        target = Math.abs(target);
        
        int i = 0;
        while(true){
            int reach = i * (i + 1) / 2;
            
            if(target <= reach && target % 2 == reach % 2){
                break;
            }
            
            i++;
        }
        
        return i;
    }
}