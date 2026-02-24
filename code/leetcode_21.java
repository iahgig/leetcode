public class leetcode_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {// 额外添加一个节点prehead，避免复杂的判空逻辑，维护新链表tail，不断取两个链表的较小节点插入到tail，并移动相应指针
        ListNode prehead = new ListNode(-1);
        ListNode tail = prehead;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 == null) {
            tail.next = p2;
        } else {
            tail.next = p1;
        }
        return prehead.next;
    }
}