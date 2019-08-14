package OF_2019;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
 * 1 + 2 * 3 = 7
 * 1 * (2 + 3) = 5
 * 1 * 2 * 3 = 6
 * (1 + 2) * 3 = 9
 * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
 *
 * 输入描述:
 * 一行三个数a，b，c (1 <= a, b, c <= 10)
 *
 * 输出描述:
 * 能够获得的最大值
 *
 * 1 2 3
 *
 * 9
 */
public class Main_13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        List<Integer> resList = new ArrayList<>();

        resList.add(a + b + c);
        resList.add(a * b * c);
        resList.add((a + b) * c);
        resList.add(a * (b + c));
        resList.add(a * b + c);
        resList.add(a + b * c);

        resList = resList.stream().sorted().collect(Collectors.toList());

        System.out.println(resList.get(resList.size() - 1));
    }
}
