package com.aralsea.arithmetic.seniorSortArithmetic;

import java.lang.reflect.Array;

/**
 * 归并排序
 */
public class MergerSort {

    /**
     * 归并排序
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void mergerSort(T[] array) {
        int n = array.length;
        mergerSort(array, 0, n-1);
    }

    /***
     * 递归使用归并排序，对array[l...r]的范围进行排序
     * @param array
     * @param left
     * @param right
     * @param <T>
     */
    private static <T extends Comparable> void mergerSort(T[] array, int left, int right) {
        // 当左元素下标大于或者等于右元素下标的情况，说明只有一个或者没有元素，不允许存在这种情况。
        if (left >= right) {
            return;
        }

        // 计算中间下标
        int mid = (left + right) /2; //这里隐藏Bug，left+right数字很大，会出现int最大值，这里不做处理，主要是学习算法思路

        // 左边列
        mergerSort(array, left, mid);
        // 右边列
        mergerSort(array, mid + 1, right);
        /*// 合并
        merger(array, left, mid, right);*/
        // 优化：当左列的最后一个值 等于或者小于 右列的第一个值，就不需要再合并，已经是排好序的，无需再从新合并。
        // 只有array[mid] > array[mid + 1]
        if (array[mid].compareTo(array[mid + 1]) > 0) {
            merger(array, left, mid, right);
        }
    }

    /**
     * 将array[left ... mid] 和 array[mid+1 ... right]两部分进行归并
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param <T>
     */
    private static <T extends Comparable> void merger(T[] array, int left, int mid, int right) {
        // 开辟一个辅助数组，将数组的[left ... right] 复制过去
        Object[] aux = new Object[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = array[i];
        }

        // 声明array[left ... mid] 和 array[mid+1 ... right]的两列开始位置
        int i = left;
        int j = mid + 1;
        // 使用辅助数组进行遍历
        for (int k = left; k <= right; k++) {
            // 验证i > mid， j > right 是否超出越界
            if (i > mid) { // 或者 i > mid && j <= right
                // 当辅助左数组下标超出界线，辅助右数组存在数组，因为遍历array范围[left, right]
                array[k] = (T) aux[j - left];
                j++; // 辅助右数组下标加1
            } else if (j > right) { // 或者 j > right && i <= mid
                // 当辅助右数组下标超出界线，辅助数组左存在数组，因为遍历array范围[left, right]
                array[k] = (T)aux[i - left];
                i++; // 辅助左数组下标加1
            } else if (((T) aux[i - left]).compareTo(aux[j - left]) < 0) {
                // 当辅助左数组指向的数据小于辅助右数组指向的数据，从两数组开始位置比较，取小的
                array[k] = (T) aux[i - left];
                i++; // 辅助左数组下标加1
            } else {
                // 当辅助右数组指向的数据小于辅助左数组指向的数据，从两数组开始位置比较，取小的
                array[k] = (T) aux[j - left];
                j++; // 辅助右数组下标加1
            }
        }

    }

    /**
     * 归并排序（自底向上）
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void mergerSortBU(T[] array) {
        int n = array.length;
        for (int sz = 1; sz <= n; sz += sz ) { // 归并次数
            for (int i = 0; i + sz < n; i += sz + sz) { // 防止i+sz越界
                // 对array[i...i+sz-1],array[i+sz, i+sz+sz-1]进行归并
                merger(array, i, i+sz-1, min(i+sz+sz-1, n-1)); // 防止 i+sz+sz-1越界n长度

            }
        }
    }

    /**
     * 比较a和b，去最小值,如果a小于b，取a，否则取b
     * @param a
     * @param b
     * @return
     */
    private static int min (int a, int b) {
        return a < b ? a : b;
    }
}
