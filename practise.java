// import java.util.* ;

public class practise{

    public static void solve(){
        
        int arr[] = {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1} ;
        Node root = construct(arr) ;
        // display(root) ;
        // System.out.println(height(root)) ;
        System.out.println(find(root,120)) ;
        
        // Pair p = new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,null,null,null) ;
        // allSolutions(root,0,50,p);
        
    }

    //====================================================================================================

    

    public static boolean find(Node root,int data)
    {
        if(root == null)
        return false ;

        return root.val == data|| find(root.left,data) || find(root.right,data) ;
    }

    public static int height(Node root)
    {
        return root == null ? -1 : Math.max(height(root.left),height(root.right)) + 1 ;
    }

    public static int size (Node root)
    {
        // get the left and right size 
        // add your size (1) and return 
       return  root == null ? 0 :  size(root.left) + size(root.right) + 1 ;
    }

    //==============================================================================================
    public static void main(String args[])
    {
        solve() ;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        Node(int val){
            this.val = val ;
        }
        Node(int val , Node left,Node right)
        {
            this.val = val ;
            this.left = left ;
            this.right = right; 
        }

     };

     class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
     };

    static int idx = 0 ;

    public static Node construct(int[] arr){
        // add yourself
        // get left and right subtree

        if(arr[idx] == -1 || idx == arr.length) 
        {
            idx++ ;
            return null;
        }

        Node node = new Node(arr[idx++]) ;

        node.left = construct(arr) ;
        node.right = construct(arr) ;

        return node ;
    }

    public static void display(Node root)
    {
        if(root == null) return ; 

        System.out.println(root.val) ;

        display(root.left) ;
        display(root.right) ;

    }

}
