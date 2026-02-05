// import java.util.*;

public class 链表内指定区间翻转 {
    public class ListNode {

        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {// 将待翻转节点的链接指向已翻转序列头结点，最后将翻转序列与左右原序列链接
        ListNode l = null;// 区间左侧节点
        ListNode r = null;// 区间右侧节点
        ListNode work_head = null;// 已翻转序列头结点
        ListNode work_tail = null;// 已翻转序列尾结点
        ListNode p = head;// 待翻转节点
        ListNode p_next;// 待翻转节点的下一个节点
        for (int i = 0; i < m - 1; i++) {
            if (i == m - 2) {
                l = p;// 此时p为区间左侧节点
            }
            p = p.next;
        }
        // 此时p为第m个节点//
        work_tail = p;// 显然，已翻转序列尾结点一直是第m个节点
        int cnt = 0;
        while (cnt < n - m + 1) {// 共翻转n-m+1个节点
            p_next = p.next;
            p.next = work_head;
            work_head = p;
            p = p_next;
            cnt++;
        }
        if (l != null) {
            l.next = work_head;
        } else// 左侧原序列为空，头结点变更为已翻转序列头结点
        {
            head = work_head;
        }
        r = p;// 此时p为区间右侧节点
        work_tail.next = r;
        return head;
    }
}