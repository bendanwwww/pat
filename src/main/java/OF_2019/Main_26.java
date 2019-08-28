package OF_2019;


import java.util.Scanner;

/**
 * 题目描述
 * 请实现一个函数，功能为合并两个升序数组为一个升序数组
 *
 * 输入描述:
 * 输入有多个测试用例，每个测试用例有1-2行，每行都是以英文逗号分隔从小到大排列的数字
 *
 * 输出描述:
 * 输出一行以英文逗号分隔从小到大排列的数组
 *
 * 1,5,7,9
 * 2,3,4,6,8,10
 *
 * 1,2,3,4,5,6,7,8,9,10
 */
public class Main_26 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String in1 = sc.nextLine();

        if (!sc.hasNext()) {
            System.out.println(in1);
            return;
        }

        String in2 = sc.nextLine();

        String[] ins1 = in1.split(",");
        String[] ins2 = in2.split(",");

        int state = 0;

        String out = "";

        for(int i = 0 ; i < ins1.length ; i++) {
            if(state >= ins2.length) {
                out = out + ins1[i] + ",";
                continue;
            }
            if(Integer.valueOf(ins1[i]) > Integer.valueOf(ins2[state])) {
                out = out + ins2[state] + ",";
                i--;
                if(i < ins1.length - 1) {
                    state++;
                }

            }else{
                out = out + ins1[i] + ",";
            }
        }


        if(ins2.length > state) {
            for(int i = state ; i < ins2.length ; i++) {
                out = out + ins2[i] + ",";
            }
        }

        out = out.substring(0, out.length() - 1);

        System.out.println(out);
    }
}
