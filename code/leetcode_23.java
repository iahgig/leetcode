public class leetcode_23 {

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

    public ListNode mergeKLists(ListNode[] lists) {
        // k个链表两两合并，时间复杂度n*k*logk
        int k = lists.length;
        if (k == 0)
            return null;
        ListNode outhead = null;
        for (int l = 1; l < k; l *= 2) {
            int list1_id = 0;
            int list2_id = list1_id + l;
            while (list1_id < k && list2_id < k) {
                lists[list1_id] = merge_list(lists[list1_id], lists[list2_id]);
                lists[list2_id] = null;
                list1_id = list1_id + 2 * l;
                list2_id = list1_id + l;
            }
            if (list1_id < k) {
                outhead = merge_list(lists[list1_id], outhead);
                lists[list1_id] = null;
            }
        }
        return merge_list(lists[0], outhead);
    }
}
