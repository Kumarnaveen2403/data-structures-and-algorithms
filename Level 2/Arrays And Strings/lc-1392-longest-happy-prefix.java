class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int len = 0, i = 1;
        
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else if(len == 0) {
                lps[i] = len;
                i++;
            } else {
                len = lps[len - 1];
            }
        }
        
        return s.substring(0, lps[lps.length - 1]);
    }
}