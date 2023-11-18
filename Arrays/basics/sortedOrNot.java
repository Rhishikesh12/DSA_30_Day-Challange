package Arrays.basics;

public class sortedOrNot {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 6, 7, 8 };

        int ans = isSorted(arr);
        if (ans == 0) {
            System.err.println("Array Not Sorted!!");
        } else if (ans == 1) {
            System.err.println("Array is Sorted!!");
        }
    }

    private static int isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return 0;
            }
        }
        return 1;
    }
}
