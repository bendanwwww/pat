package basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序 (稳定排序)
 */
public class RadixSort {

    public static int[] sort(int[] needSort) {

        // 初始化桶
        List[] bucket = new ArrayList[10];

        //待排序数组的最大位数
        int figures = 0;

        // 遍历第一遍
        for(int s : needSort) {
            String sTmp = String.valueOf(s);
            figures = Math.max(figures, sTmp.length());
            // 取第一位
            int first = Integer.parseInt(String.valueOf(sTmp.toCharArray()[sTmp.length() - 1]));
            // 放入桶
            if(bucket[first] == null) {
                bucket[first] = new ArrayList();
            }
            bucket[first].add(s);
        }

        // 遍历剩余次数
        int num = 1;
        while (num < figures) {
            List[] bucketTmp = new ArrayList[10];
            for(List<Integer> b : bucket) {
                if(b == null){
                    continue;
                }
                for(int s : b) {
                    int state = 0;
                    String sTmp = String.valueOf(s);
                    // 判断位数
                    if(sTmp.length() > num) {
                        state = Integer.parseInt(String.valueOf(sTmp.toCharArray()[sTmp.length() - num - 1]));
                    }
                    // 放入桶
                    if(bucketTmp[state] == null) {
                        bucketTmp[state] = new ArrayList();
                    }
                    bucketTmp[state].add(s);
                }
            }
            bucket = bucketTmp;
            num++;
        }

        int[] sort = new int[needSort.length];

        int state = 0;
        for(List<Integer> b : bucket) {
            if(b == null){
                continue;
            }
            for(int s : b) {
                sort[state] = s;
                state++;
            }
        }

        return sort;
    }

    public static void main(String[] args) {
        int[] needSort = {4, 10, 3, 21, 100, 201, 99, 150};
        int[] sort = sort(needSort);
        System.out.println(Arrays.toString(sort));
    }
}
