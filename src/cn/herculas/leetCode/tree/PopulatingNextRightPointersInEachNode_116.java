package cn.herculas.leetCode.tree;

public class PopulatingNextRightPointersInEachNode_116 {
    public void connect(TreeLinkNode root) {
        if (root.left == null || root.right == null) {
            return;
        }

        root.left.next = root.right;

        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode1 = new TreeLinkNode(1);
        TreeLinkNode treeLinkNode2 = new TreeLinkNode(2);
        TreeLinkNode treeLinkNode3 = new TreeLinkNode(3);
        TreeLinkNode treeLinkNode4 = new TreeLinkNode(4);
        TreeLinkNode treeLinkNode5 = new TreeLinkNode(5);
        TreeLinkNode treeLinkNode6 = new TreeLinkNode(6);
        TreeLinkNode treeLinkNode7 = new TreeLinkNode(7);

        treeLinkNode1.left = treeLinkNode2;
        treeLinkNode1.right = treeLinkNode3;

        treeLinkNode2.left = treeLinkNode4;
        treeLinkNode2.right = treeLinkNode5;

        treeLinkNode3.left = treeLinkNode6;
        treeLinkNode3.right = treeLinkNode7;

        PopulatingNextRightPointersInEachNode_116 populatingNextRightPointersInEachNode_116
                = new PopulatingNextRightPointersInEachNode_116();
        populatingNextRightPointersInEachNode_116.connect(treeLinkNode1);

        System.out.println(treeLinkNode2.next.val);
        System.out.println(treeLinkNode4.next.val);
        System.out.println(treeLinkNode5.next.val);
        System.out.println(treeLinkNode6.next.val);
    }
}
