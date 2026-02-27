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

public class leetcode_138_2 {
    // 要想消除哈希表mp[origin_node]->new_node,我们可以在原链表的每个节点后插入其对应的拷贝节点，这样就以origin_node.next实现了origin_node到new_node的映射,然后复原拷贝链表cur_new.next=cur_origin.next.next.next;cur_new.random=cur_origin.random.next;在这个过程中我们只修改了拷贝节点的next指针，对原节点的next指针无影响，也就是说，原节点的next指针始终指向它的拷贝节点,这样就确保了修改拷贝节点的random指针准确无误，但是恰恰因为修改了拷贝节点的next指针，导致无法复原原链表，所以只能先修改拷贝节点的random指针，然后同步修改原节点和拷贝节点的next指针
    public Node copyRandomList(Node head) {

        Node cur_origin = head;
        while (cur_origin != null) {
            Node cur_new = new Node(cur_origin.val);
            cur_new.next = cur_origin.next;
            cur_origin.next = cur_new;
            cur_origin = cur_new.next;
        }
        cur_origin = head;
        while (cur_origin != null) {
            Node cur_new = cur_origin.next;
            Node next_cur_origin = cur_origin.next.next;
            // 空节点拷贝特殊处理
            cur_new.random = (cur_origin.random != null) ? cur_origin.random.next : null;
            cur_origin = next_cur_origin;
        }
        cur_origin = head;
        Node cur_new_head = (head != null) ? head.next : null;
        while (cur_origin != null) {
            Node cur_new = cur_origin.next;
            Node next_cur_origin = cur_origin.next.next;
            cur_origin.next = next_cur_origin;
            cur_new.next = (next_cur_origin != null) ? next_cur_origin.next : null;
            // 空节点拷贝特殊处理
            cur_origin = next_cur_origin;
        }
        return cur_new_head;
    }
}