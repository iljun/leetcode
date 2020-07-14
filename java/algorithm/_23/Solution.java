package algorithm._23;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;

        System.out.println(new Solution().mergeKLists(new ListNode[]{ listNode1, listNode4, listNode7}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        while (true) {
            if (isEmpty(lists)) {
                break;
            }
            int minNumber = minValue(lists);
            ListNode tail = new ListNode(minNumber);
            head.next = tail;
            head = tail;
        }

        return result.next;
    }

    private boolean isEmpty(ListNode[] listNodes) {
        boolean isNotEmpty = true;
        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                isNotEmpty = false;
            }
        }

        return isNotEmpty;
    }

    private int minValue(ListNode[] listNodes) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] != null && listNodes[i].val < min) {
                min = listNodes[i].val;
                index = i;
            }
        }

        listNodes[index] = listNodes[index].next;
        return min;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}