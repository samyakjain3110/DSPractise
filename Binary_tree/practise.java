public class practise {
    
    public static void main(String[] args){
        solve();
    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        boolean leaf = false ;

        Node(int data){
            this.data = data;
        }
    }
    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        // display(root);
        joinLeaves(root) ;
        // display(root) ;
    }
    
    public static Node prev = null ;
    public static void joinLeaves(Node node)
    {
        if( node == null) return ;

        if(isLeaf(node)) 
        {
            node.left = prev ;
            if(prev != null) prev.right = node ;
            prev = node ;
            return ;
        }

        joinLeaves(node.left) ;
        joinLeaves(node.right) ;

    }

    public static boolean isLeaf(Node node)
    {
        if(node.left == null && node.right == null) return true ;
        else return false ;
    }






    static int idx = 0;
    public static Node constructTree(int[] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
            return null;
        }

        Node node=new Node(arr[idx++]);

        node.left = constructTree(arr);
        node.right = constructTree(arr);

        return node;
    }

    public static void display(Node node){
        if(node==null) return;
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.left!=null?node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right!=null?node.right.data+"" : ".");

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }


}