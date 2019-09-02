package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 *
 * 输入描述:
 * 输入一个长度为N，且只包含C和D的非空字符串。
 *
 * 输出描述:
 * 使得最后仅有一对鸡鸭相邻，最少的交换次数
 *
 * CCDCC
 *
 * 2
 */
public class Main_38 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] ins = sc.nextLine().toCharArray();

        int state = 0;

        int min = 0;

        for(int i = 0 ; i < ins.length ; i++) {

        }

        System.out.println(min);
    }
}
