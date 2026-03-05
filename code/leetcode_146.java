import java.util.*;

public class leetcode_146 {

    class LRUCache {
        private class ListNode {
            int key;
            int val;
            ListNode pre = null;
            ListNode next = null;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int capacity;// 缓存容量
        int cnt = 0;// 当前缓存数量
        Map<Integer, ListNode> mp = new HashMap<Integer, ListNode>();
        // key->ListNode

        ListNode pre_head = new ListNode(-1, -1);
        ListNode post_tail = new ListNode(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            pre_head.next = post_tail;
            post_tail.pre = pre_head;
        }

        public void delete(ListNode key_Node) {
            // 删除key_Node
            key_Node.pre.next = key_Node.next;
            key_Node.next.pre = key_Node.pre;
        }

        public void insert(ListNode key_Node) {
            // 将key_Node插入到链表末尾
            key_Node.pre = null;
            key_Node.next = null;
            post_tail.pre.next = key_Node;
            key_Node.pre = post_tail.pre;
            key_Node.next = post_tail;
            post_tail.pre = key_Node;
        }

        public int get(int key) {

            if (mp.containsKey(key)) {
                ListNode key_Node = mp.get(key);
                delete(key_Node);
                insert(key_Node);
                return key_Node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            // 第一种情况：该节点已缓存，则更新其值，在链表删除并插入该节点
            // 第二种情况：该节点未缓存，创建新节点，若缓存达到上限，在哈希表和链表分别删除头结点，然后在哈希表和链表分别插入该节点。否则，直接在哈希表和链表分别插入该节点
            ListNode key_Node = null;
            if (!mp.containsKey(key)) {
                // 在该分支将key_Node插入哈希表
                key_Node = new ListNode(key, value);
                if (cnt < capacity) {
                    cnt++;
                } else {
                    // 在哈希表和链表分别删除头结点
                    mp.remove(pre_head.next.key);
                    delete(pre_head.next);
                }
                mp.put(key, key_Node);
            } else {
                // 已在缓存，更新value
                key_Node = mp.get(key);
                key_Node.val = value;
                delete(key_Node);
            }
            insert(key_Node);
        }
    }
}