package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完 n 个格子你才能抵达终点。
 * 每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入描述:
 * 格子数n
 *
 * 输出描述:
 * 跳完n个格子到达终点的方法
 *
 * 2
 *
 * 2
 */
public class Main_42 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n < 2) {
            if(n == 0) {
                System.out.println(0);
            }
            if(n == 1) {
                System.out.println(1);
            }
            return;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i < dp.length ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[dp.length - 1]);

    }
}
