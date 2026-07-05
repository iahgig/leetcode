public class leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        int d = 1;
        while (d < k) {
            for (int i = 0; i + d < k; i += 2 * d) {
                lists[i] = mergeList(lists[i], lists[i + d]);
            }
            d *= 2;
        }
        return lists[0];
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 == null) {
            pre.next = list2;
        } else {
            pre.next = list1;
        }
        return dummy.next;
    }
}