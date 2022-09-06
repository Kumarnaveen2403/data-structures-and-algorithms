class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < k; i++){
            st.push(q.remove());
        }
        
        ArrayDeque<Integer> ans = new ArrayDeque<>();
        int s = q.size();
        
        for(int i = 0; i < k; i++){
            ans.add(st.pop());
        }
        
        for(int i = 0; i < s; i++){
            ans.add(q.remove());
        }
        
        return ans;
    }
}
