package DP.HouseRobber;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    /*
        假设我们在一个tree中 有爷爷 两个孩子和四个孙子
        最优子结构：爷爷+4个孙子 OR 两个儿子
        int plan1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) +rob(root.right.right)
        int plan2 = rob(root.left) + rob(root.right)
        res = Math.max(Math.max(plan1,plan2)
     */

    //method1: brute force
    public int rob(TreeNode root) {
        //cc && base case
        if(root == null) return 0;
        int money = root.val;
        if(root.left!=null){
            money += (rob(root.left.left)+rob(root.left.right));
        }
        if(root.right!=null){
            money += (rob(root.right.left)+rob(root.right.right));
        }
        return Math.max(money,rob(root.left)+rob(root.right));
    }

    //method2:
    // optimization： method1存在重复搜索 爷爷在计算自己能偷多少钱的时候，同时计算了 4 个孙子能偷多少钱，也计算了 2 个儿子能偷多少钱
    // 使用memorization
    Map<TreeNode,Integer> memo = new HashMap<>();
    public int rob2(TreeNode root){
        //cc && base case
        if(root==null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if(root.left != null){
            money += (rob(root.left.left)+rob(root.left.right));
        }
        if(root.right!=null){
            money += (rob(root.right.left)+rob(root.right.right));
        }
        int res = Math.max(money,rob(root.left)+rob(root.right));
        memo.put(root,res);
        return res;
    }

    //method3:
    //当前节点选择偷时，那么两个孩子节点就不能选择偷了
    //当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
    //使用一个size=2的数组表示，int[] res = new int[2] 0代表不偷 1代表偷
    //最优子结构：
        //1.当前节点选择不偷： 当前节点能偷到的最大钱数 = 左孩子偷时的最大钱数+右孩子偷时的最大钱数
        // res[0] = Math.max(rob(root)
        //2. 当前节点选择偷： 当前节点偷到的最大钱数 = 偷当前节点+左孩子不偷时的最大钱数+右孩子不偷时的最大钱数
    public int rob3(TreeNode root){
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }
    public int[] dfs(TreeNode root){
        if(root==null) return new int[2];
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

}
