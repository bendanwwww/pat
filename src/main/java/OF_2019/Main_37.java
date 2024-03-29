package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 你需要爬上一个N层的楼梯，在爬楼梯过程中， 每阶楼梯需花费非负代价，第i阶楼梯花费代价表示为cost[i]， 一旦你付出了代价，你可以在该阶基础上往上爬一阶或两阶。
 * 你可以从第 0 阶或者 第 1 阶开始，请找到到达顶层的最小的代价是多少。
 * N和cost[i]皆为整数，且N∈[2,1000]，cost[i]∈ [0, 999]。
 *
 * 输入描述:
 * 输入为一串半角逗号分割的整数，对应cost数组，例如
 * 10,15,20
 *
 * 输出描述:
 * 输出一个整数，表示花费的最小代价
 *
 * 1,100,1,1,1,100,1,1,100,1
 *
 * 6
 */
public class Main_37 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] steps = Arrays.stream(sc.nextLine().split(",")).map(s -> Integer.parseInt(s)).toArray(Integer[] :: new);

        int[] dp = new int[steps.length + 1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2 ; i <= steps.length ; i++) {
            dp[i] = Math.min(dp[i - 2] + steps[i - 2], dp[i - 1] + steps[i - 1]);
        }

        System.out.println(dp[dp.length - 1]);
    }
}
