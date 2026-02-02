public class 链表反转 {

    public class ListNode {

        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head.next;// 从左到右依次把节点逆序，待逆序节点为first
        head.next = null;// 逆序后head为最后一个节点
        while (first != null) {
            ListNode p_first = first;// 保留first内容
            first = first.next;// 维护first
            p_first.next = head;// 原first节点移动到逆序链表首位
            head = p_first;// 维护head
        }
        return head;
    }
}
