import java.io.*;
import java.util.*;

public class Main {

	public static class Item implements Comparable<Item>{
		int val;
		int wt;

		double vwRatio;

		public int compareTo(Item o){
			if(this.vwRatio > o.vwRatio){
				return 1;
			} else if(this.vwRatio == o.vwRatio){
				return 0;
			} else {
				return -1;
			}
		}
		
	}

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n  = scn.nextInt();

		Item[] items = new Item[n];
        
		for(int i = 0; i < n; i++){
			Item item = new Item();

			item.val = scn.nextInt();

			items[i] = item;
		}

		for(int i = 0; i < n; i++){
			items[i].wt =  scn.nextInt();

			items[i].vwRatio = (items[i].val * 1.0) / items[i].wt;
		}

		int cap = scn.nextInt();

		Arrays.sort(items);

		double maxVal = 0;

		for(int i = n - 1; i >= 0; i--){
			if(cap == 0){
				break;
			}

			if(cap - items[i].wt >= 0){
				cap -= items[i].wt;
	
				maxVal += items[i].val;
			} else {
				maxVal += (cap * items[i].val * 1.0 )/ items[i].wt; 

				cap = 0;
			}

		}

		System.out.println(maxVal);

		
	}

}