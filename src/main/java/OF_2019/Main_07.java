package OF_2019;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。
 * 从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 *
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 *
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 *
 * 6 0
 */
public class Main_07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> timeList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int time = sc.nextInt() * 60 + sc.nextInt();
            timeList.add(time);
        }

        int inRoadTime = sc.nextInt();
        int needToschoolTime = sc.nextInt() * 60 + sc.nextInt();

        int lastTime = needToschoolTime - inRoadTime;

        timeList = timeList.stream().sorted().collect(Collectors.toList());

        for(int i = 0 ; i < timeList.size() ; i++) {
            if(timeList.get(i) > lastTime) {
                System.out.print(timeList.get(i - 1) / 60);
                System.out.print(" ");
                System.out.print(timeList.get(i - 1) % 60);
                return;
            }
        }
        System.out.print(timeList.get(timeList.size() - 1) / 60);
        System.out.print(" ");
        System.out.print(timeList.get(timeList.size() - 1) % 60);
    }
}
