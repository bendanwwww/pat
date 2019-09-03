package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 小招喵喜欢吃喵粮。这里有 N 堆喵粮，第 i 堆中有 p[i] 粒喵粮。喵主人离开了，将在 H 小时后回来。
 *
 * 小招喵可以决定她吃喵粮的速度 K （单位：粒/小时）。每个小时，她将会选择一堆喵粮，从中吃掉 K 粒。如果这堆喵粮少于 K 粒，她将吃掉这堆的所有喵粮，然后这一小时内不会再吃更多的喵粮。
 *
 * 小招喵喜欢慢慢吃，但仍然想在喵主人回来前吃掉所有的喵粮。
 *
 * 返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
 *
 * 输入描述:
 * 第一行输入为喵粮数组，以空格分隔的N个整数
 * 第二行输入为H小时数
 *
 * 输出描述:
 * 最小速度K
 *
 * 3 6 7 11
 * 8
 *
 * 4
 */
public class Main_40 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] foods = Arrays.stream(sc.nextLine().split(" ")).map(s -> Integer.parseInt(s)).toArray(Integer[] :: new);

        int hours = Integer.parseInt(sc.nextLine());

        int k = 1;

        while(true) {
            int hourTmp = 0;
            boolean b = true;
            for(int food : foods) {
                if(food % k == 0) {
                    hourTmp = hourTmp + food / k;
                }else{
                    hourTmp = hourTmp + food / k + 1;
                }
                if(hourTmp > hours) {
                    b = false;
                    break;
                }
            }
            if(b && hourTmp <= hours) {
                System.out.println(k);
                break;
            }
            k++;
        }

    }
}
