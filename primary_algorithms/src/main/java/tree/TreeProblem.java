package tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Jin Xiaofeng
 */
public class TreeProblem {

    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        int depth=1;
        if (root != null) {
            stack.push(root);
            map.put(root,depth);
        }else{
            return 0;
        }

        while (stack.size()!=0){
            TreeNode node = stack.pop();
            int currentDepth = map.get(node);
            depth = depth>currentDepth?depth:currentDepth;

            if(node.left!=null){
                stack.push(node.left);
                map.put(node.left,currentDepth+1);
            }
            if(node.right!=null){
                stack.push(node.right);
                map.put(node.right,currentDepth+1);
            }
        }
        return depth;
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode tn = stack.pop();
            TreeNode left = tn.left;
            TreeNode right = tn.right;
            if(left!=null){
                if (left.val < tn.val) {
                    stack.push(left);
                }else{
                    return false;
                }
            }
            if(right!=null){
                if (right.val > tn.val) {
                    stack.push(right);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4,null,null);
        TreeNode t2 = new TreeNode(2,t4,null);

        TreeNode t5 = new TreeNode(5,null,null);
        TreeNode t3 = new TreeNode(3,null,t5);

        TreeNode t1 = new TreeNode(1, t2,t3);

        TreeProblem tp = new TreeProblem();
        int d = tp.maxDepth(t1);
        System.out.println(d);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x, TreeNode left, TreeNode right){
        val=x;
        this.left=left;
        this.right=right;
    }
}
