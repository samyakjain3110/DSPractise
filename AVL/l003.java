
public class l003 {
    public static void main(String[] args){
        solve() ;
    }
    public static class Node{
        int data = 0 ;
        Node left = null ;
        Node right = null ;

        int height  =  0 ;
        int bal = 0 ;

        Node(int data)
        {
            this.data = data ;
        }
    }

    public static void updateHeightBalance(Node node)
    {
        int lh = -1 ;
        int rh = -1 ;
        
        if(node.left != null) lh = node.left.height ;
        if(node.right != null) rh = node.right.height ;

        int balance = lh - rh ;
        int height = Math.max(lh,rh) + 1 ;

        node.bal = balance ;
        node.height = height ;
    }

    public static Node LeftRotation(Node A)
    {
        Node B = A.right ;
        Node Bleft = B.left ;

        B.left = A ;
        A.right = Bleft ;

        return B ;

    }
    public static Node RightRotation(Node A) 
    {
        Node B = A.left ;
        Node Bright = B.right ;

        B.right = A ;
        A.left = Bright ;

        return B ;

    }

    public static Node getRotation(Node node)
    {
        updateHeightBalance(node) ;
        if(node.bal == 2)          // ll or lr
        {
            if(node.left.bal == 1) // ll
            {
                return RightRotation(node) ;
            }
            else                   // lr
            {
                return LeftRotation(node) ;
            }
        }
        else if(node.bal == -2)     // rr or rl
        {
            if(node.right.bal == 1) // rr
            {
                return LeftRotation(node) ;
            }
            else                     // rl
            {
                return RightRotation(node) ;
            }

        }
    }

    //===================================================
   
    public static void displayBST(Node root){
        if(root == null) return;
        StringBuilder sb = new StringBuilder();
    
        sb.append(root.left!=null ? root.left.val+"" : ".");
        sb.append(" <- " + root.val + " -> ");
        sb.append(root.right!=null ? root.right.val+"" : ".");

        System.out.println(sb.toString());

        displayBST(root.left);
        displayBST(root.right);
    }


}