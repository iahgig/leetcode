public class 链表中的节点每k个一组翻转 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {// 先取出k个节点，逆序后与上一组链接
        if (head == null)
            return head;
        ListNode last_tail = null;// 上一组队尾
        ListNode p = head;// 遍历节点
        ListNode p_next;
        int len = 0;
        int num_remaining = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        num_remaining = len;
        p = head;
        while (num_remaining >= k) {
            ListNode cur_head = null;// 当前组队首
            ListNode cur_tail = null;// 当前组队尾
            for (int i = 0; i < k; i++) {// 组内逆序
                if (i == 0)
                    cur_tail = p;
                p_next = p.next;
                p.next = cur_head;
                cur_head = p;
                p = p_next;
            }
            if (last_tail != null) {// 组外连接
                last_tail.next = cur_head;
            } else {// 第一组要维护head
                head = cur_head;
            }
            last_tail = cur_tail;
            num_remaining -= k;
        }
        if (last_tail != null) {
            last_tail.next = p;
        }
        return head;
    }
}
