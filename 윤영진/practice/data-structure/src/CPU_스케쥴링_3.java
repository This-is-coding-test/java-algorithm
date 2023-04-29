import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class CPU_스케쥴링_3 {
    class Info {
        int idx, callTime, runTime;

        public Info(int idx, int callTime, int runTime) {
            this.idx = idx;
            this.callTime = callTime;
            this.runTime = runTime;
        }
    }

    public int[] solution(int[][] tasks) {

        int n = tasks.length;
        ArrayList<Info> infoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            infoList.add(new Info(i, tasks[i][0], tasks[i][1]));
        }
        infoList.sort((o1, o2) -> {
            if (o1.callTime == o2.callTime) return o1.runTime - o2.runTime;
            return o1.callTime - o2.callTime;
        });

        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        int fT = -1; // 3
        PriorityQueue<Info> pQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.runTime == o2.runTime) return o1.idx - o2.idx;
            return o1.runTime - o2.runTime;
        });

        while (true) {
            if (pQ.isEmpty() && fT < infoList.get(index).callTime) fT = infoList.get(index).callTime;

            while (index < n && fT >= infoList.get(index).callTime) {
                pQ.offer(infoList.get(index));
                index++;
            }

            Info info = pQ.poll();
            result.add(info.idx);
            fT += info.runTime;

            if (result.size() == n) break;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        CPU_스케쥴링 T = new CPU_스케쥴링();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}