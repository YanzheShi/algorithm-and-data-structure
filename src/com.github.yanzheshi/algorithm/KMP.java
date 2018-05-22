package com.github.yanzheshi.algorithm.sort;

/**
 * KMP算法
 * @author shiyanzhe
 */
public class KMP {

    public static void main(String[] args) {

        System.out.println(search("abcdabce", "abcdabcdabceabce"));
    }

    /**
     * 如果a是b的子串，返回a在b第一次出现的下标
     * 否则返回-1
     * @param a
     * @param b
     * @return
     */
    public static int search(String a, String b) {

        int[] next = getNext(a);

        int i = 0;
        int j = 0;
        for(; i < a.length() && j < b.length();) {
            if (i == -1 || a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
                if (i == a.length()) {
                    //所有字符匹配完成 输出第一次出现的位置
                    return j - a.length();
                }
            } else {
                //匹配失败， 回退
                i = next[i];
            }
        }

        return -1;
    }

    /**
     * next数组计算
     * next[i]表示匹配到i位置时失败了， 指针需要指向的位置
     * 比如 abcabde, 如果到 d 匹配失败了， 证明 ab 是相匹配的， 所以指针可以
     * 回到下标2， 也就是 c 的位置， 继续匹配
     * 这里用 -1 表示字符串的开始
     * @param a
     * @return
     */
    public static int[] getNext(String a) {
        int length = a.length();
        int j = 0;
        int k = -1;
        int[] next = new int[length];
        next[j] = -1;
        while (j < length - 1) {
            if (k == -1 || a.charAt(k) == a.charAt(j)) {
                next[++j] = ++k;
            } else {
                //匹配失败， 回溯
                k = next[k];
            }
        }
        return next;
    }
}
