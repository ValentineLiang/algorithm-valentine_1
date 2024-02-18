package algorithm.linked_list;

import java.util.Stack;

// 判断链表是否是回文结构
// 测试链接 : https://leetcode.cn/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { //find mid node
            n1 = n1.next; // n1 -> mid，慢指针一次走一步
            n2 = n2.next.next; // n2 -> end，快指针一次走两步
        }
        n2 = n1.next; // n2是右部分的第一个节点，right part first node
        n1.next = null; // mid.next -> null 中间节点的下一个节点设为null
        Node n3 = null;
        while (n2 != null) { // 右部分逆序，right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = head; // n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // 检查是否回文
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // 把右部分逆序回来 recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
