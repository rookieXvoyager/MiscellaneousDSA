import java.util.*;

public class NextPermutation {
    static void nextPermutation(int[] arr) {
        // code here
        // step -1 determine the breaking index
        // breaking index refers to where the value suddenly dips
        // considered from end
        int breaking_idx = -1, n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breaking_idx = i;
                break;
            }
        }
        // if no breaking index has been found
        // current permutation is the largest
        // return the smallest (by reversing)

        if (breaking_idx == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        // find the smallest number right after the breaking index

        for (int i = n - 1; i >= breaking_idx; i--) {
            if (arr[i] > arr[breaking_idx]) {
                // replace the breaking point with the smallest largest
                // greater than the breaking point
                int temp = arr[i];
                arr[i] = arr[breaking_idx];
                arr[breaking_idx] = temp;
                break;
            }
        }
        // reverse the remaining so that this part contributes the right next permutaton
        reverse(arr, breaking_idx + 1, n - 1);
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           
            System.out.print(arr[i]);
             if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    static void reverse(int[] arr, int from, int to) {
        while (from < to) {
            int temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp_arr = sc.nextLine().split(" ");
        int[] arr = new int[inp_arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp_arr[i]);
        }
        System.out.println("Your current permutation is:");
        printArr(arr);
        nextPermutation(arr);
        System.out.println("The next permutation is:");
        printArr(arr);

    }
}