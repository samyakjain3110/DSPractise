import java.util.ArrayList ;
import java.util.Stack ;

public class l001 {
    
public static void main(String args[])
{
    int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
    Node root = constructgt(arr) ;
    display(root) ;
    int max = max(root) ;
    int min = min(root) ;
    int size = size(root) ;
    // int 
}

public static class Node{
    int data ;
    ArrayList<Node> children = new ArrayList<> () ;
    Node(int data)
    {
        this.data = data ;
    }
}

public static Node constructgt(int[] arr)
{
    Stack <Node> st = new Stack<> () ;
    Node root = new Node(arr[0] ) ;
    st.push(root) ;

    for( int idx = 1 ; idx < arr.length - 1 ;idx++ )
    {
        if(arr[idx] != -1)
        {
            st.add(new Node(arr[idx])) ;
        }
        else{
            Node top = st.pop() ;
            st.peek().children.add(top) ;
        }
    }
    return root ;
}

public static int min(Node node)
{
    
    int min = (int)1e8 ;

    min = Math.min(node.data,min) ;

    for(Node child : node.children )
    {
        min = Math.min(min,min(child)) ;
    }

    return min ;
}

public static int max(Node node)
{
    int max = -(int)1e8 ;
    
    max = Math.max(node.data,max) ;

    for(Node child : node.children )
    {
        max = Math.max(max,max(child)) ;
    }

    return max ;
}

public static int height(Node node)
{
    int ht = -1 ;

    for(Node child : node.children)
    {
        ht = Math.max(height(child), ht) ;
    }

    return ht + 1 ;
}

public static int size(Node node)
{
    int sz = 0 ;

    for( Node child : node.children )
    {
        sz += size(child) ;
    }

    return sz + 1 ;
}

public static void display(Node node)
{
    StringBuilder sb = new StringBuilder() ;
    System.out.print(node.data + " -> ") ;

    if(node.children.size() == 0) sb.append(".") ;

    for(Node child : node.children)
    {
        sb.append(child.data + " ") ;
    }

    System.out.println(sb) ;

    for(Node child : node.children) display(child) ;
}

public static Node lowestCommonAncestor(Node root,int p, int q) {

    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();
    
    rootToNodePath(root,p,path1);
    rootToNodePath(root,q,path2);

    int i = path1.size()-1;
    int j = path2.size()-1;

    Node LCA = null;

    while(i >= 0 && j >= 0){
        if(path1.get(i)!=path2.get(j)) break;
        
        LCA = path1.get(i);
        i--;
        j--;
    }

    return LCA;
}


public static void levelOrderLinewiseZZ(Node node){
    Stack<Node> stack = new Stack<>();
    stack.add(node);

    Stack<Node> cstack = new Stack<>();
    int level = 0;

    while(stack.size() > 0){
      node = stack.pop();
      System.out.print(node.data + " ");

      if(level % 2 == 0){
        for(int i = 0; i < node.children.size(); i++){
          Node child = node.children.get(i);
          cstack.push(child);
        }
      } else {
        for(int i = node.children.size() - 1; i >= 0; i--){
          Node child = node.children.get(i);
          cstack.push(child);
        }
      }

      if(stack.size() == 0){
        stack = cstack;
        cstack = new Stack<>();
        level++;
        System.out.println();
      }
    }
  }