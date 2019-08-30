package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 输入年、月、日，计算该天是本年的第几天。
 *
 * 输入：
 * 包括三个整数年(1<=Y<=3000)、月(1<=M<=12)、日(1<=D<=31)。
 *
 * 输出：
 * 输入可能有多组测试数据，对于每一组测试数据，
 * 输出一个整数，代表Input中的年、月、日对应本年的第几天。
 *
 *
 * 输入描述:
 * 输入：1990 9 20
 *
 * 输出描述:
 * 输入：263
 *
 * 2000 5 1
 *
 * 122
 */
public class Main_34 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] ins = sc.nextLine().split(" ");

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int out = 0;

        int year = Integer.parseInt(ins[0]);
        int month = Integer.parseInt(ins[1]);
        int day = Integer.parseInt(ins[2]);

        for(int i = 0 ; i < month - 1 ; i++) {
            out = out + days[i];
        }

        out = out + day;

        if(year % 4 == 0 && year % 100 != 0 && month > 2) {
            out++;
        }

        System.out.println(out);
    }
}
