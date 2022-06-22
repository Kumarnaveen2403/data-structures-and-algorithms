static class Pair implements Comparable<Pair>{
    int data;
    int li;
    int ci;

    Pair(int data, int li, int ci){
        this.data = data;
        this.li = li;
        this.ci = ci;
    }

    public int compareTo(Pair pair){
        return (this.data - pair.data);
    }
}

public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Pair> pq = new PriorityQueue<>();

    for(int i = 0; i < lists.size(); i++){
        Pair pair = new Pair(lists.get(i).get(0), i, 0);
        pq.add(pair);
    }
    
    while(pq.size() > 0){
        Pair smallest = pq.peek();
        pq.remove();


        if(smallest.ci + 1 < lists.get(smallest.li).size()){
            int data = lists.get(smallest.li).get(smallest.ci + 1);
            int li = smallest.li;
            int ci = smallest.ci + 1;

            Pair newPair = new Pair(data, li, ci);
            pq.add(newPair);
        }

        rv.add(smallest.data);
    }

      return rv;
}