import java.util.*;
public class NextGreaterElement {
    
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        // the idea is to implement this using a monotonic decreasing stack 
        
        Stack <Integer> stack = new Stack<>();
        ArrayList<Integer> nge = new ArrayList<>();
        for (int i=arr.length-1;i>=0;i--)
        {
            while (!stack.isEmpty() && arr[stack.peek()]<=arr[i])
            stack.pop();
            nge.add(stack.isEmpty()?-1:arr[stack.peek()]);
            stack.push(i);
        }
         Collections.reverse(nge);
            return nge;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces:" );
        String [] inp = sc.nextLine().split(" ");
        int [] arr = new int [inp.length];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }

        System.out.println("The resultant nge array is: "+nextLargerElement(arr));
    }

}
