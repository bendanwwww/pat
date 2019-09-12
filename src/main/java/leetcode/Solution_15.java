package leetcode;

/**
 * 题目描述
 *
 * 现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。
 * 注意：
 * 你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么？
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution_15 {

    public int singleNumber(int[] A) {
        int num = 0;
        for(int i = 0 ; i < A.length ; i++) {
            num ^= A[i];
        }
        return num;
    }

    public static void main(String[] args) {
        Solution_15 solution = new Solution_15();
        int res = solution.singleNumber(new int[]{1, 2, 2, 3, 3});
        System.out.println(res);
    }
}
