package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 一个非空整数数组，选择其中的两个位置，使得两个位置之间的数和最大。
 * 如果最大的和为正数，则输出这个数；如果最大的和为负数或0，则输出0
 *
 * 输入描述:
 * 3,-5,7,-2,8
 *
 * 输出描述:
 * 13
 *
 * -6,-9,-10
 *
 * 0
 */
public class Main_32 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] inStrings = sc.nextLine().split(",");

        Integer[] ins = Arrays.stream(inStrings).map(s -> Integer.parseInt(s)).toArray(Integer[] :: new);

        int[] dp = new int[ins.length];

        int max = 0;

        dp[0] = ins[0];
        if(dp[0] > max) {
            max = dp[0];
        }


        for(int i = 1 ; i < ins.length ; i++) {
            dp[i] = Math.max(dp[i - 1] + ins[i], ins[i]);
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
