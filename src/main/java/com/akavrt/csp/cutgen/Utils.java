package com.akavrt.csp.cutgen;

import java.util.Arrays;

/**
 * User: akavrt
 * Date: 23.06.13
 * Time: 22:04
 */
public class Utils {

    public static void descendingSort(int[] a) {
        // sort array in ascending order
        Arrays.sort(a);

        // reverse order of elements in sorted array
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            // exchange the left and right elements
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            // move the bounds toward the center
            left++;
            right--;
        }
    }
}
