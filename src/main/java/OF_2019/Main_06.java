package OF_2019;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 *
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 *
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 *
 * 输入描述:
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 *
 * 输出描述:
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 *
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 *
 * 2
 */
public class Main_06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Integer[][]> coordinateList = new ArrayList<>();

        // 左下横坐标
        for(int i = 0 ; i < num ; i++) {
            Integer[][] tmp = new Integer[2][2];
            tmp[0][0] = sc.nextInt();
            coordinateList.add(tmp);
        }

        // 左下纵坐标
        for(int i = 0 ; i < num ; i++) {
            Integer[][] tmp = coordinateList.get(i);
            tmp[0][1] = sc.nextInt();
            //coordinateList.add(i, tmp);
        }

        // 右上横坐标
        for(int i = 0 ; i < num ; i++) {
            Integer[][] tmp = coordinateList.get(i);
            tmp[1][0] = sc.nextInt();
            //coordinateList.add(i, tmp);
        }

        // 右上纵坐标
        for(int i = 0 ; i < num ; i++) {
            Integer[][] tmp = coordinateList.get(i);
            tmp[1][1] = sc.nextInt();
            //coordinateList.add(i, tmp);
        }

        // 最大重叠数
        int max = 1;
        // 当前重叠数
        int n = 1;
        // 遍历矩形
        for(int i = 0 ; i < coordinateList.size() - 1 ; i++) {
            // 当前矩形
            Integer[][] nc = coordinateList.get(i);
            for(int x = i + 1 ; x < coordinateList.size() ; x++) {
                Integer[][] tc = coordinateList.get(x);
                if(((tc[0][0] >= nc[0][0] && tc[0][0] <= nc[1][0] && ((tc[0][1] >= nc[0][1] && tc[0][1] <= nc[1][1]) || (tc[1][1] >= nc[0][1] && tc[1][1] <= nc[1][1])))
                        || (tc[1][0] >= nc[0][0] && tc[1][0] <= nc[1][0] && ((tc[0][1] >= nc[0][1] && tc[0][1] <= nc[1][1]) || (tc[1][1] >= nc[0][1] && tc[1][1] <= nc[1][1]))))
                        && (nc[1][1] != tc[0][1] && nc[0][1] != tc[1][1] && nc[0][0] != tc[1][0] && nc[1][0] != tc[0][0])) {
                    n++;
                }
            }
            max = max > n ? max : n;
            n = 1;
        }
        System.out.println(max > n ? max : n);
    }
}
