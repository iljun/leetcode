package algorithm.mergeSortedList;

public class Solution {
//1->2->4, 1->3->4
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;

        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(new Solution().mergeTwoLists(listNode, listNode3));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode currentNode = resultNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                currentNode.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                currentNode.next = l1;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                currentNode.next = l2;
                l2 = l2.next;
            } else {
                currentNode.next = l1;
                l1 = l1.next;
            }
            currentNode = currentNode.next;
        }

        return resultNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.format("ListNode [ val : %d , next : %s ]", val, next == null ? "null" : next.toString());
    }
}