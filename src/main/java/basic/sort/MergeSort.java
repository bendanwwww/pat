package basic.sort;

import java.util.Arrays;

/**
 * 归并排序 (稳定排序)
 */
public class MergeSort {

    public static int[] sort(int[] needSort) {
        sort(needSort, 0, needSort.length - 1);
        return needSort;
    }

    public static void sort(int[] needSort, int start, int end) {

        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(needSort, start, mid);
        sort(needSort, mid + 1, end);

        merge(needSort, start, mid, end);

    }

    public static void merge(int[] needSort, int start, int mid, int end) {
        int[] merges = new int[end - start + 1];

        int state = 0;
        int l = start;
        int r = mid + 1;

        while(l <= mid && r <= end) {
            if(needSort[l] < needSort[r]) {
                merges[state] = needSort[l];
                l++;
            }
            if(needSort[r] < needSort[l]) {
                merges[state] = needSort[r];
                r++;
            }
            state++;
        }

        while(l <= mid) {
            merges[state] = needSort[l];
            l++;
            state++;
        }

        while(r <= end) {
            merges[state] = needSort[r];
            r++;
            state++;
        }

        int s = start;
        for(int i = 0 ; i < merges.length ; i++) {
            needSort[s] = merges[i];
            s++;
        }
    }

    public static void main(String[] args) {
        int[] needSort = {4, 10, 3, 21, 100, 201, 99};
        int[] sort = sort(needSort);
        System.out.println(Arrays.toString(sort));
    }
}
