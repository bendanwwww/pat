package OF_2019;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
 * 现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
 * 小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
 * 注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
 * 现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
 *
 * 输入描述:
 * 第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
 * 第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。
 *
 * 输出描述:
 * 第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
 * 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
 *
 * 3 2
 * 5 8 5
 *
 * 0 2
 * 2 1
 * 2 3
 */
public class Main_14 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int towerNumber = sc.nextInt();
        int operateNumber = sc.nextInt();

        List<int[]> towers = new ArrayList<>();

        for(int i = 0 ; i < towerNumber ; i++) {
            towers.add(new int[] {i, sc.nextInt()});
        }

        towers = towers.stream().sorted((i1, i2) -> i2[1] - i1[1]).collect(Collectors.toList());


        if(towers.size() == 2) {
            int operate = (towers.get(0)[1] - towers.get(1)[1]) / 2;
            int differ = (towers.get(0)[1] - towers.get(1)[1]) % 2;

            int numberTmp = 0;
            if(operate <= operateNumber) {
                System.out.println(differ + " " + operate);
                numberTmp = operate;
            }else{
                System.out.println((towers.get(0)[1] - towers.get(1)[1] - 2 * operateNumber) + " " + operateNumber);
                numberTmp = operateNumber;
            }

            for(int i = 0 ; i < numberTmp ; i++) {
                System.out.println(towers.get(0)[0] + " " + towers.get(1)[1]);
            }
            return;
        }

        List<String> resList = new ArrayList<>();

        for(int i = 0 ; i < operateNumber ; i++) {
            int[] first = towers.get(0);
            int[] end = towers.get(towers.size() - 1);

            first[1] = first[1] - 1;
            end[1] = end[1] + 1;

            if(towers.get(towers.size() - 2)[1] < end[1]) {
                towers.set(towers.size() - 1, towers.get(towers.size() - 2));
                towers.set(towers.size() - 2, end);
            }

            if(towers.get(1)[1] > first[1]) {
                towers.set(0, towers.get(1));
                towers.set(1, first);
            }

            resList.add(first[0] + " " + end[0]);


            if(first[1] == end[1]) {
                System.out.println("0 " + (i + 1));
                for(String rs : resList) {
                    System.out.println(rs);
                }
                return;
            }
        }

        System.out.println((towers.get(0)[1] - towers.get(towers.size() - 1)[1]) + " " + operateNumber);
        for(String rs : resList) {
            System.out.println(rs);
        }
    }
}
