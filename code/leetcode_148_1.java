public class leetcode_148_1 {
    private ListNode merge_list(ListNode list1, ListNode list2)
    // 合并两个有序链表
    {
        ListNode p = list1;
        ListNode q = list2;
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
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
        }
        if (q == null) {
            pre.next = p;
        }
        return prehead.next;
    }

    private ListNode split_list(ListNode head, int len)
    // 拆分链表,返回中间节点,定义为链表后半中间节点
    {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode pre_mid = prehead;
        ListNode mid;
        for (int i = 0; i < len / 2; i++) {
            pre_mid = pre_mid.next;
        }
        mid = pre_mid.next;
        pre_mid.next = null;
        return mid;
    }

    public ListNode merge_sort(ListNode head, int len) {
        if (len == 0 || len == 1)
            return head;
        ListNode mid = split_list(head, len);
        int len1 = len / 2;
        int len2 = len - len1;
        ListNode list1 = merge_sort(head, len1);
        ListNode list2 = merge_sort(mid, len2);
        return merge_list(list1, list2);
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return merge_sort(head, len);
    }
}
