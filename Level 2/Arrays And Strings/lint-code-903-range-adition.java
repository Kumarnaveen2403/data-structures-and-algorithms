public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        
        int[] arr = new int[length];

        for(int[] update : updates){
            int s = update[0];
            int e = update[1];
            int val = update[2];

            arr[s] += val;
            if(e + 1 < arr.length){
                arr[e + 1] += -val;
            }
        }

        int total = 0;
        for(int i = 0; i < arr.length; i++){
            total += arr[i];

            arr[i] = total;
        }

        return arr;

    }
}