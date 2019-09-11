package OF_2019;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 我们部门需要装饰墙，但是墙非常非常的长，有一千万米。我们会按顺序贴很多海报在上面，这些海报相互之间会重叠，请问下，最后还能看到哪些？（只看到一部分也算）
 *
 * 输入描述:
 * N表示N张海报
 * 接下来每一行代表海报的左右边界（上下默认全满），Li，Ri，均为整数，大于0，小于一千万。海报按输入顺序张贴。
 *
 * 输出描述:
 * 有多少张海报是可见的
 *
 * 5
 * 1 4
 * 2 6
 * 8 10
 * 3 4
 * 7 10
 *
 * 4
 */
public class Main_48 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<int[]>> posters = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            int[] poster = new int[]{sc.nextInt(), sc.nextInt()};

            for(int x = 0 ; x < posters.size() ; x++) {
                List<int[]> tmpList = posters.get(x);
                int[] tmpPoster = tmpList.get(0);
                int[] tmpCover = tmpList.get(1);
                if(tmpPoster[0] >= poster[1] || tmpPoster[1] <= poster[0]) {
                    continue;
                }
                if(poster[0] < tmpCover[0]) {
                    tmpCover[0] = poster[0];
                }

                if(poster[1] > tmpCover[1]) {
                    tmpCover[1] = poster[1];
                }
            }
            posters.add(new ArrayList<int[]>(){{
                add(poster);
                add(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            }});
        }

        int out = 0;

        for(List<int[]> is : posters) {
            int[] tmpPoster = is.get(0);
            int[] tmpCover = is.get(1);
            if(tmpPoster[0] < tmpCover[0] || tmpPoster[1] > tmpCover[1]) {
                out++;
            }
        }

        System.out.println(out);

    }
}
