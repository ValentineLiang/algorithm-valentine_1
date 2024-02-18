package algorithm.linked_list;

public class PartitionList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) { // 如果开始第一个节点设置小于区域的头和尾
                    sH = head;
                    sT = head;
                } else { // 如果不是第一个节点，把老的尾巴的next指针连上当前节点，当前节点变成小于区域新的尾巴
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) { // 同样道理等于区域也这么干
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {  // 同样道理大于区域也这么干
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        // samll and equal reconnect
        if (sT != null) { // 如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT; //下一步，谁去连大于区域的头，谁就变成eT
        }
        // 上面的if，不管跑了没有，et all reconnect
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

}
