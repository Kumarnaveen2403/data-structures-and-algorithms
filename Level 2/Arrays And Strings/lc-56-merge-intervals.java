class Solution {
    class Pair {
        int start;
        int end;
        
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, 
            (int[] a, int[] b) -> a[0] - b[0]
        );
        
        Stack<Pair> st = new Stack<>();
        
        for(int[] pair : intervals){
            if(st.size() > 0){
                Pair peek = st.peek();
                if(peek.end >= pair[0]){
                    st.pop();
                    st.push( new Pair(peek.start, Math.max(pair[1], peek.end) ) );
                } else {
                    st.push(new Pair(pair[0], pair[1]));
                }
            } else {
                st.push(new Pair(pair[0], pair[1]));
            }
        }
        
        int[][] ans = new int[st.size()][2];
        
        for(int i = ans.length - 1; i >= 0; i--){
            Pair top = st.pop();
            ans[i][0] = top.start;
            ans[i][1] = top.end;
        }
        
        return ans;
    }
}