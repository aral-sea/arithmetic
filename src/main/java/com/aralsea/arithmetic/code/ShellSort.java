package com.aralsea.arithmetic.code;

/**
 * 希尔算法
 */
public class ShellSort {

    /**
     * 希尔算法
     * @param array
     * @param <T>
     */
    public static  <T extends Comparable<T>> void shellSort(T[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;  // 数组长度
            int d = length / 2; // 增量长度
            while (true) {
                for (int i = 0; i < d; i++) {
                    // 用增量长度序列分割，每段分别进行插入操作
                    for (int j = i + d; j < length; j+=d) {
                        // 按照插入排序思路排序
                        T e = array[j]; // 记录要插入的某个位置的array[j]元素
                        int k = j - d; // array[j]元素前个位置下标
                        for (; k >= 0 && e.compareTo(array[k]) < 0; k-=d) {
                            // 当前元素比前面元素小，前面元素逐一往后赋值，两个元素下标距离d增量长度
                            array[k+d] = array[k];
                        }
                        // 插入数据
                        array[k+d] = e;
                    }
                }
                // 当d = 1的时候，整体进行直接插入排序,停止循环
                if (d == 1) {
                    InsertionSort.insertionSort2(array);
                    break;
                }
                // 还未等于1，再次切分
                d /= 2;
            }
        }
    }
}
