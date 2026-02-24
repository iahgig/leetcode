public class leetcode_142 {// 设直链长度为m，环长度为n，沿环方向，相遇点距环首长度为a,另一部分为b
    public ListNode detectCycle(ListNode head) {// 当慢指针与快指针在环上第一次相遇时，慢指针走过的长度为m+a，快指针走过的长度为m+a+k*n，k>=1
        if (head == null)// 因为快指针走过的距离是慢指针的两倍，所以m=k*n-a，即m=b(mod n)，显然，令一指针temp指向head，则temp必定会与慢指针相遇于环首
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            for (int i = 0; i < 2; i++) {
                fast = fast.next;
                if (fast == null)
                    return null;
            }
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = head;
                while (temp != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
    }
}
