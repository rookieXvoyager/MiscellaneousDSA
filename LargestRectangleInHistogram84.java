import java.util.*;

class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the histogram heights seperated by spaces:");
        String[] inp = sc.nextLine().split(" ");
        int[] heights = new int[inp.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(inp[i]);
        }
        System.out.println(
                "The maximum area that can be achieved in the given histogram is: " + largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] arr) {
        // to determine the largest possible rectangle, the ideda is to
        // for any element, determine the previous smaller elemmt index
        // similarly find the next smaller element idx in the array
        // the maximum area offered by this element will be its height multiplied ny its
        // width
        // width will be the nse index - pse index -1

        int[] pse = pse(arr);
        int[] nse = nse(arr);
        int maxArea = 0;

        for (int i = 0; i < arr.length; i++) {
            maxArea = Math.max((nse[i] - pse[i] - 1) * arr[i], maxArea);
        }
        return maxArea;
    }

    static int[] pse(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    static int[] nse(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return res;
    }
}