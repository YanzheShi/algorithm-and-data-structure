package com.github.yanzheshi.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序实现
 * @author shiyanzhe
 */
public class MergeSort implements Sort{


    public void sort(List<Integer> list) {
        int size = list.size();

        if (size != 1) {
            //subList返回的是不可变List， 所以需要装饰为新的可变List
            List<Integer> left = new ArrayList<>(list.subList(0, size / 2));
            List<Integer> right = new ArrayList<>(list.subList(size / 2, size));
            sort(left);
            sort(right);
            list.clear();
            list.addAll(merge(left, right));
        }

    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> mergeResult = new ArrayList<>(left.size() + right.size());

        int i = 0;
        int j = 0;
        for(; i < left.size() && j < right.size(); ) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                mergeResult.add(left.get(i++));
            } else {
                mergeResult.add(right.get(j++));
            }
        }

        if (i != left.size()) {
            mergeResult.addAll(left.subList(i, left.size()));
        }

        if (j != right.size()) {
            mergeResult.addAll(right.subList(j, right.size()));
        }
        return mergeResult;
    }
}
