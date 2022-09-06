class MinStack {
    
    private Stack<Integer> data;
    private Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        data.push(val);
        
        if(min.size() == 0){
            min.push(val);
        } else if(val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        if(data.size() > 0 && data.peek().equals(min.peek()) ){
            data.pop();
            min.pop();
        } else if(data.size() > 0){
            data.pop();
        }
    }
    
    public int top() {
        if(data.size() > 0){
            return data.peek();
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        return min.peek();
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