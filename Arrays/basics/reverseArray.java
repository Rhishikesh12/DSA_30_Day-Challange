package Arrays.basics;

public class reverseArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // using extra space
        int[] res = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[j] = arr[i];
            j++;
        }

        // In-place reversal of array
        int[] ans = inplace(arr);
        for (int i = 0; i < ans.length; i++) {
            System.err.print(ans[i]);
        }
    }

    private static int[] inplace(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }
}