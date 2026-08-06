/*
=========================================
LeetCode 110 - Balanced Binary Tree
=========================================

Topic        : Trees
Difficulty   : Easy

Approach     : DFS + Height

Time         : O(n)
Space        : O(h)

*/

class Solution {
    static boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans=true;
        height(root);
        return ans;
    }
    
    private int height(TreeNode root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)>1){
            ans=false;
        }
        return 1+Math.max(lh,rh);
    }
}