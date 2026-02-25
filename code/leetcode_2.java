public class leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {// 借助l1链表空间，减少空间复杂度
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode tail = null;
        int pre = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + pre;
            p1.val = sum % 10;
            pre = sum / 10;
            tail = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int sum = p1.val + pre;
            p1.val = sum % 10;
            pre = sum / 10;
            tail = p1;
            p1 = p1.next;
        }
        while (p2 != null) {
            int sum = p2.val + pre;
            p2.val = sum % 10;
            pre = sum / 10;
            tail.next = p2;
            tail = p2;
            p2 = p2.next;
        }
        if (pre == 1)
            tail.next = new ListNode(1);
        return l1;
    }
}
