public class leetcode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node pre = head;
        while (pre != null) {
            Node next = pre.next;
            Node cur = new Node(pre.val);
            pre.next = cur;
            cur.next = next;
            pre = next;
        }
        pre = head;
        Node newhead = head.next;
        while (pre != null) {
            pre.next.random = pre.random == null ? null : pre.random.next;
            pre = pre.next.next;
        }
        pre = head;
        while (pre.next.next != null) {
            Node cur = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre = pre.next;
        }
        pre.next = null;
        return newhead;
    }
}