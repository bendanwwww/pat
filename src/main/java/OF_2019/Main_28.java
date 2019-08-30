package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 有重量分别为3，5，7公斤的三种货物，和一个载重量为X公斤的箱子（不考虑体积等其它因素，只计算重量）
 * 需要向箱子内装满X公斤的货物，要求使用的货物个数尽可能少（三种货物数量无限）
 *
 * 输入描述:
 * 输入箱子载重量X(1 <= X <= 10000)，一个整数。
 *
 * 输出描述:
 * 如果无法装满，输出 -1。
 * 如果可以装满，输出使用货物的总个数。
 *
 * 4
 *
 * -1
 */
public class Main_28 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int weight = sc.nextInt();

        int[] numbers = new int[10001];

        numbers[0] = 0;
        numbers[1] = numbers[2] = numbers[4] = Integer.MAX_VALUE;
        numbers[3] = numbers[5] = numbers[7] = 1;
        numbers[6] = 2;

        for(int i = 8 ; i <= 10000 ; i++) {
            numbers[i] = Math.min(numbers[i - 3], Math.min(numbers[i - 5], numbers[i - 7]));
            if(numbers[i] < Integer.MAX_VALUE) {
                numbers[i] = numbers[i] + 1;
            }
        }

        if(numbers[weight] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(numbers[weight]);
        }

    }
}
