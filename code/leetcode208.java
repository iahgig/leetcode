
public class leetcode208 {

    class Trie {

        class TrieNode {
            boolean isword;
            TrieNode[] next;

            public TrieNode() {
                this.isword = false;
                next = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode pre = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (pre.next[index] == null) {
                    pre.next[index] = new TrieNode();
                }
                pre = pre.next[index];
            }
            pre.isword = true;
        }

        public boolean search(String word) {
            TrieNode pre = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (pre.next[index] == null) {
                    return false;
                }
                pre = pre.next[index];
            }
            return pre.isword;
        }

        public boolean startsWith(String prefix) {
            TrieNode pre = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (pre.next[index] == null) {
                    return false;
                }
                pre = pre.next[index];
            }
            return true;
        }
    }
}