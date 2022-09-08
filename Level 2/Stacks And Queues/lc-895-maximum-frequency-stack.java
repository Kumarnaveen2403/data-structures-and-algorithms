class FreqStack {
    
    private int maxFreq;
    private HashMap<Integer, Integer> fmap;
    private HashMap<Integer, Stack<Integer>> data;

    public FreqStack() {
        maxFreq = 0;
        fmap = new HashMap<>();
        data = new HashMap<>();
    }
    
    public void push(int val) {
        fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        
        if(fmap.get(val) > maxFreq){
            maxFreq = fmap.get(val);
        }
        
        if(data.containsKey(fmap.get(val)) == true){
           data.get(fmap.get(val)).push(val);
        } else {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            
            data.put(fmap.get(val), st);
        }
    }
    
    public int pop() {
        int ans = data.get(maxFreq).pop();
        
        if(data.get(maxFreq).size() == 0){
            maxFreq--;
        }
        
        fmap.put(ans, fmap.get(ans) - 1);        
        
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */