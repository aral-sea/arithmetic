package com.aralsea.arithmetic.code;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 排序帮助类
 */
public class SortTestHelp {

    /**
     * 生成随机数组
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(Integer n, Integer rangeL, Integer rangeR) {
        if (null == n
                || n < 1
                || null == rangeL
                || null == rangeR
                || rangeL >= rangeR) {
            throw new IllegalArgumentException("参数不合法");
        }

        // 生成n个元素的随机数组，每个元素的范围为[rangeL, rangeR]
        Random random = new Random();
        Integer[] array = new Integer[n];
        for(int i = 0; i < n; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE) % (rangeR - rangeL + 1) + rangeL;
        }
        return array;
    }

    /**
     * 生成接见（似乎）有序的随机数组
     * @param n 数组长度
     * @param swapTimes 交换组数
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(Integer n, Integer swapTimes) {
        // 开辟一个空间，遍历n的生成有序随机数组
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        // 交换swapTimes组数据，进行打乱有序排序
        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            // 随机数求余，生成两个在n范围之内的下标
            int posx = random.nextInt(Integer.MAX_VALUE) % n;
            int posy = random.nextInt(Integer.MAX_VALUE) % n;
            // 替换
            swap(array, posx, posy);
        }
        return array;
    }

    /**
     * 测试排序的时间周期
     * @param sortName
     * @param sort
     * @param array
     * @param <T>
     */
    public static  <T> void testSort(String sortName, Consumer<T[]> sort, T[] array) {
        // 纳秒
        long statrTime = System.nanoTime();
        sort.accept(array);
        long endTime = System.nanoTime();
        System.out.println(String.valueOf(endTime - statrTime));
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(endTime - statrTime));
        System.out.println(bigDecimal.doubleValue());
        BigDecimal divide = bigDecimal.divide(new BigDecimal("1000000000"));
        System.out.println(sortName + " : " + divide.doubleValue() + "秒");
    }

    /**
     * 验证排序正确性：升序
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        if (null != array) {
            int length = array.length;
            for (int i = 0; i < length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 数组值相互替换
     * @param array
     * @param sub1
     * @param sub2
     * @param <T>
     */
    public static <T> void  swap(T array[], Integer sub1, Integer sub2) {
        T temp = array[sub1];
        array[sub1] = array[sub2];
        array[sub2] = temp;
    }
}
