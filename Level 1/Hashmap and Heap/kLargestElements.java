      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here

      PriorityQueue<Integer> pq = new PriorityQueue<>();

      for(int i = 0; i < arr.length; i++){
          if(pq.size() < k){
              pq.add(arr[i]);
          } else {
              if(arr[i] > pq.peek()){
                  pq.add(arr[i]);
                  pq.remove();
              }
          }
      }

      for(int i = 0; i < k; i++){
          System.out.println(pq.peek());
          pq.remove();
      }
      