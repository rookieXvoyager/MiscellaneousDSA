import java.util.*;
import java.util.ArrayList;
import java.util.Stack;
public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // To solve this using a monotonic stack 
        // The idea is to maintain a maintain an increasing monotonic stack 
        Stack <Integer> stack = new Stack<>();
       
        ArrayList<Integer> nse = new ArrayList<>();
        for (int i=arr.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
            stack.pop();
            int nextSmallest =stack.isEmpty()?-1:arr[stack.peek()];
            nse.add(nextSmallest);
            stack.push(i);
            
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=nse.size()-1;i>=0;i--)
        res.add(nse.get(i));
        
        
        return res;
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

        System.out.println("The resultant nse array is: "+nextSmallerEle(arr));
    }

}
