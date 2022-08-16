class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "$" + new StringBuilder(s).reverse();
        
        int[] lps = getLPS(str);
        
        int idx = lps[lps.length - 1];
        return new StringBuilder(s.substring(idx)).reverse().toString() + s;
    }
    
    public int[] getLPS(String str){
        int len = 0, i = 1;
        int[] lps = new int[str.length()];
        
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(len)){
                
                lps[i] = len + 1;
                len++;
                i++;
                
            } else if(len != 0){
                len = lps[len - 1];
            } else {
                i++;
            }
        }
        
        return lps;
    }
}