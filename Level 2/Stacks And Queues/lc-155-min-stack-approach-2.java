class MinStack {

    private Stack<Long> data;
    private Long min;
    
    public MinStack() {
        data = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long val1 = val;
        
        if(data.size() == 0){
            data.push(val1);
            min = val1;
        } else if(val1 >= min){
            data.push(val1);
        } else if(val1 < min){
            data.push(2 * val1 - min);
            min = val1;
        }
    }
    
    public void pop() {
        if(data.peek() < min){
            min = 2 * min - data.peek();
            data.pop();
        } else {
            data.pop();
        }
        
        if(data.size() == 0){
            min = Long.MAX_VALUE;
        }
    }
    
    public int top() {
        if(data.peek() <= min){
            return min.intValue();
        } else {
            return data.peek().intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */