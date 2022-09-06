class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(st.size() > 0){
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        
        Stack<Character> st2 = new Stack<>();
        
        for(char ch : t.toCharArray()){
            if(ch == '#'){
                if(st2.size() > 0){
                    st2.pop();
                }
            } else {
                st2.push(ch);
            }
        }
     
        while(st.size() > 0 && st2.size() > 0){
            if(st.peek() == st2.peek()){
                st.pop();
                st2.pop();
            } else {
                return false;
            }
        }
        
        if(st.size() == 0 && st2.size() == 0){
            return true;
        } else {
            return false;
        }
    }
}