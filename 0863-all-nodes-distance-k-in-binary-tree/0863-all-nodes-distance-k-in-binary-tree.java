/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        hash(root,map);
        helper(root, target, k, ans, map);
        return ans;
    }

    private void helper(TreeNode root, TreeNode target, int k, List<Integer> ans, HashMap<TreeNode,TreeNode> map) {
        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> set = new HashSet<>();
        q.offer(target);
        set.add(target);
        while(!q.isEmpty() && k>0){
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                TreeNode parent = map.get(node);
                if(left!=null && !set.contains(left)) {
                    q.add(left);
                    set.add(left);
                }
                if(right!=null  && !set.contains(right)) {
                    q.add(right);
                    set.add(right);
                }
                if(parent!=null  && !set.contains(parent)) {
                    q.add(parent);
                    set.add(parent);
                }
            }
            k--;
        }
        int n = q.size();
        for(int i=0;i<n;i++){
            ans.add(q.poll().val);
        }
    }

    private void hash(TreeNode root, HashMap<TreeNode,TreeNode> map) {
        if(root == null) return ;
        if(root.left!= null) map.put(root.left,root);
        if(root.right!= null) map.put(root.right,root);
        hash(root.left,map);
        hash(root.right,map);
    }
}