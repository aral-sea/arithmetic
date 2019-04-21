package com.aralsea.arithmetic.code;

/**
 * 冒泡排序（课程中当作作业）
 */
public class BubbleSort {

    /**
     * 冒泡排序：
     * 原理：比较两个相联的元素，讲值大的元素交换到右端
     * N个数字要排序完成，总共要进行N-1趟排序，每i趟的排序次数为N-i次，
     * 可以使用双循环，外循环控制每趟，内循环控制循环次数
     * @param array
     * @param <T>
     */
    public static  <T extends Comparable<T>> void bubbleSort(T[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            for (int i = length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    // 左边大于右边，交换
                    if (array[j].compareTo(array[j+1]) > 0) {
                        SortTestHelp.swap(array, j, j+1);
                    }
                }
            }
        }
    }
}
