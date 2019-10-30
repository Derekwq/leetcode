package com.derek.leetcode;

/**
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class Tool {

    protected static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
