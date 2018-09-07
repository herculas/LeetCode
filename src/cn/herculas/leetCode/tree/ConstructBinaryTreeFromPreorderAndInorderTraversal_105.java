package cn.herculas.leetCode.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int size = preorder.length;
        if (size == 0) {
            return null;
        }

        int root = preorder[0];
        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                leftSize = i;
                break;
            }
        }
        int rightSize = size - leftSize - 1;

        TreeNode treeNode = new TreeNode(root);

        int[] leftPreorder = new int[leftSize];
        int[] leftInorder = new int[leftSize];
        int[] rightPreorder = new int[rightSize];
        int[] rightInorder = new int[rightSize];

        if (leftSize != 0) {
            System.arraycopy(preorder, 1, leftPreorder, 0, leftSize);
            System.arraycopy(inorder, 0, leftInorder, 0, leftSize);
            treeNode.left = buildTree(leftPreorder, leftInorder);
        }

        if (rightSize != 0) {
            System.arraycopy(preorder, leftSize + 1, rightPreorder, 0, rightSize);
            System.arraycopy(inorder, leftSize + 1, rightInorder, 0, rightSize);
            treeNode.right = buildTree(rightPreorder, rightInorder);
        }

        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal_105 constructBinaryTreeFromPreorderAndInorderTraversal_105
                = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();
        constructBinaryTreeFromPreorderAndInorderTraversal_105.buildTree(preorder, inorder);
    }
}
