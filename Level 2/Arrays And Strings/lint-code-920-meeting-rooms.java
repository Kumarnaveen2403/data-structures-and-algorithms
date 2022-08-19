/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() <= 1){
            return true;
        }

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int i = 0;
        for(Interval invl : intervals){
            start[i] = invl.start;
            end[i] = invl.end;

            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        i = 0;
        int j = 0;
        int rooms = 0;
        int max = 0;
        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                i++;
                rooms++;
            } else {
                j++;
                rooms--;
            }

            if(rooms > 1){
                return false;
            }
        }

        return true;

    }
}