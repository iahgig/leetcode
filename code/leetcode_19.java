public class leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {// fast与slow相距n+1个长度，slow指向待删除节点的前一个节点，当删除头结点时，slow指向prehead
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode fast = head;
        ListNode slow = prehead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return prehead.next;
    }
}