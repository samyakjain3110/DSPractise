import java.util.* ;

public class questions {
    
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    //Leetcode 235.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode curr = root;
        while(curr != null){

            if(p.val < curr.val && q.val < curr.val) curr = curr.left;
            else if (p.val > curr.val && q.val > curr.val) curr = curr.right;
            else return curr;
        }

        return null;
    }

    // Leetcode 173
    class BSTIterator {

        Stack<TreeNode> st=new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAllNextElements(root);
        }

        public void pushAllNextElements(TreeNode node){
            while(node!=null){
                st.push(node);
                node = node.left;
            }
        }
        
        public int next() {
            TreeNode rv = st.pop();
            pushAllNextElements(rv.right);

            return rv.val;
        }
        
        public boolean hasNext() {
            return st.size() != 0;
        }
    }

    TreeNode A = null, B =null;
    TreeNode prev = null;
    public boolean recoverTree_(TreeNode root) {
        if(root == null) return false;

        if(recoverTree_(root.left)) return true;
        if(prev != null && prev.val > root.val){
            B = root;
            if(A == null) A = prev;
            else return true;
        }
        
        prev = root;
        if(recoverTree_(root.right)) return true;
        
        return false;
    }

    
    public void recoverTree(TreeNode root) {

        recoverTree_(root);
        if(A!=null){
            int temp = A.val;
            A.val = B.val;
            B.val = temp;
        }
    
    }
// =======================================================================================================
     
    //Leetcode 510.
   
    // Definition for a Node.
    class Node {
       public int val;
       public Node left;
       public Node right;
       public Node parent;
    };
    

    public Node inorderSuccessor(Node node) {
        Node curr = node;
        Node succ = null;
        if(curr.right!=null){
            succ = curr.right;
            while(succ.left != null) succ=succ.left;
            
            return succ;
        }
        
        Node prev = null;
        while(curr.parent!=null){
            prev = curr;
            curr = curr.parent;
            if(curr.left == prev) return curr;

        }
        
        return succ;
    }

    
    //Leetcode 230
    int KthSmallestAns = -1;
    int Kth=0;
    public boolean kthSmallest_(TreeNode root) {
        if(root == null) return false;

        if(kthSmallest_(root.left)) return true;

        if(--Kth == 0){
            KthSmallestAns = root.val;
            return true;
        }

        if(kthSmallest_(root.right)) return true;
        return false;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Kth = k;
        kthSmallest_(root);
        return KthSmallestAns;
    }

    public void pushAllNext(Stack<TreeNode> st,TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        pushAllNext(st,root);

        while(--k != 0){
            TreeNode rNode = st.pop();
            pushAllNext(st,rNode.right);
        }
        return st.peek().val;
    }
//============================================================================================



}