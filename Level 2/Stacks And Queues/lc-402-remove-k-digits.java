class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : num.toCharArray()){
            
            while(k > 0 && st.size() > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            
            st.push(ch);
            
        }
        
        while(k > 0 && st.size() > 0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(st.size() > 0){
            sb.append(st.pop());
        }
        
        for(int i = sb.length() - 1; i >= 0; i--){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
        
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}