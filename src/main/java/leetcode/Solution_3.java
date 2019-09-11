package leetcode;

import leetcode.utils.Point;

import java.util.Arrays;

/**
 * 题目描述
 * 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class Solution_3 {

    public int maxPoints(Point[] points) {

        if(points == null || points.length == 0) {
            return 0;
        }

        points = Arrays.stream(points).sorted((p1, p2) -> {
            if(p1.x == p2.x) {
                return p1.y - p2.y;
            }
            return p1.x - p2.x;
        }).toArray(Point[] :: new);

        int max = 0;

        for(int i = 0 ; i < points.length ; i++) {
            int n = 1;

            double slope = 0;

            Point p1 = points[i];

            for(int x = i + 1 ; x < points.length ; x++) {

                Point p2 = points[x];

                if(p1.x == p2.x && p1.y == p2.y){
                    n++;
                    continue;
                }

                double slopeTmp;
                if(p1.y - p2.y == 0) {
                    slopeTmp = Double.MAX_VALUE;
                }else{
                    slopeTmp  = (double) Math.abs(p1.x - p2.x) / (double) Math.abs(p1.y - p2.y);
                }

                if(slope == 0) {
                    slope = slopeTmp;
                    n++;
                }else {
                    if(slope == slopeTmp) {
                        n++;
                    }
                }
                p1 = p2;

            }
            max = Math.max(max, n);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        Point[] points = {new Point(-4,1), new Point(-7,7), new Point(-1,5), new Point(9,-25)};
        int res = solution.maxPoints(points);
        System.out.println(res);
    }
}
