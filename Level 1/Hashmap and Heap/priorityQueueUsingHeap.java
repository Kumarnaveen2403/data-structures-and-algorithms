  public static class MyPriorityQueue {
    ArrayList<Integer> data;

    public MyPriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
        data.add(val);
        upheapify(data.size() - 1);
    }

    public void upheapify(int idx){
        if(idx == 0){
            return;
        }

        int p = (idx - 1) / 2;

        if(data.get(p) > data.get(idx)){
            swap(p, idx);
            upheapify(p);
        }
    }

    public int remove() {
        if(data.size() == 0){
            System.out.println("Underflow");
            return -1;
        }

        swap(0, data.size() - 1);

        int val = data.remove(data.size() - 1);

        downheapify(0);

        return val;
    }

    public void downheapify(int idx){
        int mini = idx;

        int c1 = 2 * idx + 1;
        if(c1 < data.size() && data.get(c1) < data.get(mini)){
            mini = c1;
        }

        int c2 = 2 * idx + 2;
        if(c2 < data.size() && data.get(c2) < data.get(mini)){
            mini = c2;
        }

        if(mini != idx){
            swap(idx, mini);
            downheapify(mini);
        }
    }

    public int peek() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      return data.size();
    }

    public void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);
    }
  }
