package Arrays.medium;

import java.util.*;

public class removeDuplicates {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 3, 3 };
        int k = removeDuplicatesElements(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int removeDuplicatesElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return k;
    }
}
