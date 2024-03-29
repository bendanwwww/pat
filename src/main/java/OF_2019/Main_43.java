package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果，但是，每个孩子最多只能给一块糖果。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的糖果的最小尺寸；并且每块糖果 j ，都有一个尺寸 sj。
 * 如果 sj >= gi ，我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块糖果。
 *
 * 输入描述:
 * 第一行输入每个孩子的胃口值
 * 第二行输入每个糖果的尺寸
 * 孩子数和糖果数不超过1000
 *
 * 输出描述:
 * 能满足孩子数量的最大值
 *
 * 1 2 3
 * 1 1
 *
 * 1
 */
public class Main_43 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] kids = Arrays.stream(sc.nextLine().split(" ")).map(s -> Integer.parseInt(s)).sorted().toArray(Integer[] :: new);

        Integer[] sugars = Arrays.stream(sc.nextLine().split(" ")).map(s -> Integer.parseInt(s)).sorted().toArray(Integer[] :: new);

        int out = 0;

        int sugarState = 0;

        for(int i = 0 ; i < kids.length ; i++) {
            if(sugarState >= sugars.length) {
                break;
            }
            int x;
            for(x = sugarState ; x < sugars.length ; x++) {
                if(sugars[x] >= kids[i]) {
                    out++;
                    break;
                }
            }
            sugarState = x + 1;
        }

        System.out.println(out);

    }
}
