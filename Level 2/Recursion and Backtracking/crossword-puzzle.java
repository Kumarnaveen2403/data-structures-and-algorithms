import java.io.*;
import java.util.*;

public class Main {

  public static void solution(char[][] arr, String[] words, int vidx) {
   if(vidx == words.length){
        print(arr);
        return;    
   }
   
   String word = words[vidx];
   for(int i = 0; i < arr.length; i++){
       
       for(int j = 0; j < arr.length; j++){
           
           if(canPlaceVertically(arr, i, j, word) == true){
                boolean[] placed = new boolean[word.length()];
                placeVertically(arr, i, j, word, placed);
                solution(arr, words, vidx + 1);
                unplaceVertically(arr, i, j, placed);
           }
           
           if(canPlaceHorizontally(arr, i, j, word) == true){
                boolean[] placed = new boolean[word.length()];
                placeHorizontally(arr, i, j, word, placed);
                solution(arr, words, vidx + 1);
                unplaceHorizontally(arr, i, j, placed);
           }
       }
   }
  }
  
  static boolean canPlaceVertically(char[][] arr, int i, int j, String word){
      for(int k = 0; k < word.length(); k++){
          if( (i + k) >= arr.length){
            return false;
          } else if(arr[i + k][j] == '-' || arr[i + k][j] == word.charAt(k)){
            continue;
          } else {
              return false;
          }
      }
      
      return true;
  }
  
  static boolean canPlaceHorizontally(char[][] arr, int i, int j, String word){
      for(int k = 0; k < word.length(); k++){
          if( (j + k) >= arr.length){
            return false;
          } else if(arr[i][j + k] == '-' || arr[i][j + k] == word.charAt(k)){
            continue;
          } else{
              return false;
          }
      }
      
      return true;
  }
  
  static void placeVertically(char[][] arr, int i, int j, String word, boolean[] placed){
      for(int k = 0; k < word.length(); k++){
          if(arr[i + k][j] == '-'){
            arr[i + k][j] = word.charAt(k);
            placed[k] = true;
          } else {
              placed[k] = false;
          }
      }
  }
  
  static void unplaceVertically(char[][] arr, int i, int j, boolean[] placed){
      for(int k = 0; k < placed.length; k++){
          if(placed[k] == true){
              arr[i + k][j] = '-';
          }
      }
  }
  
  static void placeHorizontally(char[][] arr, int i, int j, String word, boolean[] placed){
      for(int k = 0; k < word.length(); k++){
          if(arr[i][j + k] == '-'){
            arr[i][j + k] = word.charAt(k);
            placed[k] = true;
          } else {
              placed[k] = false;
          }
      }
  }
  
  static void unplaceHorizontally(char[][] arr, int i, int j, boolean[] placed){
      for(int k = 0; k < placed.length; k++){
          if(placed[k] == true){
              arr[i][j + k] = '-';
          }
      }
  }


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}