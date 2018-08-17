class Solution {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }

        ListNode prev = head;
        ListNode curr = prev.next;

        while (curr != head && !(prev.val <= insertVal && insertVal <= curr.val)
                && !(prev.val > curr.val && (insertVal >= prev.val || insertVal <= curr.val))) {
            prev = curr;
            curr = curr.next;
        }

        ListNode node = new ListNode(insertVal);
        prev.next = node;
        node.next = curr;
        return head;
    }
}
