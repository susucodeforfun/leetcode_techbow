满二叉树：如果一颗二叉树只有度为0的结点和度为2的结点，并且度为0的结点在同一层上，则这颗二叉树为满二叉树
完全二叉树：除了最底层节点没填满，其余每层节点都达到最大值，并且最下面一层的结点集中在最左边位置
二叉搜索树：
    二叉搜索树是一颗有序树
    若根结点的左子树不为空，则左子树上所有结点的值均小于根结点的值
    若根结点的右子树不为空，则右子树上所有结点的值均大于根结点的值
平衡二叉搜索树：又称AVL树
    性质：他是一颗空树 或 左右两个子数的高度差的绝对值不超过1并且左右两个子数都是一颗平衡二叉树

二叉树的存储方式：1.链式存储 2.顺序存储
    1.链式存储： 使用指针 是我们常用的方式 通过指针（root.left root.right）把分布在各个地址的结点串联在一起，记录地址

    2.顺序存储： 使用数组，顺序存储的元素在内存中是连续分布的。其实就是用数组来存储二叉树。
        如果父结点的数组下标是i，那么他的左孩子是i*2+1，右孩子是i*2+2

二叉树的定义：
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        //default constructor
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
