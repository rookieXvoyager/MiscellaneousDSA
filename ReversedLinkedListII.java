import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReversedLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // the idea is to stored the nodes - preLeft, left, right and postRight
        // reverse from left to right
        if (head == null || head.next == null || left == right)
            return head;

        // using dummy to handle edge cases where l=1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // finding the node previous to left
        ListNode preLeft = dummy;
        for (int i = 1; i < left; i++)
            preLeft = preLeft.next;

        // first reversal node is after preLeft;
        ListNode revLeft = preLeft.next;

        // finding the node at reversed end
        ListNode revRight = dummy;
        for (int i = 1; i <= right; i++) {
            revRight = revRight.next;
        }
        // storing the element right after the reversed part
        ListNode postRight = revRight.next;
        // temporarily breaking the list

        revRight.next = null;
        // storing the head of the reversed part and connecting to preLeft
        ListNode reversedHead = reverse(revLeft);
        preLeft.next = reversedHead;

        ListNode curr = reversedHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        // Connecting the right of reversed to the postRight
        curr.next = postRight;
        return dummy.next;
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements in the linked list seperated spaces: ");
        String[] inp = sc.nextLine().split(" ");
        ListNode head = null;
        ListNode curr = null;
        for (int i = 0; i < inp.length; i++) {
            if (head == null) {
                head = new ListNode(Integer.parseInt(inp[i]));
                curr = head;
            } else {
                curr.next = new ListNode(Integer.parseInt(inp[i]));
                curr = curr.next;
            }
        }

        System.out.println("Enter the left position: ");
        int left = sc.nextInt();
        System.out.println("Enter the right position: ");
        int right = sc.nextInt();

        System.out.println("The initial linked list is:");
        printLL(head);

        ListNode reversedHead = reverseBetween(head, left, right);
        System.out.println("The reversed linked list is: ");
        printLL(reversedHead);

    }

    static void printLL(ListNode head) {
        if (head == null)
            return;

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print("->");

            }
            curr = curr.next;
        }
    }
}