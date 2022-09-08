class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add("1");
        
        for(int i = 0; i < N; i++){
            String top = queue.remove();
            ans.add(top);
            
            queue.add(top + "0");
            queue.add(top + "1");
        }
        
        return ans;
    }
    
}
