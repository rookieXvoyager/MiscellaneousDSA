// 396. Rotate Function
// Solved
// Medium

// You are given an integer array nums of length n.

// Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:

// F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
// Return the maximum value of F(0), F(1), ..., F(n-1).

// The test cases are generated so that the answer fits in a 32-bit integer.

 

// Example 1:

// Input: nums = [4,3,2,6]
// Output: 26
// Explanation:
// F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
// F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
// F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
// F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
// So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

import java.util.*;
public class RotateFunction396{
    public static int maxRotateFunction(int[] nums) {
        // the idea is to maintain the total sum and the inital config sum 
        //  then we find the sums of subsequent arrangements by manipulating the current sums value
        int sum=0, configSum=0;
        for (int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            configSum+=i*nums[i];

        }

        int res = configSum;
        // rotating the array in the anticlockwise direction for every neew configuration
        // the last element becomes the first and other shift towards right
        //  now find the updated sum by 
        //  increasing the value of each element's contribution by adding sum-last el
        // reduce last el*length of array -1 times
        for ( int i=nums.length-1;i>0;i--)
        {
            configSum=configSum+sum-nums.length*nums[i];
            res=Math.max(configSum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by space: ");
        String [] inp =sc.nextLine().split(" ");
        int [] nums =new int[inp.length];
        for ( int i=0;i<nums.length;i++)
        {
            nums[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The maximum configuration obtained by rotating array in clockwise direction is:"+maxRotateFunction(nums));
    }
} 

