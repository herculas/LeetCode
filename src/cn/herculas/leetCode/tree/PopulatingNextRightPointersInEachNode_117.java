package cn.herculas.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode_117 {
    public void connect(TreeLinkNode root) {

        List<TreeLinkNode> thisLevel = new ArrayList<>();
        if (root != null) thisLevel.add(root);

        while (!thisLevel.isEmpty()) {
            List<TreeLinkNode> nextLevel = new ArrayList<>();

            for (TreeLinkNode node : thisLevel) {
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            if (nextLevel.isEmpty())
                break;

            for (int i = 0; i < nextLevel.size() - 1; i++) {
                nextLevel.get(i).next = nextLevel.get(i + 1);
            }

            thisLevel = nextLevel;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;

        PopulatingNextRightPointersInEachNode_117 populatingNextRightPointersInEachNode_117 = new PopulatingNextRightPointersInEachNode_117();
        populatingNextRightPointersInEachNode_117.connect(n1);

        System.out.println(n2.next.val);
        System.out.println(n4.next.val);
        System.out.println(n5.next.val);
    }
}
