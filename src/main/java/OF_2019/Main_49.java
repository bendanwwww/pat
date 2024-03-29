package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 我们部门要排队唱歌，大家乱哄哄的挤在一起，现在需要按从低到高的顺序拍成一列，但每次只能交换相邻的两位，请问最少要交换多少次
 *
 * 输入描述:
 * 第一行是N（N<50000）,表示有N个人
 * 然后每一行是人的身高Hi（Hi<2000000,不要怀疑，我们以微米计数），持续N行，表示现在排列的队伍
 *
 * 输出描述:
 * 输出一个数，代表交换次数。
 *
 * 6
 * 3
 * 1
 * 2
 * 5
 * 6
 * 4
 *
 * 4
 */
public class Main_49 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] peoples = new int[n];

        for(int i = 0 ; i < n ; i++) {
            peoples[i] = sc.nextInt();
        }

        int out = 0;

        for(int i = 0 ; i < peoples.length ; i++) {
            for(int x = i + 1 ; x < peoples.length ; x++) {
                if(peoples[i] > peoples[x]) {
                    out++;
                    int tmp = peoples[i];
                    peoples[i] = peoples[x];
                    peoples[x] = tmp;
                }
            }
        }

        System.out.println(out);

    }
}
