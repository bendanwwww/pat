package basic.sort;

import java.util.Arrays;

/**
 * 堆排序 (不稳定排序)
 *
 * 左孩子 2i + 1
 * 右孩子 2i + 2
 * 父节点 floor((i - 1) / 2)
 */
public class HeapSort {

    public static int[] sort(int[] needSort) {

        // 初始化堆
        int state = needSort.length - 1;
        while(state > 0) {
            int stateTmp = state;
            // 计算父节点
            int fatherState = (int) Math.floor((stateTmp - 1) / 2);
            while(fatherState >= 0 && needSort[fatherState] < needSort[stateTmp]) {
                int tmp = needSort[fatherState];
                needSort[fatherState] = needSort[stateTmp];
                needSort[stateTmp] = tmp;
                stateTmp = fatherState;
                fatherState = (int) Math.floor((stateTmp - 1) / 2);
            }
            state--;
        }

        // 从堆头开始移除元素
        state = needSort.length - 1;
        while(state > 0) {
            int tmp = needSort[state];
            needSort[state] = needSort[0];
            needSort[0] = tmp;
            state--;

            //恢复为堆
            int stateTmp = 0;
            int leftKid = 1;
            int rightKid = 2;
            while(leftKid <= state || rightKid <= state) {
                // 如果左孩子和右孩子都比父节点小, 则交换两个孩子节点中大的那个
                if(leftKid <= state && rightKid <= state) {
                    int kidState = needSort[leftKid] > needSort[rightKid] ? leftKid : rightKid;
                    int t = needSort[stateTmp];
                    needSort[stateTmp] = needSort[kidState];
                    needSort[kidState] = t;

                    stateTmp = kidState;
                    leftKid = 2 * stateTmp + 1;
                    rightKid = 2 * stateTmp + 2;
                    continue;
                }

                if(leftKid <= state && needSort[leftKid] > needSort[stateTmp]) {
                    int t = needSort[stateTmp];
                    needSort[stateTmp] = needSort[leftKid];
                    needSort[leftKid] = t;

                    stateTmp = leftKid;
                    leftKid = 2 * stateTmp + 1;
                    rightKid = 2 * stateTmp + 2;
                    continue;
                }
                if(rightKid <= state && needSort[rightKid] > needSort[stateTmp]) {
                    int t = needSort[stateTmp];
                    needSort[stateTmp] = needSort[rightKid];
                    needSort[rightKid] = t;

                    stateTmp = rightKid;
                    leftKid = 2 * stateTmp + 1;
                    rightKid = 2 * stateTmp + 2;
                    continue;
                }
                break;
            }
        }

        return needSort;
    }

    public static void main(String[] args) {
        int[] needSort = {4, 10, 3, 21, 100, 201, 99};
        int[] sort = sort(needSort);
        System.out.println(Arrays.toString(sort));
    }
}
