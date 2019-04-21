package com.aralsea.arithmetic.code;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    /**
     * 排序比较慢
     * 插入排序的实现
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                // 繁琐
                /*for (int j = i; j > 0; j--) {
                    if (array[j].compareTo(array[j-1]) < 0) {
                        // 交换
                        SortTestHelp.swap(array, j, j-1);
                    } else {
                        break;
                    }
                }*/

                // 改建方式
                for (int j = i; j > 0 && array[j].compareTo(array[j-1]) < 0; j--) {
                    // 交换
                    SortTestHelp.swap(array, j, j-1);
                }
            }
        }
    }

    /**
     * 改建方法2：
     * 排序比较快
     * 插入排序的实现
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort2(T[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                // 改建方式：寻找元素array[i]合适的插入的位置
                T e = array[i]; // 记录要插入的某个位置的array[i]元素
                int j; // j保存元素e应该插入的某个位置
                for (j = i; j > 0 && e.compareTo(array[j-1]) < 0; j--) {
                    // 当前元素比前面元素小，前面元素逐一往后赋值
                    array[j] = array[j-1];
                }
                // 插入数据
                array[j] = e;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3,6,2,9,7,5,8,0,1,4};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
