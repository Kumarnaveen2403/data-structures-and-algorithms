/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int[] price = {30, 40, 60, 70};
        
        System.out.println(totalCost(price));
	}

    public static int totalCost(int[] price){
        
        Arrays.sort(price);
        int cost = 0;
        
        for(int i = price.length - 1; i >= 1; i -= 2){
            if(i == 1){
                cost += price[1];
            } else if(i == 2){
                cost += price[0] + price[1] + price[2];
            } else {
                int cost1 = price[i] + price[0] + price[i - 1] + price[0];
                int cost2 = price[1] + price[0] + price[i] + price[0];
                
                cost += Math.min(cost1, cost2);
            }
        }
        
        return cost;
    }
}