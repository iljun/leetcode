package algorithm.removeNthNodeFromEndOfList;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(new Solution().removeNthFromEnd(listNode, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpNode = new ListNode(0);
        tmpNode.next = head;
        int size = 0;
        ListNode cursor = head;
        while (cursor != null) {
            cursor = cursor.next;
            size++;
        }

        cursor = tmpNode;
        size -= n;
        while (size > 0) {
            cursor = cursor.next;
            size--;
        }

        cursor.next = cursor.next.next;

        return tmpNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.format("ListNode val : %d , next : %s", val, next != null ? next.toString() : "null");
    }
}
