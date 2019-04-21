package com.aralsea.arithmetic.seniorSortArithmetic;

import com.aralsea.arithmetic.code.SortTestHelp;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序实现
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void quickSort(T[] array) {
        int n = array.length;
        quickSort(array, 0, n-1);
    }

    /**
     * 对array[l...r]部分进行快速排序
     * @param array
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable> void quickSort(T[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        // 划分计算,返回p下标位置，p所在左边数 < array[p], p所在右边  > array[p]
        int p = partition(array, l, r);
        // 递归调用p左边数组
        quickSort(array, l, p-1);
        // 递归调用p右边数组
        quickSort(array, p+1, r);
    }

    /**
     * 返回的p，使得array[l...p-1] < arr[p], array[p+1, r] > array[p]
     * @param array
     * @param l
     * @param r
     * @param <T>
     * @return
     */
    private static <T extends Comparable> int partition(T[] array, int l, int r) {
        // 将第一个元素当作中间值去比较其它数，小于v的值安排在左边，大于v的值安排在右边
        T v = array[l];

        // 依据图解，得知array[l+1...j] < v, array[j+1...i) > v
        // 要明白j范围末尾是开区间，j移动到末尾不能超过i
        int j = l; // j < l+1,表明初始值的时候j还不存在[l+1...j]，和[j+1...i)的范围
        for (int i = l + 1; i <= r; i++) {
            // 如果array[i] > v的情况，直接i往后移动就行，说明都不用操作.
            // 只有当array[i] < v的情况，array[i]与array[j+1]交换
            if (array[i].compareTo(v) < 0) {
                /*SortTestHelp.swap(array, j+1, i);
                j++;*/
                // 优雅的写法：先j+1操作，复制给j，再执行swap操作
                SortTestHelp.swap(array, ++j, i);
            }
        }
        // array[j]元素 v元素互换，v元素在array第一个元素array[l]
        SortTestHelp.swap(array, j, l);
        return j;
    }
}
