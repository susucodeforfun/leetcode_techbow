package Tree.Traverse;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//迭代实现二叉树遍历 使用stack
public class TraverseIterator {
    //前序遍历顺序：中左右 入栈顺序：中右左
    //前序遍历的遍历顺序是根左右，先将根结点入栈，然后将右孩子入栈，再将左孩子入栈。
    //这样出栈的顺序才是根左右

    public List<Integer> preorderTraversal(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if(curNode.right!=null) stack.push(curNode.right);
            if(curNode.left!=null) stack.push(curNode.left);
        }
        return res;
    }
/*
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
    }

 */
}
