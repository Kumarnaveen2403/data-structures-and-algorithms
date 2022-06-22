import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    long spaceAtLast = 1;
    long buildingAtLast = 1;

    for(int i = 0; i < n - 1; i++){
        long newBuildingAtLast = spaceAtLast;
        long newSpaceAtLast = spaceAtLast + buildingAtLast;

        buildingAtLast =  newBuildingAtLast;
        spaceAtLast = newSpaceAtLast;
    }

    System.out.println((buildingAtLast + spaceAtLast) * (buildingAtLast + spaceAtLast));
 }

}