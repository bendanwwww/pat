package OF_2019;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 *
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 *
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 *
 * 3 10
 * 1 2 4
 *
 * 8
 */
public class Main_08 {

    static int res = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int foodNumber = sc.nextInt();
        int bagVolume = sc.nextInt();

        List<Integer> foodList = new ArrayList<Integer>();
        long all = 0;
        for(int i = 0 ; i < foodNumber ; i++) {
            foodList.add(sc.nextInt());
            all = all + (long) foodList.get(i);
        }

        if(all <= bagVolume) {
            res = (int) Math.pow(2, foodNumber);
            System.out.println(res);
        }else{
            count(foodList, 0, 0, bagVolume);
            System.out.println(res);
        }

    }

    private static void count(List<Integer> foodList, long allFood, int state, int total) {
        if (state >= foodList.size()) {
            return;
        }
        if (allFood > total) {
            return;
        }
        // 不添加
        count(foodList, allFood, state + 1, total);
        // 添加
        if (allFood + foodList.get(state) <= total) {
            res++;
            count(foodList, allFood + foodList.get(state), state + 1, total);
        }
    }

}
