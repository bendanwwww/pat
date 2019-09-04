package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 输入描述:
 * 一串编码过的数字，比如12
 *
 * 输出描述:
 * 解码方法的总数
 *
 * 12
 *
 * 2
 */
public class Main_45 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] ins = String.valueOf(sc.nextInt()).toCharArray();

        if(ins.length == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[ins.length];

        dp[0] = 1;
        dp[1] = Integer.parseInt(String.valueOf(ins[0]) + String.valueOf(ins[1])) <= 26 ? 2 : 1;

        for(int i = 2 ; i < dp.length ; i++) {
            if(Integer.parseInt(String.valueOf(ins[i - 1])) == 1 || (Integer.parseInt(String.valueOf(ins[i - 1])) == 2 && Integer.parseInt(String.valueOf(ins[i])) <= 6)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[ins.length - 1]);
    }
}
