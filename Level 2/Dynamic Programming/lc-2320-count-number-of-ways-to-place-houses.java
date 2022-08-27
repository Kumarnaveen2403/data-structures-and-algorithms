class Solution {
    int MOD = 1000000000 + 7;
    public int countHousePlacements(int n) {
        long house = 1;
        long space = 1;
        
        for(int i = 2; i <= n; i++){
            long nHouses = space % MOD;
            long nSpaces = (house + space) % MOD;
            
            house = nHouses;
            space = nSpaces;
        }
        
        long res = (house + space) % MOD;
        
        return (int)((res * res) % MOD);
    }
}