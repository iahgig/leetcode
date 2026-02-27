import java.util.*;

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

public class leetcode_138_1 {
    private Node copy(Node cur_origin, Map<Node, Node> mp) {// 对于一个Node对象，它包含三个部分，val，next，random，在这里我们仅拷贝val，因为next，random可以继续调用该函数拷贝。
        if (!mp.containsKey(cur_origin)) {
            Node copy = new Node(cur_origin.val);
            mp.put(cur_origin, copy);
        }
        return mp.get(cur_origin);
    }

    public Node copyRandomList(Node head) {// 根据cur_origin复制cur_new,包含val,next，random
        Map<Node, Node> mp = new HashMap<Node, Node>();// mp[origin_node]->new_node
        mp.put(null, null);// 初始化,拷贝空节点
        Node cur_origin = head;
        Node cur_new = copy(cur_origin, mp);// 初始化，接下来的cur_new会通过cur_new.next提前拷贝，无需重复拷贝
        while (cur_origin != null) {
            cur_new.next = copy(cur_origin.next, mp);
            cur_new.random = copy(cur_origin.random, mp);
            cur_origin = cur_origin.next;
            cur_new = cur_new.next;
        }
        return mp.get(head);
    }
}
