import java.util.*;
import java.util.Stack;
class SumOfSubarrayMin {
    // public int sumSubMins(int[] arr) {
    //     // code here
    //     int sum=0;
    //     for (int i=0;i<arr.length;i++)
    //     for(int j=i;j<arr.length;j++)
    //     sum+=findMin(arr, i,j);
    //     return sum;
    // }
    
    // static int findMin(int [] arr, int i, int j)
    // {
    //     int min=Integer.MAX_VALUE;
    //     for (int k=i;k<=j;k++)
    //     {
    //         min=Math.min(arr[k],min);
    //     }
    //     return min;
    // }
        
    public static int sumSubMins(int[] arr) {
        // the above idea is brute force 
        //  the updated idea is to use psee and nse to determine the range 
        // in which an element remains minimum
        // we then multiply the element with the no. of subarrs in which it is minimal
        
        int [] psees=psee(arr);
        int [] nses=nse(arr);
        int total=0;
        for (int i=0;i<arr.length;i++)
        {
            int left =i-psees[i], right =nses[i]-i;
            total +=(long)(left*right)*arr[i];
        }
        return total;
        
    }
    
    static int [] psee(int [] arr){
        // determining the previous smallest element or element equal to the curr el
        int idx=0;
        int [] res = new int [arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i])
                stack.pop();
            int psee =stack.isEmpty()? -1:stack.peek();
            res[idx++]=psee;
            stack.push(i);
        }
        return res;
    }
    
    static int [] nse (int [] arr){

        // determining the idx pos of the next smaller ele to the curr element
        int idx =arr.length-1;
        int [] res = new int [arr.length];
        Stack <Integer> stack = new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            int nse = stack.isEmpty()?arr.length:stack.peek();
            res[idx--]=nse;

            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array seperated by spaces: ");
        String [] inp =sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The sum of minimum of all subarrays is : "+sumSubMins(arr));
    }
}
