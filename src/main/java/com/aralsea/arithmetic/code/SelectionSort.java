package com.aralsea.arithmetic.code;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：O(n^2)
 */
public class SelectionSort {


    /**
     * 排序选择：单一类型参数传递
     * @param array
     */
    public static void getSort(Integer[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                // 记录下表的位置
                int subscript = i;
                for (int j = i + 1; j < length; j++) {
                    // 如果后面的数小于标记下标数字，更新下标位置
                    if (array[j] < array[subscript]) {
                        subscript = j;
                    }
                }
                // 替换
                int flag = array[i];
                array[i] = array[subscript];
                array[subscript] = flag;
            }
        }
    }

    /**
     *
     * 排序选择：使用泛型参数传递
     * @param array
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        if (null != array && array.length > 0) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                // 记录下表的位置
                int subscript = i;
                for (int j = i + 1; j < length; j++) {
                    // 如果后面的数小于标记下标数字，更新下标位置
                    if (array[j].compareTo(array[subscript]) < 0) {
                        subscript = j;
                    }
                }
                // 替换
                T flag = array[i];
                array[i] = array[subscript];
                array[subscript] = flag;
            }
        }
    }

    /**
     * Java封装好的方法
     * @param array
     */
    public static void getSOrtByJava(int[] array) {
        Arrays.sort(array);
    }


    public static void main(String[] args) {
        Integer[] array = {3,6,2,9,7,5,8,0,1,4};
        Float[] floats = {3.3f,6.6f,2.2f,9.9f,7.7f,5.5f,8.8f,0.0f,1.1f,4.4f};
        String[] strings = {"e", "g", "a", "c","k", "s"};
        //getSort(array);
        //getSOrtByJava(array);
        selectionSort(array);
        selectionSort(floats);
        selectionSort(strings);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(floats));
        System.out.println(Arrays.toString(strings));
        // 随机生成一个自定义大小，自定义区间的数组,并且进行排序
        Integer[] randomArray = SortTestHelp.generateRandomArray(1000, 50, 200);
        selectionSort(randomArray);
        System.out.println(Arrays.toString(randomArray));

        // 函数方法
        int n = 10000;
        Integer[] array2 = SortTestHelp.generateRandomArray(n, 0, n);
        SortTestHelp.testSort("测试SortName", SelectionSort::getSort, array2);
        System.out.println(Arrays.toString(array2));
    }
}
