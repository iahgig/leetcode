public class leetcode_148_2 {
    private ListNode get_tail(ListNode head) {
        if (head == null)
            return null;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    private ListNode[] merge_list(ListNode list1, ListNode list2)
    // 合并两个有序链表,返回头结点和尾节点
    {
        ListNode p = list1;
        ListNode q = list2;
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        ListNode tail = null;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                pre.next = p;
                p = p.next;
            } else {
                pre.next = q;
                q = q.next;
            }
            pre = pre.next;
        }
        if (p == null) {
            pre.next = q;
            tail = get_tail(q);
        }
        // p,q不可能同时为空
        if (q == null) {
            pre.next = p;
            tail = get_tail(p);
        }
        return new ListNode[] { prehead.next, tail };
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode pre = prehead;// 上一组链表的尾部
        ListNode out_head = null;// 分组失败的链表头部
        for (int l = 1; l < len; l *= 2) {
            ListNode list1 = prehead.next;
            ListNode list2 = null;
            ListNode tail = list1;// 指向两个链表尾部，负责断开该链表指空
            pre = prehead;// pre也要维护
            while (list1 != null) {
                for (int i = 1; i < l; i++) {
                    tail = tail.next;
                }
                list2 = tail.next;
                tail.next = null;
                tail = list2;
                if (list2 == null) {// 分组失败，加入淘汰队列
                    pre.next = null;
                    out_head = merge_list(out_head, list1)[0];
                    break;
                } else {
                    // 当list1存在l个节点后，list2一定存在l个节点，因为经l值筛过后，链表的节点数量为2*l的整数倍，由于上次循环已经被l/2值筛过，所以当前链表的节点数量为l的整数倍
                    for (int i = 1; i < l; i++) {
                        tail = tail.next;
                    }
                    ListNode next_list1 = tail.next;
                    tail.next = null;
                    ListNode[] list = merge_list(list1, list2);
                    pre.next = list[0];
                    // 当前组合并后与上一组连接，保证了下一次以2*l值分组时list1和list2能够正确维护
                    pre = list[1];
                    list1 = next_list1;
                    tail = list1;
                }
            }
        }
        return merge_list(prehead.next, out_head)[0];// 已合并队列与淘汰队列合并
    }
}
