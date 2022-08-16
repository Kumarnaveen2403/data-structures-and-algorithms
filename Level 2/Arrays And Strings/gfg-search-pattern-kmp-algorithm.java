class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        int[] lps = getLPS(pat);
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == pat.length()){
                    res.add(i - j + 1);
                    j = lps[j - 1];
                }
            } else if(j == 0){
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        
        return res;
    }
    
    public int[] getLPS(String txt){
        
        int[] lps = new int[txt.length()];
        
        int i = 1;
        int len = 0;
        
        while(i < lps.length){
            if(txt.charAt(i) == txt.charAt(len)){
                
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