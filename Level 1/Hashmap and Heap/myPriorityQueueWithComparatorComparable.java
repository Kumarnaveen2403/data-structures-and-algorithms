import java.util.*;
import java.io.*;

class Main{
    public static class MyPriorityQueue<T> {
        ArrayList<T> data;
        Comparator cmptr;
    
        public MyPriorityQueue() {
          data = new ArrayList<>();
          cmptr = null;
        }
        
        public MyPriorityQueue(Comparator cmptr) {
          data = new ArrayList<>();
          this.cmptr = cmptr;
        }
    
        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }
    
        public void upheapify(int idx){
            if(idx == 0){
                return;
            }
    
            int p = (idx - 1) / 2;
    
            if(isSmaller(idx, p) == true){
                swap(p, idx);
                upheapify(p);
            }
        }
    
        public T remove() {
            if(data.size() == 0){
                System.out.println("Underflow");
                return null;
            }
    
            swap(0, data.size() - 1);
    
            T val = data.remove(data.size() - 1);
    
            downheapify(0);
    
            return val;
        }
    
        public void downheapify(int idx){
            int mini = idx;
    
            int c1 = 2 * idx + 1;
            if(c1 < data.size() && isSmaller(c1, mini) == true){
                mini = c1;
            }
    
            int c2 = 2 * idx + 2;
            if(c2 < data.size() && isSmaller(c2, mini) == true){
                mini = c2;
            }
    
            if(mini != idx){
                swap(idx, mini);
                downheapify(mini);
            }
        }
    
        public T peek() {
          if(data.size() == 0){
              System.out.println("Underflow");
              return null;
          }
          return data.get(0);
        }
    
        public int size() {
          return data.size();
        }
    
        public void swap(int i, int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }
        
        public boolean isSmaller(int i, int j){
            T ith = data.get(i);
            T jth = data.get(j);
            
            if(this.cmptr != null){
                if(cmptr.compare(ith, jth) < 0){
                    return true;
                } else {
                    return false;
                }
            } else {
                Comparable cith = (Comparable)ith;
                Comparable cjth = (Comparable)jth;
                
                if(cith.compareTo(cjth) < 0){
                    return true;
                } else {
                    return false;
                }
            }
        }
  }

    
    static class Student implements Comparable<Student> {
        String name;
        int ht;
        int wt;
        int marks;

        public Student(String name, int ht, int wt, int marks){
            this.name = name;
            this.ht = ht;
            this.wt = wt;
            this.marks = marks;
        }

        public String toString(){
            return (name + " -> h : " + ht + ", w : " + wt  + " m : " + marks);
        }
        
        public int compareTo(Student other){
            return this.ht - other.ht;
        }
    }
    
    static class StudentWeightComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;
        }   
    }
    
    static class StudentMarksComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.marks - s2.marks;
        }   
    }
    
    public static void main(String[] args){
        Student[] students = new Student[5];

        students[0] = new Student("A", 185, 66, 99);
        students[1] = new Student("B", 165, 50, 33);
        students[2] = new Student("C", 177, 70, 90);
        students[3] = new Student("D", 150, 82, 50);
        students[4] = new Student("E", 161, 75, 75);

        PriorityQueue<Student> pqHt = new PriorityQueue<>();
        PriorityQueue<Student> pqWt = new PriorityQueue<>(new StudentWeightComparator());
        PriorityQueue<Student> pqMarks = new PriorityQueue<>(new StudentMarksComparator());

        for(Student student : students){
            pqHt.add(student);
            pqWt.add(student);
            pqMarks.add(student);
        }
    
        System.out.println("On the basis of height");
        while(pqHt.size() > 0){
            System.out.println(pqHt.remove());
        }
        
        System.out.println("On the basis of weight");
        while(pqWt.size() > 0){
            System.out.println(pqWt.remove());
        }
        
        System.out.println("On the basis of marks");
        while(pqMarks.size() > 0){
            System.out.println(pqMarks.remove());
        }
    }
}