import java.util.*;
import java.io.*;

class Main{
    static class Student implements Comparable<Student> {
        String name;
        int ht;
        int wt;

        public Student(String name, int ht, int wt){
            this.name = name;
            this.ht = ht;
            this.wt = wt;
        }

        public String toString(){
            return (name + " " + ht + ", " + wt);
        }
        
        public int compareTo(Student other){
            return this.ht - other.ht;
        }
    }
    public static void main(String[] args){
        Student[] students = new Student[5];

        students[0] = new Student("A", 185, 66);
        students[1] = new Student("B", 165, 50);
        students[2] = new Student("C", 177, 70);
        students[3] = new Student("D", 150, 82);
        students[4] = new Student("E", 161, 75);

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for(Student student : students){
            pq.add(student);
        }

        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
    }
}