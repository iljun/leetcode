package algorithm._24;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(new Solution().swapPairs(listNode1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            int swapVal = currentNode.val;
            currentNode.val = currentNode.next.val;
            currentNode.next.val = swapVal;
            if (currentNode.next.next == null) {
                return head;
            }
            currentNode = currentNode.next.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
