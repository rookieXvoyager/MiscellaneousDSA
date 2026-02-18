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

public class BinInLLToInt {
    public static int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;
        if (head.next == null)
            return head.val;
        StringBuilder bin = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            bin.append(curr.val);
            curr = curr.next;

        }

        int integral = 0, power = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            integral += (bin.charAt(i) == '1') ? Math.pow(2, power) : 0;
            power++;
        }
        return integral;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the linked list seperated by spaces:");
        String[] inp = sc.nextLine().split(" ");
        ListNode head = null, curr = null;
        for (int i = 0; i < inp.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(inp[i]));
            if (head == null) {
                head = node;
                curr=head;
            } else {
                curr.next = node;
                curr = curr.next;
            }

        }
        System.out.println("The integer value of the binary represented as linked list is " + getDecimalValue(head));
    }
}
