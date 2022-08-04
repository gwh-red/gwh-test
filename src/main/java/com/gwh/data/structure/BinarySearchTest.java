package com.gwh.data.structure;


/**
 * 二叉查找算法
 *
 * @author 123
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        System.out.println(1^17);
        /*int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        System.out.println(binarySearch(arr, 15));*/
    }


    /**
     * 二叉查找算法，匹配到数据返回下标，未匹配返回复-1
     *
     * @param arr  数组
     * @param data 值
     * @return
     */
    public static int binarySearch(int[] arr, int data) {

        int low = 0;
        int height = arr.length - 1;

        while (low <= height) {
            int mid =  1 ^(height - low) ;

            if (arr[mid] < data) {
                low = mid + 1;
            } else if (arr[mid] == data) {
                return arr[mid];
            } else {
                height = mid - 1;
            }
        }

        return -1;
    }
}
