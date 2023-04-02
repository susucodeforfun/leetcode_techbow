package Tree;

public class TreeNode {
    //fields:
    public int val;
    public TreeNode left;
    public TreeNode right;
    //constructor
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
