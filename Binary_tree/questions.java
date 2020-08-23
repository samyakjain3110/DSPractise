import java.util.* ;
public class questions{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //Leetcode 112   -> done
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;  

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val); 
    }

    //Leetcode 113
    public void pathSum_(TreeNode root, int sum,List<List<Integer>> Res,List<Integer> SmallAns) {
        if(root == null) return;
        if(root.left == null && root.right == null && sum - root.val == 0){
            List<Integer> ans = new ArrayList<>(SmallAns);
            ans.add(root.val);
            Res.add(ans);
            return;
        }
       
        SmallAns.add(root.val);
        
        pathSum_(root.left, sum-root.val, Res, SmallAns);
        pathSum_(root.right, sum-root.val, Res, SmallAns);
        
        SmallAns.remove(SmallAns.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> Res=new ArrayList<>();
        List<Integer> SmallAns=new ArrayList<>();

        pathSum_(root,sum,Res,SmallAns);
        return Res;
    }

    //Leetcode 124
    int NTNRes = -(int)1e8;
    public int maxPathSum_(TreeNode root) {
        if(root== null ) return 0;

        int lMax = maxPathSum_(root.left);
        int rMax = maxPathSum_(root.right); 

        int max_ = Math.max(lMax,rMax) + root.val;
        NTNRes = Math.max(Math.max(NTNRes,root.val),Math.max(max_ ,lMax + root.val + rMax));

        return Math.max(max_, root.val);
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSum_(root);
        return NTNRes;
    }

    // Leetcode 863
    public void kDown(TreeNode node,TreeNode block,int level,List<Integer> ans){
        if(node==null || node == block || level < 0) return;

        if(level == 0 ) {
            ans.add(node.val);
            return;
        }

        kDown(node.left,block,level-1,ans);
        kDown(node.right,block,level-1,ans);
    }


    public int kFar(TreeNode node, TreeNode target, int K,List<Integer> ans) {
        if(node == null) return -1;

        if(node.val == target.val){
            kDown(node,null,K,ans);
            return 1;
        }


        int ld = kFar(node.left, target, K, ans);
        if(ld != -1){
            kDown(node,node.left,K - ld, ans);
            return ld + 1;
        }

        
        int rd = kFar(node.right, target, K, ans);
        if(rd != -1){
            kDown(node,node.right,K - rd, ans);
            return rd + 1;
        }

        return -1;
    }

    public List<Integer> distanceK(TreeNode node, TreeNode target, int K) {
        List<Integer> ans=new ArrayList<>();
        kFar(node,target,K,ans);
        return ans;
    }

    //Leetcode 236
    TreeNode LCANode = null;
    
    public boolean lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;

        boolean selfDone = false;
        if(root == p || root == q) selfDone = true;

        boolean leftDone = lowestCommonAncestor_(root.left, p, q);
        if(LCANode!=null) return true;
        
        boolean rightDone = lowestCommonAncestor_(root.right, p, q);
        if(LCANode!=null) return true;

        if((leftDone && rightDone) ||(leftDone && selfDone) || (rightDone && selfDone)) LCANode = root;
        
        return selfDone || leftDone || rightDone;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor_(root,p,q);
        return LCANode;
    }

    
    //leetcode l05
    public TreeNode buildTreeprein(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei) {
        if(psi>pei) return null;
        int idx = isi;
        while(inorder[idx]!=preorder[psi]) idx++;
        int len = idx - isi;
        
        TreeNode node = new TreeNode(preorder[psi]);
        node.left = buildTreeprein(preorder, psi+1,psi+len,inorder,isi,idx-1);
        node.right = buildTreeprein(preorder, psi+len+1,pei,inorder,idx + 1, iei);

        return node;
    }

    public TreeNode buildTreepreincall(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int n = preorder.length;

        return buildTreeprein(preorder,0,n-1,inorder,0,n-1);
    }

    //Leetcode 106
    public TreeNode buildTreepostin(int[] postorder,int psi,int pei, int[] inorder,int isi,int iei) {
        if(psi>pei) return null;
        int idx = isi;
        while(inorder[idx]!=postorder[pei]) idx++;
        int len = idx - isi;
            
        TreeNode node = new TreeNode(postorder[pei]);
        node.left = buildTreepostin(postorder, psi,psi + len - 1,inorder,isi,idx-1);
        node.right = buildTreepostin(postorder, psi + len,pei - 1,inorder,idx + 1, iei);
    
        return node;
    }
    
    public TreeNode buildTreepostincall(int[] inorder, int[] postorder) {
            if(postorder.length==0) return null;
            int n = postorder.length;
    
            return buildTreepostin(postorder,0,n-1,inorder,0,n-1);
    }
    
}