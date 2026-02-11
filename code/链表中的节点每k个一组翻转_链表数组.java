
public class 链表中的节点每k个一组翻转_链表数组 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {// 先取出k个节点，逆序后与上一组链接
        ListNode last_tail = null;// 上一组队尾
        ListNode cur_head = null;// 当前组队首
        ListNode cur_tail = null;// 当前组队尾
        ListNode p = head;// 遍历节点
        while (true) {
            ListNode[] cur = new ListNode[k];// 当前组k个节点
            int cnt = 0;// 找到的节点数量
            boolean flag = true;// 能否找到k个
            for (int i = 0; i < k; i++) {// 存储k个节点
                if (p == null) {
                    flag = false;
                    break;
                }
                ListNode q = new ListNode(p.val);
                q.next = null;
                p = p.next;
                cur[i] = q;
                cnt++;
            }
            if (flag) {// 能找到k个，逆序链接
                for (int i = k - 1; i > 0; i--) {
                    cur[i].next = cur[i - 1];
                }
                cur_head = cur[k - 1];
                cur_tail = cur[0];
                if (last_tail != null) {
                    last_tail.next = cur_head;
                } else// 第一组特殊处理
                    head = cur_head;
                last_tail = cur_tail;
            } else {// 找不到k个，顺序链接
                for (int j = 0; j < cnt - 1; j++) {
                    cur[j].next = cur[j + 1];
                }
                cur_head = cur[0];
                if (last_tail != null) {
                    last_tail.next = cur_head;
                } else// 第一组特殊处理
                    head = cur_head;
                break;
            }
        }
        return head;
    }
}
