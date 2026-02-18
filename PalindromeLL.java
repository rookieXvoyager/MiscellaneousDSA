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

public class PalindromeLL {
     public static  boolean isPalindrome(ListNode head) {
        if (head==null|| head.next==null)return true;
        ListNode head2 =new ListNode( head.val);
        ListNode curr1=head.next;
        ListNode curr2= head2;
        while(curr1!=null)
        {
            curr2.next= new ListNode(curr1.val);
            curr1=curr1.next;
            curr2=curr2.next;

        }

        curr2=reverse(head2);
        curr1=head;
        ;
        while (curr1!=null)
        {
            if (curr1.val!=curr2.val)return false;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head){
        ListNode prev=null, curr=head;
        while (curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
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
        if (isPalindrome(head)){
            System.out.println("The linked list is a palindrome");
        }else{
            System.out.println("The linked list isn't a palindrome");
        }
    }
}
