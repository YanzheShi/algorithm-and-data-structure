package com.github.yanzheshi.algorithm.sort;

import java.util.List;

/**
 * 堆排序
 * 思路：
 * 利用list构建大根堆， 堆顶下标为0
 * 然后拿出堆顶元素， 放到list 尾部， 下标为 size - 1， 该元素的位置， 即排序后的位置
 * 继续防止 size - 2 位置元素。
 * 调整堆， 继续拿出堆顶元素， 放到size - 2位置， 继续， 直到所有元素就位。
 * 相当于从大到小将元素防止在对应的位置上
 *
 *
 * 时间复杂度  logn
 * 空间复杂度  0  不需要额外的存储空间
 * @author shiyanzhe
 */
public class HeapSort implements Sort {
    @Override
    public void sort(List<Integer> list) {
        initHeap(list);

        for (int i = list.size() - 1; i > 0 ; i--) {
            int value = list.get(i);
            list.set(i, list.get(0));
            list.set(0, value);
            siftDown(list, 0, i);
        }
    }


    public static void initHeap(List<Integer> list) {
        //从第一个非叶子节点开始， 向下调整
        for (int i = list.size() / 2 - 1 ; i >= 0 ; i--) {
            siftDown(list, i, list.size());
        }
    }


    /**
     * 构建大根堆
     * @param list   数组
     * @param index  下调整位置
     * @param size   对大小
     */
    public static void siftDown(List<Integer> list, int index, int size) {
        int value = list.get(index);

        int nonleafIndex = size / 2;

        while (index < nonleafIndex) {

            int leftChildIndex = index * 2 + 1;
            if (leftChildIndex >= size) {
                return;
            }

            int rightChildIndex = leftChildIndex + 1;

            int nextIndex = leftChildIndex;
            if (rightChildIndex < size && list.get(leftChildIndex) < list.get(rightChildIndex)) {
                nextIndex = rightChildIndex;
            }

            if (list.get(nextIndex) < value) {
                return;
            }
            list.set(index, list.get(nextIndex));
            list.set(nextIndex, value);

            index = nextIndex;
        }
    }
}
