package com.aralsea.arithmetic.code;

import java.util.Arrays;

/**
 * 测试
 */
public class SortTest {

    public static void main(String[] args) throws InterruptedException {
        // 测试选择排序的时间复杂度
        /*int n1 = 10000;
        int n2 = 100000;
        Integer[] array1 = SortTestHelp.generateRandomArray(n1, 0, n1);
        Integer[] array2 = SortTestHelp.generateRandomArray(n2, 0, n2);
        SortTestHelp.testSort("1万数量的selectionSort", SelectionSort::getSort, array1);
        SortTestHelp.testSort("10万数量的selectionSort", SelectionSort::getSort, array2);*/

        // 测试选择排序 和 插入排序的时间比较
        int n1 = 10000;
        // 1.insertionSort2与selectionSort差不多，没有优化的insertionSort时间最长
        Integer[] array1 = SortTestHelp.generateRandomArray(n1, 0, n1);
        // 2.重复多的元素数组，插入排序比选择排序快
        // Integer[] array1 = SortTestHelp.generateRandomArray(n1, 0, 3);
        // 复制一份
        Integer[] array2 = Arrays.copyOf(array1, n1);
        Integer[] array3 = Arrays.copyOf(array1, n1);
        Integer[] array6 = Arrays.copyOf(array1, n1);
        Integer[] array7 = Arrays.copyOf(array1, n1);
        SortTestHelp.testSort("10万数量的selectionSort", SelectionSort::selectionSort, array1);
        SortTestHelp.testSort("10万数量的insertionSort", InsertionSort::insertionSort, array2);
        SortTestHelp.testSort("10万数量的insertionSort2", InsertionSort::insertionSort2, array3);
        SortTestHelp.testSort("10万数量的BubbleSort", BubbleSort::bubbleSort, array6);
        System.out.println(Arrays.toString(array7));
        SortTestHelp.testSort("10万数量的ShellSort", ShellSort::shellSort, array7);
        System.out.println(Arrays.toString(array7));

        // 3.生成一个似乎接见排序的数组, 比较一下插入排序和选择排序，明显插入排序快于选择排序
        int n2 = 10000;
        Integer[] array4 = SortTestHelp.generateNearlyOrderedArray(n2, 10);
        Integer[] array5 = Arrays.copyOf(array4, n2);
        SortTestHelp.testSort("10万数量的selectionSort", SelectionSort::selectionSort, array4);
        SortTestHelp.testSort("10万数量的insertionSort2", InsertionSort::insertionSort2, array5);

    }
}
