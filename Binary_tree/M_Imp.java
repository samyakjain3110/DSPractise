package Binary_tree;

public class M_Imp {
    
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node rightMost(Node node,Node curr){
        while(node.right!=null && node.right != curr) node=node.right;
        return node;
    }

    public static void morrisINTraversal(Node node){

        Node curr = node;
        while(curr!=null){
            Node next = curr.left;
            if(next == null){
                System.out.print(curr.data+" ");
                curr = curr.right;
            }else{
                Node rightMost = rightMost(next,curr);
                if(rightMost.right == null){
                    rightMost.right = curr;
                    curr = curr.left;
                }else{
                    System.out.print(curr.data+" ");
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void morrisPreTraversal(Node node){

        Node curr = node;
        while(curr!=null){
            Node next = curr.left;
            if(next == null){
                System.out.print(curr.data+" ");
                curr = curr.right;
            }else{

                Node rightMost = rightMost(next,curr);
                if(rightMost.right == null){
                    System.out.print(curr.data+" ");
                    rightMost.right = curr;
                    curr = curr.left;
                }else{
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
        }
    }

}