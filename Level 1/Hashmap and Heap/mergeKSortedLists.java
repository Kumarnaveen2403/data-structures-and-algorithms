   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Integer> pq = new PriorityQueue<>();

      for(int i = 0; i < lists.size(); i++){
          for(int j = 0; j < lists.get(i).size(); j++){
              int val = lists.get(i).get(j);
              pq.add(val);
          }
      }
      
      while(pq.size() > 0){
          int val = pq.peek();
          pq.remove();

          rv.add(val);
      }

      return rv;
   }