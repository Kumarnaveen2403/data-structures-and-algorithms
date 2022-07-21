class Solution {
    public int maxDistToClosest(int[] seats) {
      
        int maxDist = 0;
        int i = 0, j = -1;
        
        while(i < seats.length){
            if(seats[i] == 1){
                if(j == -1){
                    maxDist = Math.max(maxDist, i);
                    j = i;
                } else {
                    maxDist = Math.max(maxDist, (i - j) / 2 );
                    j = i;
                }
            }
                          
            i++;
        }
                          
        maxDist = Math.max(maxDist, i - j - 1);
        
        return maxDist;
 
    }
}