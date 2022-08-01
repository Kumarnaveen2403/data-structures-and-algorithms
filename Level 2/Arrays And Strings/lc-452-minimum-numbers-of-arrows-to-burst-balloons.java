class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,
             (a, b) -> {
                 if(a[0] < b[0]){
                     return -1;
                 } else if(a[0] > b[0]){
                     return 1;
                 } else {
                     return 0;
                 }
             }       
        );
        
        int shots = 1;
        int[] currRange = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for(int[] point : points){
            if(point[0] <= currRange[1]){
                currRange[0] = point[0];
                currRange[1] = Math.min(point[1], currRange[1]);
            } else {
                shots++;
                currRange = point;
            }
        }
        
        
        
        return shots;
    }
}