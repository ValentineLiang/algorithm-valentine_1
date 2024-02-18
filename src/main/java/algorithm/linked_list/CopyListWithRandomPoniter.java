package algorithm.linked_list;

import java.util.HashMap;

public class CopyListWithRandomPoniter {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) { // 做出克隆节点放到map里面，每一个节点都这么干
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // cur 老，map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // copy node and link to every node
        // 1 - > 2 -----> 1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val); // 当前节点的下一个就放它的克隆节点
            cur.next.next = next; // 克隆节点的下一个，是老的下一个
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand   1 -> 1' -> 2 -> 2'
        while (cur != null) {  // 每一次一对一对地遍历只关心random指针的设置,cur.random的下一个节点就是cur.random.next
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node res = head.next; // 新链表的头
        cur = head;
        // split 分离新旧链表
        while (cur != null) {
            next = cur.next.next; // 老
            curCopy = cur.next; // 新
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
