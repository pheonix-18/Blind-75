class Solution {
    public int depth = Integer.MIN_VALUE;
    public void traverseTree(TreeNode node, int currentDepth){
        if(node==null){
            depth = Math.max(currentDepth, depth);
        }
        else{
            traverseTree(node.left, currentDepth+1);
            traverseTree(node.right, currentDepth+1);
        }
    }
    public int maxDepth(TreeNode root) {
        traverseTree(root, 0);
        return depth;        
    }
}
