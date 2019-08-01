package A_1001;

import java.util.*;

public class Main_1001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLines = scanner.nextLine().split(" ");
        String[] secondLines = scanner.nextLine().split(" ");

        // 最大自行车数量
        int maxBike = Integer.valueOf(firstLines[0]);
        // 站点个数
        int stationNumber = Integer.valueOf(firstLines[1]);
        // 有问题的站点序号
        int problemStation = Integer.valueOf(firstLines[2]);
        // 道路条数
        int roadNumber = Integer.valueOf(firstLines[3]);
        // 站点自行车数量
        Integer[] stationBikes = new Integer[stationNumber];
            for(int i = 0 ; i < stationNumber ; i++) {
            stationBikes[i] = Integer.parseInt(secondLines[i]);
        }
        // 问题站点自行车数量
        Integer problemStationBike = stationBikes[problemStation - 1];
        // 站点符合要求的自行车数
        Integer perfect = maxBike / 2;
        // 需要调往问题站点的自行车数
        Integer needSendBike = perfect - problemStationBike;
        // 站点map <站点序号, [连接站点序号, 路程]>
        Map<Integer, List<Integer[]>> stationMap = new HashMap<Integer, List<Integer[]>>();

            for(int i = 0 ; i < roadNumber ; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            Integer station1 = Integer.parseInt(tmp[0]);
            Integer station2 = Integer.parseInt(tmp[1]);
            Integer road = Integer.parseInt(tmp[2]);

            Integer[] s1 = {station2, road};
            Integer[] s2 = {station1, road};

            List<Integer[]> nextStations1 = stationMap.get(station1);
            List<Integer[]> nextStations2 = stationMap.get(station2);
            if(nextStations1 == null) {
                nextStations1 = new ArrayList<Integer[]>();
            }
            if(nextStations2 == null) {
                nextStations2 = new ArrayList<Integer[]>();
            }
            nextStations1.add(s1);
            nextStations2.add(s2);

            stationMap.put(station1, nextStations1);
            stationMap.put(station2, nextStations2);
        }

        List<Integer[]> fl = stationMap.get(problemStation);
            for(Integer[] l : fl) {
            statistics(problemStation, l, 0, 0);
        }
    }

    static List<Integer> roadList = new ArrayList<Integer>();
    public static void statistics(Integer f, Integer[] l, Integer r, Integer b) {
//        if(b >= needSendBike) {
//            return;
//        }
        if(l[0] == 0){
            b += l[1];
        }
    }

}
