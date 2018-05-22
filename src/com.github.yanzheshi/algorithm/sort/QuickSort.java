package com.github.yanzheshi.algorithm.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 快速排序实现
 *
 * @author shiyanzhe
 */
public class QuickSort {
    public static void sort(List<Integer> list, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = split(list, left, right);

        sort(list, 0, mid);
        sort(list, mid + 1, right);

    }

    /**
     * 将数组分为左大，右小的两部分
     * 分割元素为列表第一个元素
     * 取区间第一个元素作为分割元素pivot
     * @param list
     * @return
     */
    private static int split(List<Integer> list, int left, int right) {

        int pivot = list.get(left);

        while (true) {
            for (; left < right && list.get(right) >= pivot; right--)
                ;

            if (right <= left) {
                list.set(left, pivot);
                return left;
            }

            list.set(left, list.get(right));
            left++;

            for (; left < right && list.get(left) <= pivot; left++)
                ;

            if (left >= right) {
                list.set(right, pivot);
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
        System.out.println(list);

        QuickSort.sort(list, 0, list.size() - 1);

        System.out.println("排序后");
        System.out.println(list);


    }
}
