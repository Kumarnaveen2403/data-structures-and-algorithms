class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        Stack<Character> st = new Stack<>();
        boolean[] ais = new boolean[26];
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;
            
            if(ais[ch - 'a'] == false){
                while(st.size() > 0 && freq[st.peek() - 'a'] > 0 && ch < st.peek()){
                    ais[st.peek() - 'a'] = false;
                    st.pop();
                }

                st.push(ch);
                ais[ch - 'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
        
    }
}