import java.util.HashMap;
import java.util.Map;

public class leetcode146 {
    class LRUCache {
        static public class ListNode {
            int key;
            int val;
            ListNode pre;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                this.pre = null;
                this.next = null;
            };
        };

        final int capacity;
        int size;
        Map<Integer, ListNode> cache;
        ListNode prehead;
        ListNode posttail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            prehead = new ListNode(-1, 0);
            posttail = new ListNode(-1, 0);
            prehead.next = posttail;
            posttail.pre = prehead;
            cache = new HashMap<>();
        }

        void delete(int key) {
            ListNode cur = cache.get(key);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cache.remove(key);
            size--;
        }

        void push(int key, int value) {
            ListNode cur = new ListNode(key, value);
            posttail.pre.next = cur;
            cur.pre = posttail.pre;
            cur.next = posttail;
            posttail.pre = cur;
            cache.put(key, cur);
            size++;
        }

        public int get(int key) {
            ListNode p = cache.get(key);
            if (p == null) {
                return -1;
            } else {
                delete(key);
                push(key, p.val);
                return p.val;
            }
        }

        public void put(int key, int value) {
            ListNode p = cache.get(key);
            if (p == null) {
                if (size == capacity) {
                    delete(prehead.next.key);
                }
            } else {
                delete(key);
            }
            push(key, value);
        }
    }
}