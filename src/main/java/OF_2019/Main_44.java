package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 给定一个字符串来代表一个员工的考勤纪录，这个纪录仅包含以下两个字符：
 * 'A' : Absent，缺勤
 * 'P' : Present，到场
 * 如果一个员工的考勤纪录中不超过两个'A'(缺勤),那么这个员工会被奖赏。
 *
 * 如果你作为一个员工，想在连续N天的考勤周期中获得奖赏，请问有多少种考勤的组合能够满足要求
 *
 * 输入描述:
 * 考勤周期的天数N（正整数）
 *
 * 输出描述:
 * 这N天里能获得奖赏的考勤组合数
 *
 * 3
 *
 * 7
 */
public class Main_44 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int out = n + 1;

        for(int i = n - 1 ; i > 0 ; i--) {
            out = out + i;
        }

        System.out.println(out);
    }
}
