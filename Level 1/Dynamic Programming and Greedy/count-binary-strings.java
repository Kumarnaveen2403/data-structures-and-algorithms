import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int strEndingWithOne = 1;
    int strEndingWithZero = 1;

    for(int i = 0; i < n - 1; i++){
        int newStrOfZero = strEndingWithOne;
        int newStrOfOne = strEndingWithOne + strEndingWithZero;

        strEndingWithZero =  newStrOfZero;
        strEndingWithOne = newStrOfOne;
    }

    System.out.println(strEndingWithOne + strEndingWithZero);
 }

}