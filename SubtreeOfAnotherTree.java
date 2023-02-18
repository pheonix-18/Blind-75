class Solution {
    public boolean verify(TreeNode node1, TreeNode node2){
        if(node1==null && node2 == null)
            return true;
        else if(node1 == null || node2 == null)
            return false;
        else if(node1.val == node2.val)
            return verify(node1.left, node2.left) && verify(node1.right, node2.right) ;
        else
            return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return subRoot==null;
        }
        return verify(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
