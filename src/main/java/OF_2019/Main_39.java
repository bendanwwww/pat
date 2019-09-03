package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入比特币前卖出。
 *
 * 输入描述:
 * 正整数数组，为以空格分隔的n个正整数
 *
 * 输出描述:
 * 最大利润
 *
 * 7 1 5 3 6 4
 *
 * 5
 */
public class Main_39 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] in = Arrays.stream(sc.nextLine().split(" ")).map(s -> Integer.parseInt(s)).toArray(Integer[] :: new);

        int max = 0;

        for(int i = 0 ; i < in.length - 1 ; i++) {
            int max_tmp = 0;
            int buy = in[i];
            for(int x = i + 1 ; x < in.length ; x++) {
                max_tmp = Math.max(max_tmp, in[x] - buy);
            }
            max = Math.max(max, max_tmp);
        }

        System.out.println(max);
    }
}
