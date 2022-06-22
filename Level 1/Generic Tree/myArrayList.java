import java.util.*;

public class Main{
    public static class MyArrayList{
        int size = 0;
        int[] data;

        static final int DEFAULT_CAPACITY = 5;

        MyArrayList(){
            this(DEFAULT_CAPACITY);
        }

        MyArrayList(int cap){
            size = 0;
            data = new int[cap];
        }

        int get(int idx){
            if(idx < 0 || idx >= size){
                System.out.println("Invalid index");
                return -1;
            } else {
                return data[idx];
            }
        }

        void set(int idx, int val){
            if(idx < 0 || idx >= size){
                System.out.println("Invalid index");
                return;
            } else {
                data[idx] = val;
            }
        }

        int size(){
            return size;
        }

        void display(){
            for(int i = 0; i < size; i++){
                System.out.print(data[i] + " ");
            }

            for(int i = size; i < data.length; i++){
                System.out.print(".");
            }

            System.out.println();

        }

        void add(int idx, int val){
            if(idx < 0 || idx > size){
                System.out.print("Invalid arguments");
                return;
            }

            if(size == data.length){
                int[] newData = new int[data.length * 2];
                for(int i = 0; i < data.length; i++){
                    newData[i] = data[i];
                }

                data = newData;
            }

            for(int i = idx; i < size; i++){
                data[i + 1] = data[i];
            }

            data[idx] = val;

            size++;
        }

        void remove(int idx){
             if(idx < 0 || idx >= size){
                System.out.print("Invalid arguments");
                return;
            }

            for(int i = idx; i < size - 1; i++){
                data[i] = data[i + 1];
            }

            data[size - 1] = 0;

            size--;

            if(size < data.length / 4){
                int[] newData = new int[data.length / 2];

                for(int i = 0 ; i < size; i++){
                    newData[i] = data[i];
                }

                data = newData;
            }
        }

    }

    public static void main(String[] args){
        // Write your code here
        MyArrayList list = new MyArrayList(4);
        list.add(0, 10);
        list.display();
        list.add(1, 20);
        list.display();
        list.add(2, 30);
        list.display();
        list.add(3, 40);
        list.display();
        list.add(4, 50);
        list.display();

        list.set(2, 300);
        list.display();

        list.add(2, 3000);
        list.display();

        list.add(4, 88);
        list.display();

        list.add(6, 34);
        list.display();

        list.add(2, 77);
        list.display();

    }
}