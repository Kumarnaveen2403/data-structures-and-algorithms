class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int[] interval = newInterval;
        
        while(i < intervals.length && intervals[i][1] < interval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        while(i < intervals.length && intervals[i][0] <= interval[1]){
            interval[0] = Math.min(interval[0], intervals[i][0]);
            interval[1] = Math.max(interval[1], intervals[i][1]);
            i++;
        }
        
        list.add(interval);
        
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}