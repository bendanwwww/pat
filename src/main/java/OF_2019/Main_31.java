package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 解析加减法运算
 * 如：
 * 输入字符串："1+2+3" 输出："6"
 * 输入字符串："1+2-3" 输出："0"
 * 输入字符串："-1+2+3" 输出："4"
 * 输入字符串："1" 输出："1"
 * 输入字符串："-1" 输出："-1"
 *
 * 已知条件：输入的运算都是整数运算，且只有加减运算
 * 要求：输出为String类型，不能使用内建的eval()函数
 *
 * 输入描述:
 * 输入字符串："1+2+3"
 *
 * 输出描述:
 * 输出："6"
 *
 * 1+2+3
 *
 * 6
 */
public class Main_31 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String in = sc.nextLine();

        in = in.replaceAll("-", "+-");

        String[] adds = in.split("\\+");

        int out = 0;

        for(String s : adds) {
            if(s != null && !"".equals(s)) {
                out = out + Integer.parseInt(s);
            }
        }

        System.out.println(out);
    }
}
