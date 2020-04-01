package algorithm._2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        new Solution().addTwoNumbers(listNode1, listNode4);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        int lifting = 0;
        while (cursor1 != null || cursor2 != null) {
            int cursor1Value = cursor1 == null ? 0 : cursor1.val;
            int cursor2Value = cursor2 == null ? 0 : cursor2.val;
            int sum = lifting + cursor1Value + cursor2Value;
            lifting = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            cursor1 = cursor1 == null ? null : cursor1.next;
            cursor2 = cursor2 == null ? null : cursor2.next;
        }

        if (lifting > 0 ) {
            pointer.next = new ListNode(lifting);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return String.format("ListNode val : {%d}, next : {%s}", this.val, this.next == null ? "null" : this.next.toString());
    }
}
