    public static Node constructWithPost(Integer[] arr){
        Stack<Pair> stack = new Stack<>();
        Node root = new Node();
        root.data = arr[0];

        Pair rootp = new Pair();
        rootp.node = root;
        rootp.state = 1;

        stack.push(rootp);
        int idx = 1;

        while(stack.size() > 0){
            Pair peekp = stack.peek();

            if (peekp.state == 1){
                //left

                if(arr[idx] != null){
                    Node lc = new Node();
                    lc.data = arr[idx];
                    peekp.node.left = lc;

                    Pair lp = new Pair();
                    lp.node = lc;
                    lp.state = 1;

                    stack.push(lp);

                }

                peekp.state++;
                idx++;
                
            } else if (peekp.state == 2){
                //right

                if(arr[idx] != null){
                    Node rc = new Node();
                    rc.data = arr[idx];
                    peekp.node.right = rc;

                    Pair rp = new Pair();
                    rp.node = rc;
                    rp.state = 1;

                    stack.push(rp);

                }

                peekp.state++;
                idx++;

            } else if (peekp.state == 3){
                //pop
                stack.pop();
            }
        }

        return root;

    }
