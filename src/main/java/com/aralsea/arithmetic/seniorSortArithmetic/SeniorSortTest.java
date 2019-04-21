package com.aralsea.arithmetic.seniorSortArithmetic;

import com.aralsea.arithmetic.code.InsertionSort;
import com.aralsea.arithmetic.code.ShellSort;
import com.aralsea.arithmetic.code.SortTestHelp;

import java.util.Arrays;

/**
 * 该机算法的排序测试
 */
public class SeniorSortTest {

    public static void main(String[] args) {
        int n1 = 10000;
        Integer[] array1 = SortTestHelp.generateRandomArray(n1, 0, n1);
        System.out.println(Arrays.toString(array1));
        // 复制
        Integer[] array2 = Arrays.copyOf(array1, n1);
        Integer[] array3 = Arrays.copyOf(array1, n1);
        Integer[] array4 = Arrays.copyOf(array1, n1);
        Integer[] array5 = Arrays.copyOf(array1, n1);
        Integer[] array6 = Arrays.copyOf(array1, n1);

        // 比较插入排序，希尔排序，归并排序的时间复杂度
        SortTestHelp.testSort("Insertion Sort:", InsertionSort::insertionSort2, array2);
        SortTestHelp.testSort("Shell Sort:", ShellSort::shellSort, array3);
        SortTestHelp.testSort("Merger Sort:", MergerSort::mergerSort, array4);
        SortTestHelp.testSort("Merger Sort BU:", MergerSort::mergerSortBU, array5);
        SortTestHelp.testSort("Quick Sort:", QuickSort::quickSort, array6);

        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));

        // 测试大数据量的归并排序和快速排序
        System.out.println("测试大数据量的归并排序和快速排序");
        int n2 = 10000000;
        Integer[] array7 = SortTestHelp.generateRandomArray(n2, 0, n2);
        Integer[] array8 = Arrays.copyOf(array7, n2);
        Integer[] array9 = Arrays.copyOf(array7, n2);
        SortTestHelp.testSort("Merger Sort:", MergerSort::mergerSort, array8);
        SortTestHelp.testSort("Quick Sort:", QuickSort::quickSort, array9);
    }
}
