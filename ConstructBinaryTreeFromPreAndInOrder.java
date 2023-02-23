// APPROACH 1 ; O(1)  SEARCH

class Solution {
    // To mem value and index for O(1) retrievel in inOrder array
    HashMap<Integer,Integer> inorderIndexMap = new HashMap();
    // To traverse the perOrder array ele by ele
    public int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        return TraverseBuildTree(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode TraverseBuildTree(int[] preorder, int[] inorder, int leftInorder, int rightInorder){
        // Check range
        if(leftInorder >rightInorder)
            return null;
        // Get Position 
        int inOrderPosition = inorderIndexMap.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index++], null, null);
        // Left Subtree creation
        node.left = TraverseBuildTree(preorder, inorder, leftInorder, inOrderPosition-1);
        // right Subtree creation
        node.right = TraverseBuildTree(preorder, inorder, inOrderPosition+1, rightInorder);
        return node;
    }
    
}


// APPROACH 2; O(N) 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // function to find a node within a range
    int prePointer = 0;
    public int findNodeInRange(int[] arr, int start, int end, int value){
        for(int i = start; i <= end; i++){
            if(arr[i] == value)
                return i;
        }
        return -1;
    }
    public void buildTreeHelper(TreeNode root, int[] preorder, int[] inorder, int left, int right){
        int currRootValIndex = findNodeInRange(inorder, left, right, root.val);
        // No left child
        if(currRootValIndex == left)
            root.left = null;
        else{
            root.left = new TreeNode(preorder[prePointer++]);
            buildTreeHelper(root.left, preorder, inorder, left, currRootValIndex - 1);
        }

        // No right child
        if(currRootValIndex == right)
            root.right = null;
        else{
            root.right = new TreeNode(preorder[prePointer++]);
            buildTreeHelper(root.right, preorder, inorder, currRootValIndex + 1, right);
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[prePointer++]);
        buildTreeHelper(root, preorder, inorder, 0, preorder.length - 1);
        return root;
    }
}
