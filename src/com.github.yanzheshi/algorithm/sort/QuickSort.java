package com.github.yanzheshi.algorithm.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author shiyanzhe
 */
public class QuickSort {
    public static void sort(List<Integer>  list, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = split(list, left, right);

        sort(list, 0, mid);
        sort(list, mid+ 1, right);

    }

    /**
     * 将数组分为左大，右小的两部分
     * 分割元素为列表第一个元素
     * @param list
     * @return
     */
    private static int split(List<Integer> list, int left, int right) {

        int spliter = list.get(left);

        while (true) {
            for (; left < right && list.get(right) >= spliter ; right--)
                ;

            if (right <= left) {
                list.set(left, spliter);
                return left;
            }

            list.set(left, list.get(right));
            left++;

            for(; left < right && list.get(left) <= spliter; left++)
                ;

            if (left >= right) {
                list.set(right, spliter);
                return right;
            }

            list.set(right, list.get(left));
            right--;
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println("排序前");
        list.forEach(System.out::println);

        QuickSort.sort(list, 0, list.size() - 1);

        System.out.println("排序后");
        list.forEach(System.out::println);


    }
}
