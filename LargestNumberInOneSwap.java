import java.util.*;
class LargestNumberInOneSwap{
    public static String largestSwap(String s) {
        // code here
        // the idea is to find the largest suffix element swappable for the current idx from right
        int left =-1, right=-1;
        int n =s.length();
        int maxIdx =n-1;
        char [] arr =s.toCharArray();
        for (int i =n-1;i>=0;i--){
            //  if the encountered value is greater than prev, update max idx
            
            if (arr[i]-'0'>arr[maxIdx]-'0')
            {
                maxIdx=i;
            }else if (arr[i]-'0'<arr[maxIdx]-'0')
            {
                left =i;
                right =maxIdx;
            }
        }
        
        //  swap if required
        if (left!=-1)
        {
            swap(left, right, arr);
        }
        return String.valueOf(arr);
    }
    
    static void swap(int left, int right, char [] arr)
    {
        char temp = arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        
    }
public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter the number as a String");
    String inp =sc.nextLine();
    System.out.println("The largest number obtained by performing one swap is:"+largestSwap(inp)    );
}
}