public class leetcode_160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {// 分别在AB找到一个节点，使得以该节点为首的部分AB链表长度相等，然后同步遍历即可
            ListNode pA = headA;
            ListNode pB = headB;
            while (true) {
                if (pA != null && pB != null) {
                    if (pA == pB)
                        return pA;
                    pA = pA.next;
                    pB = pB.next;
                } else if (pA != null && pB == null) {
                    pB = headA;
                } else if (pA == null && pB != null) {
                    pA = headB;
                } else {
                    return null;
                }

            }
        }
    }
}
