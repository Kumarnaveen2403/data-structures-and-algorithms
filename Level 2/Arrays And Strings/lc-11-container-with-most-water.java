class Solution {
    public int maxArea(int[] height) {
        int li = 0;
        int ri = height.length - 1;
        int area = 0;
        
        while(li < ri){
            int tempArea = Math.min(height[li], height[ri]) * (ri - li);
            
            if(tempArea > area){
                area = tempArea;
            }
            
            if(height[li] < height[ri]){
                li++;
            } else {
                ri--;
            }
        }
        
        
        return area;
    }
}