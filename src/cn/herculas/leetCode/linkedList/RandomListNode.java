package cn.herculas.leetCode.linkedList;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int x) {
        this.label = x;
    }
}
