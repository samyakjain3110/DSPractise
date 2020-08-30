import java.util.* ;

public class practise{

    
    static int idx = 0 ;

    public static void solve(){
        
        // int arr[] = {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1} ;
        // Node root = construct(arr) ;
        // display(root) ;
        // System.out.println(height(root)) ;
        // System.out.println(find(root,120)) ;
        
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i = 1; i <= 15; i++) arr.add(i*10);
        // Node root = constructBST(arr,0,arr.size()-1);
        // System.out.println(root.val) ;
        // displayBST(root);
        // System.out.println(minimum(root)) ;
        // System.out.println(maximum(root)) ;


        // int[] arr = {7,3,1,0,2,6,4,5,12,9,8,11,10,13,15,14};
        // Node root = BSTPreOrderConstruct(arr,-(int)1e8,(int)1e8) ;
        // display(BSTUsingPreOrder(arr,-(int)1e8,(int)1e8));
        // displayBST(root);


        // Pair p = new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,null,null,null) ;
        // allSolutions(root,0,50,p);
        // System.out.println(BSTPreOrderHeight(arr,-(int)1e8,(int)1e8)) ;
        // allPair p = new allPair((int)1e8, -(int)1e8, null, null, null) ;
        // allSolutions(root, 9, 0, p);
        // System.out.println(p.find + " " + p.ceil + " " + p.floor + " " + p.pred.val + " " + p.succ.val) ;

        // KthSmallest(root) ;
        // System.out.println(root.val) ;

    }


    //====================================================================================================

    static int KthSmallestAns = -1;
    static int Kth=3;
    public static boolean KthSmallest(Node root){
        if(root == null )
        return false ;

        if(KthSmallest(root.left)) return true ;
        
        if(--Kth == 0)
        return true ;

        if(KthSmallest(root.right)) return true ;

        return false ;

    }

    public static class BSTBidNode{
        int val ;
        Node parent ;
        Node left ;
        Node right ;
    } 

    public static Node BSTInorderPred(Node root)
    {
        if(root == null) return null ;

        Node curr = root ;
        Node succ = curr.right ;
        if(curr.right != null )
        {
            succ = curr.right ; 
            while(succ.left != null)
            succ = succ.left ;
            
            return succ ;
        } 

        Node prev = null ;
        while (curr.parent != null)
        {
            prev = curr ;
            curr = curr.parent ;

            if(curr.left == prev) return curr ;
        }

        return succ ;
    }

    public static class allPair{
        int height = 0 ;
        int size   = 0 ;
        int ceil   = Integer.MAX_VALUE ;
        int floor  = Integer.MIN_VALUE ;

        boolean find = false ;

        Node prev = null ;
        Node pred = null ;
        Node succ = null ;

        allPair(int ceil,int floor,Node prev,Node pred,Node succ){
            this.ceil = ceil ;
            this.floor = floor ;
            this.prev = prev ;
            this.pred = pred ;
            this.succ = succ ;
        }

    }

    public static void allSolutions(Node node,int data ,int level,allPair p)
    {
        if(node == null) 
        return ;
        
        p.find = p.find || node.val == data ; 
        p.size++ ;
        p.height = Math.max(p.height,level) ;
        if(p.prev != null && node.val == data) p.pred = p.prev ;
        if(p.prev  != null && p.prev.val == data ) p.succ = node ;
        p.prev = node ;
        
        if(node.val < data) p.floor =  Math.max(p.floor,node.val) ;
        if(node.val > data) p.ceil = Math.min(p.ceil,node.val) ;

        allSolutions(node.left,data,level + 1, p) ;
        allSolutions(node.right,data,level + 1, p) ;

    }

    public static int BSTPreOrderHeight(int[] arr,int llim,int rlim){
        if(idx >= arr.length || arr[idx] < llim || arr[idx] > rlim )
        return -1 ;

        int ele = arr[idx++] ;

        int lh = BSTPreOrderHeight(arr, llim, ele) ;
        int rh = BSTPreOrderHeight(arr, ele, rlim) ;
        
        return Math.max(lh , rh) + 1 ;

    }

    public static Node BSTPreOrderConstruct(int[] arr,int llim,int rlim)
    {
        if(idx >= arr.length || arr[idx] < llim || arr[idx] > rlim) 
        return null;

        Node node = new Node(arr[idx++]) ;

        node.left = BSTPreOrderConstruct(arr, llim, node.val) ;
        node.right = BSTPreOrderConstruct(arr, node.val, rlim) ;

        return node ;
    }

    public static int minimum(Node root)
    {
        Node node = root ;

        while(node.left != null)
        node = node.left ;

        return node.val ;
    }

    public static int maximum(Node root)
    {
        Node node = root ;
        
        while(node.right != null)
        node = node.right ;

        return node.val ;
    }

    public static boolean find(Node root,int data)
    {
        if(root == null)
        return false ;

        return root.val == data || find(root.left,data) || find(root.right,data) ;
    }

    public static Node getNode(Node root,int data)
    {
        if(root == null) return null ;

        if(root.val == data) return root ;

        Node lnode = getNode(root.left,data) ;
        Node rnode = getNode(root.right,data) ;

        return lnode != null ? lnode : rnode ;
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


     // default -> Inorder arr
     public static Node constructBST(ArrayList<Integer> arr,int si ,int ei)
     {
         if(si > ei) return null ;

         int mid = (si + ei) >> 1 ;

         Node node = new Node(arr.get(mid)) ;
        //  System.out.println(node.val) ;

         node.left = constructBST(arr,si,mid - 1) ;
         node.right = constructBST(arr,mid + 1,ei) ;

         return node ;
     }

     public static void displayBST(Node root){
        if(root == null) return;
        StringBuilder sb = new StringBuilder();
        
// System.out.println(root.val + " " + root.left.val + " " + root.right.val ) ;

        sb.append(root.left!=null ? root.left.val+"" : ".");
        sb.append(" <- " + root.val + " -> ");
        sb.append(root.right!=null ? root.right.val+"" : ".");

        System.out.println(sb.toString());

        displayBST(root.left);
        displayBST(root.right);
    }

    //  public static void displayBST(Node root)
    //  {
    //      if(root == null) return ;

    //      StringBuilder sb = new StringBuilder() ;

    //      sb.append(root.left != null ? root.left.val +  : ".") ;
    //      sb.append(" <- " + root.val + " -> ") ;
    //      sb.append(root.right != null ? root.right.val + "" : "." ) ;
         
    //      System.out.println(sb.toString()) ;

    //      displayBST(root.left) ;
    //      displayBST(root.right) ;

    //  }

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
