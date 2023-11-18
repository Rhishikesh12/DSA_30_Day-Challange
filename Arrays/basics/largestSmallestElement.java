package Arrays.basics;

public class largestSmallestElement {
    public static void main(String[] args) {
        int[] arr = { 10, 100, 4, 6, 2, 70 };
        int maxNumber = arr[0];
        int smallest = arr[0];

        // Largest Element in Array
        for (int i = 0; i < arr.length; i++) {
            if (maxNumber < arr[i]) {
                maxNumber = arr[i];
            }
        }

        // smallest elements in array
        for (int j = 0; j < arr.length; j++) {
            if (smallest > arr[j]) {
                smallest = arr[j];
            }
        }

        System.err.println("Largest Element : " + maxNumber);
        System.err.println("Smallest Element : " + smallest);

    }
}
