package tv.example;

import java.util.Arrays;

public class BinarySearch {

    private void findByBinary(int[] arr, int num) {
        Arrays.sort(arr);
        System.out.println("sorted array: " + Arrays.toString(arr));
        int low = 0, high = arr.length;
        int mid;
        int pos = 0;
        while (low < high) {
            mid = (low + high) / 2;

            if (num == arr[mid]) {
                pos = mid;
                break;
            } else if (num > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (pos == 0)
            System.out.println("number " + num + " isn't found in the array");
        else
            System.out.println("number " + num + " is found to be at position " + (pos + 1));
    }
}
