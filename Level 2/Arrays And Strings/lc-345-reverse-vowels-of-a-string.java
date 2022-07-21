class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder str = new StringBuilder(s);
        String check = "aeiouAEIOU";
        
        while(i < j){
            while(i < j && check.indexOf(str.charAt(i)) == -1){
                i++;
            } 
        
            while(i < j && check.indexOf(str.charAt(j)) == -1){
                j--;
            }
             
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
                  
            i++;
            j--;
            
        }
                  
        return str.toString();
    }
}