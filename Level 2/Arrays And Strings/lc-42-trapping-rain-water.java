class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        for(int i = 0; i < height.length; i++){
            if(i == 0){
                left[i] = height[i];
            } else {
                left[i] = Math.max(height[i], left[i - 1]);
            }
        }
        
        for(int i = height.length - 1; i >= 0; i--){
            if(i == height.length - 1){
                right[i] = height[i];
            } else {
                right[i] = Math.max(height[i], right[i + 1]);
            }
        }
        
        int water = 0;
        for(int i = 0; i < height.length; i++){
            water += Math.min(left[i], right[i]) - height[i];
        }
        
        return water;
    }
}