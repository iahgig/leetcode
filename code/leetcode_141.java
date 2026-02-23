
public class leetcode_141 {// 快慢指针，有环则快指针一定会和慢指针相遇，(m+n-m%n)个循环
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            for (int i = 0; i < 2; i++) {
                fast = fast.next;
                if (fast == null)
                    return false;
            }
            slow = slow.next;
            if (fast == slow)
                return true;
        }
    }
}