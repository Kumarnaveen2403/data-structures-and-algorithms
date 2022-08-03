public class Solution {
    public int solve(ArrayList<Integer> A) {
        int oddSum = 0;
        int evenSum = 0;
        
        for(int i = 0; i < A.size(); i++){
            if(i % 2 == 0){
                evenSum += A.get(i);
            } else {
                oddSum += A.get(i);
            }
        }
        
        int currEvenSum = 0;
        int currOddSum = 0;
        int count = 0;
        
        for(int i = 0; i < A.size(); i++){
            int res = evenSum - currEvenSum;
            int ros = oddSum - currOddSum;
            
            if(i % 2 == 0){
                int newEvenSum = currEvenSum + ros;
                int newOddSum = currOddSum + res - A.get(i);
                if(newEvenSum == newOddSum){
                    count++;
                }
                
                currEvenSum += A.get(i);
            } else {
                int newOddSum = currOddSum + res;
                int newEvenSum = currEvenSum + ros - A.get(i);
                if(newOddSum == newEvenSum){
                    count++;
                }
                
                currOddSum += A.get(i);
            }
            
        }
        
        return count;
    }
}
