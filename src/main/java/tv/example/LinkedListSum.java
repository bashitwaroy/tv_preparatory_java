package tv.example;

public class LinkedListSum {

    static ListNode head1, head2;

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int value) {
            this.val = value;
            this.next = null;
        }
    }

    public void printList(ListNode node) {
        if(node == null)
            return;
        printList(node.next);
        System.out.print(node.val + "->");
    }

    public void printListInOriginalOrder(ListNode node) {
        while(node !=null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public ListNode addTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;

            int current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10;
            int digitToInsert = current_sum % 10;

            ListNode nodeToInsert = new ListNode(digitToInsert);
            l3.next = nodeToInsert;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            l3 = l3.next;
        }
        if (carry > 0) {
            ListNode carryNode = new ListNode(carry);
            l3.next = carryNode;
            l3 = l3.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListSum list = new LinkedListSum();

        // creating first list
        list.head1 = new ListNode(7);
        list.head1.next = new ListNode(5);
        list.head1.next.next = new ListNode(9);
        list.head1.next.next.next = new ListNode(1);
        System.out.println("First list is ");
        list.printList(head1);

        // creating second list
        list.head2 = new ListNode(8);
        list.head2.next = new ListNode(4);
        System.out.println("Second list is ");
        list.printList(head2);

        System.out.print("Resultant list is ");
        // add the two lists and see the result
        ListNode sumHead = list.addTwoLists(head1, head2);
        list.printList(sumHead);
    }
}
