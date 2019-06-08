package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Jin Xiaofeng
 */
public class TreeProblem {

    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int depth = 1;
        if (root != null) {
            stack.push(root);
            map.put(root, depth);
        } else {
            return 0;
        }

        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            int currentDepth = map.get(node);
            depth = depth > currentDepth ? depth : currentDepth;

            if (node.left != null) {
                stack.push(node.left);
                map.put(node.left, currentDepth + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                map.put(node.right, currentDepth + 1);
            }
        }
        return depth;
    }

    /**
     * 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> ar = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp=root;

        //中序遍历
        while (temp != null || stack.size() != 0) {
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if (stack.size() != 0) {
                temp=stack.pop();
                ar.add(temp.val);
                if (temp.right != null) {
                    temp=temp.right;
                }else{
                    temp=null;
                }
            }
        }
        if (ar.size() == 1) {
            return true;
        }
        int lastInt=ar.get(0);
        for (int i = 1; i < ar.size(); i++) {
            int now=ar.get(i);
            if(now<=lastInt){
                return false;
            }else{
                lastInt=now;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t2 = new TreeNode(2, t4, null);

        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t3 = new TreeNode(3, null, t5);

        TreeNode t1 = new TreeNode(1, t2, t3);

        TreeProblem tp = new TreeProblem();
        int d = tp.maxDepth(t1);
        System.out.println(d);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
