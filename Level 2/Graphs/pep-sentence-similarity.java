import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));
  }

  static HashMap<String, String> parent;
  static HashMap<String, Integer> rank;

  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
      parent = new HashMap<>();
      rank = new HashMap<>();
      
      for(String[] pair : pairs){
          String w1 = pair[0];
          String w2 = pair[1];
          
          if(parent.containsKey(w1) == false){
              parent.put(w1, w1);
              rank.put(w1, 0);
          }
          
          if(parent.containsKey(w2) == false){
              parent.put(w2, w2);
              rank.put(w2, 0);
          }
      }
      
      for(String[] pair : pairs){
          String w1 = pair[0];
          String w2 = pair[1];
          
          String leadW1 = find(w1);
          String leadW2 = find(w2);
          
          if(leadW1.equals(leadW2) == false){
              union(leadW1, leadW2);
          }
          
      }
      
      if(Sentence1.length != Sentence2.length){
          return false;
      }
      
      for(int i = 0; i < Sentence1.length; i++){
        String s1 = Sentence1[i];
        String s2 = Sentence2[i];
        
        if(s1.equals(s2) == true){
            continue;
        } else if(parent.containsKey(s1) == false || parent.containsKey(s2) == false){
            return false;
        }
        
        String s1Lead = find(s1);
        String s2Lead = find(s2);
        
        if(s1Lead.equals(s2Lead) == false){
            return false;
        }
      }
      
      return true;
  }
  
  public static void union(String s1, String s2){
      if(rank.get(s1) < rank.get(s2)){
        parent.put(s1, s2);
      } else if(rank.get(s2) < rank.get(s1)){
          parent.put(s2, s1);
      } else {
          parent.put(s2, s1);
          rank.put(s1, rank.getOrDefault(s1, 0) + 1);
      }
  }
  
  public static String find(String word){
      if(parent.get(word).equals(word) == true){
          return word;
      } else {
          String par = find(parent.get(word));
          parent.put(word, par);
          return par;
      }
  }

}
