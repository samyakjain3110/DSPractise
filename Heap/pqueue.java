import java.util.ArrayList ;

public class practise {
    
}


public class pqueue{
   
    private ArrayList<Integer> pq ;
    private boolean isMaxHeap = true ;


    // Constructor.===========================================

    public pqueue(int[] arr,boolean isMax){
        initialize(isMax) ;
        // from last call down heapify and keep adding 
        for(int idx = arr.length - 1 ; idx >= 0 ; idx-- )
        {
            pq.add(arr[idx]) ;
        }
        constructHeap() ; 
    }

    public pqueue(){  
        initialize(true) ;
    }

    private void intialize(boolean isMax){
        pq = new ArrayList<> () ;
        isMaxHeap = isMax ;
    }

    private void constructHeap(){
        for(int idx = pq.size() - 1 ; idx >= 0 ; idx-- )
        {
            downHeapify(idx);
        }
    }

    private int compareTo(int i,int j){
       
    }

    private void swap(int i,int j){
        
    } 

    private void downHeapify(int pi){  // O(log(n))
       
    }

    private void upHeapify(int ci){  // O(log(n))
        
    }

    //=====================================================================

    public int size(){
    }

    public boolean isEmpty(){
    }

    public void add(int val){ // O(log(n))
        
    }

    public int peek() throws Exception{ // O(1)
        
    }

    public int poll() throws Exception{  // O(log(n))
     
    
    }

    // public void update(int idx){
    //     downHeapify(idx);
    //     upHeapify(idx);
    // }   

}