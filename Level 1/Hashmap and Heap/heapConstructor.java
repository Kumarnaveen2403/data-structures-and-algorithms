    public MyPriorityQueue(int[] arr) {
        data = new ArrayList<>();
        for(int val : arr){
            data.add(val);
        }

        for(int i = (data.size() / 2 ) - 1; i >= 0; i--){
            downheapify(i);
        }
    }