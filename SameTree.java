class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p & q are both null
        if (p == null && q == null) {
            return true;
        }
        // if one of p & q is null
        else if (q == null || p == null) return false;

        else if (p.val != q.val) return false;
        else
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
