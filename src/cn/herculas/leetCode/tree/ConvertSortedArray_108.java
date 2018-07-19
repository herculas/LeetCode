package cn.herculas.leetCode.tree;

public class ConvertSortedArray_108 {
    private int[] array;
    // TODO: AVL Tree
    public TreeNode sortedArrayToBST(int[] nums) {
        this.array = nums;
        if (nums == null || nums.length == 0) {
            return null;
        }

        int size = this.array.length;
        return iterator(0, size - 1);
    }

    private TreeNode iterator(int left, int right) {
        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(this.array[middle]);
        root.left = iterator(left, middle - 1);
        root.right = iterator(middle + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] test = {-10, -3, 0, 5, 9};

        ConvertSortedArray_108 convertSortedArray_108 = new ConvertSortedArray_108();

        TreeNode node = convertSortedArray_108.sortedArrayToBST(test);
    }
}
