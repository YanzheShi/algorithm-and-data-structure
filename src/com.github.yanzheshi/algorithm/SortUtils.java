package com.github.yanzheshi.algorithm;

import com.github.yanzheshi.algorithm.sort.MergeSort;
import com.github.yanzheshi.algorithm.sort.QuickSort;
import com.github.yanzheshi.algorithm.sort.Sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author shiyanzhe
 */
public class SortUtils {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println("排序前");
        System.out.println(list);

        Sort sort = new MergeSort();

        sort.sort(list);

        System.out.println("排序后");
        System.out.println(list);
    }
}
