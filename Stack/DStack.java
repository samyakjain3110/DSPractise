package Stack;

public class DStack {
    private int[] st ;
    private int size ;
    private int tos ;
    private int maxSize ;

      public DStack() {
        setValues(10) ;
      }
  
      public DStack(int n) {
        setValues(n) ;
      }
  
      public void setValues(int n )
      {
        st = new int[n] ;
        this.tos = -1 ;
      }
      
      @Override
      public String toString(){
        StringBuilder sb = new StringBuilder() ;
        sb.append("[");

        for(int i = this.tos; i >= 0; i--) 
        {
          sb.append(this.st[i]) ;
          if(i != 0) sb.append(",") ;
        }
        sb.append("]") ;
        return sb.toString() ;
      }

      private void push_(int val){
        tos++;
        st[tos] = val;
      }
      void push(int val) throws Exception {
        if (tos == st.length - 1) {
          throw new Exception("Stack overflow");
        } 
        push_(val);
      }
  
      private int pop_(){
        int val = st[tos];
        tos--;
        return val;
      }
      public int pop()  throws Exception {
        if (tos == -1) {
          throw new Exception("Stack underflow");
        }
        return pop_() ;
      }
  
      private int top_(){
        return st[tos] ;
      }
      public int top() throws Exception{
        if (tos == -1) {
          throw new Exception("Stack underflow");
        } 
        return top_() ;
      }
}