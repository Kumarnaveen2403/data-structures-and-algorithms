  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
      if(left.size() > 0 && val < left.peek()){
          left.add(val);
      } else if(right.size() > 0 && val > right.peek()){
          right.add(val);
      } else {
          left.add(val);
      }

      if(Math.abs(left.size() - right.size()) >= 2){
        if(left.size() > right.size()){
			int temp = left.remove();
			right.add(temp);
        } else {
			int temp = right.remove();
			left.add(temp);
        }
      }
    }

    public int remove() {
		if(this.size() == 0){
			System.out.println("Underflow");
			return -1;
		}
	  if(left.size() > right.size()){
		  int val = left.remove();
		  return val;
	  } else if(left.size() < right.size()) {
		  int val = right.remove();
		  return val;
	  } else {
		  int val = left.remove();
		  return val;
	  }
    }

    public int peek() {
		if(this.size() == 0){
			System.out.println("Underflow");
			return -1;
		}

	  if(left.size() > right.size()){
		  int val = left.peek();
		  return val;
	  } else if(left.size() < right.size()) {
		  int val = right.peek();
		  return val;
	  } else {
		  int val = left.peek();
		  return val;
	  }
	  
    }

    public int size() {
      return left.size() + right.size();
    }
  }
