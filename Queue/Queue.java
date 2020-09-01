package Queue;

public class Queue {
    private int[] q;
    private int front;
    private int rear ;
    private int size;

    public Queue(int cap) {
      q = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    public Stack() {
        setValues(10) ;
      }
  
      public Stack(int n) {
        setValues(n) ;
      }
  
      public void setValues(int n )
      {
        st = new int[n] ;
        this.tos = -1 ;
      }

    void display() {
      for(int i = 0; i < size; i++){
        int idx = (front + i) % data.length;
        System.out.print(data[idx] + " ");
      }
      System.out.println();
    }

    void add(int val) {
      if(size == data.length){
        System.out.println("Queue overflow");
      } else {
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      }
    }

    int remove() {
      if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];

        front = (front + 1) % data.length;
        size--;

        return val;
       }
    }

    int peek() {
       if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];
        return val;
       }
    }
  }
