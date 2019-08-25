package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 最大回文子串是被研究得比较多的一个经典问题。最近月神想到了一个变种，对于一个字符串，如果不要求子串连续，那么一个字符串的最大回文子串的最大长度是多少呢。
 *
 * 输入描述:
 * 每个测试用例输入一行字符串（由数字0-9，字母a-z、A-Z构成），字条串长度大于0且不大于1000.
 *
 * 输出描述:
 * 输出该字符串的最长回文子串的长度。（不要求输出最长回文串，并且子串不要求连续）
 *
 * adbca
 *
 * 3
 */
public class Main_23 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] in = sc.nextLine().toCharArray();

        int maxLength = 1;

        int[][] dp = new int[in.length][in.length];

        for(int r = 0 ; r < in.length ; r++) {
            dp[r][r] = 1;
            for(int l = r - 1 ; l >= 0 ; l--) {
                if(in[r] == in[l]) {
                    dp[l][r] = dp[l + 1][r - 1] + 2;
                }else{
                    dp[l][r] = Math.max(dp[l][r - 1], dp[l + 1][r]);
                }

                if(dp[l][r] > maxLength) {
                    maxLength = dp[l][r];
                }
            }
        }

        System.out.println(maxLength);
    }
}
