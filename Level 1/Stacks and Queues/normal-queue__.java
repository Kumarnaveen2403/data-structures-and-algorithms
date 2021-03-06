public class queue {

    // class variables
    private int[] arr;
    private int sizeOfArray = 0;
    private int sizeOfQueue = 0;
    private int front = 0;
    private int back = 0;

    // constructor
    public queue() {
        this.initilize(5);
    }

    public queue(int size) {
        this.initilize(size);
    }

    public void initilize(int size) {
        this.arr = new int[size];
        this.sizeOfArray = size;
        this.sizeOfQueue = 0;
        this.front = 0;
        this.back = 0;
    }

    // exceptions
    private void queueIsFullException() throws Exception {
        if (this.sizeOfArray == this.sizeOfQueue)
            throw new Exception("queueIsFull");
    }

    private void queueIsEmptyException() throws Exception {
        if (this.sizeOfQueue == 0)
            throw new Exception("queueIsEmpty");
    }

    // basic
    public boolean isEmpty() {
        return this.sizeOfQueue == 0;
    }

    public int size() {
        return this.sizeOfQueue;
    }

    public void display(){
        int i = this.front;
        while(i != this.back){
            System.out.println(this.arr[i]);
            i = (i + 1) % this.sizeOfArray;
        }

    }

    // functions

    public void push(int val) throws Exception {
        queueIsFullException();
        this.arr[this.back] = val;
        this.back = (this.back + 1) % sizeOfArray;
        this.sizeOfQueue++;
    }

    public int pop() throws Exception {
        queueIsEmptyException();
        int val = this.front();
        this.arr[this.front] = 0;
        this.front = (this.front + 1) % sizeOfArray;
        this.sizeOfQueue--;

        return val;
    }

    public int front() throws Exception {
        queueIsEmptyException();
        return this.arr[this.front];
    }
}