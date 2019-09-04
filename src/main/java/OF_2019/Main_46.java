package OF_2019;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 公司组织团建活动，到某漂流圣地漂流，现有如下情况：
 * 员工各自体重不一，第 i 个人的体重为 people[i]，每艘漂流船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 为节省开支，麻烦帮忙计算出载到每一个人所需的最小船只数(保证每个人都能被船载)。
 *
 * 输入描述:
 * 第一行输入参与漂流的人员对应的体重数组，
 *
 * 第二行输入漂流船承载的最大重量
 *
 * 输出描述:
 * 所需最小船只数
 *
 * 1 2
 * 3
 *
 * 1
 */
public class Main_46 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] peoples = Arrays.stream(sc.nextLine().split(" ")).map(s -> Integer.parseInt(s)).sorted().toArray(Integer[] :: new);

        Integer boat = Integer.parseInt(sc.nextLine());

        int out = 0;

        int l = 0;
        int r = peoples.length - 1;

        while(l <= r) {
            out++;
           if(l == r) {
               break;
           }
           if(peoples[l] + peoples[r] <= boat) {
               l++;
               r--;
           }else{
                r--;
           }
        }

        System.out.println(out);

    }
}
