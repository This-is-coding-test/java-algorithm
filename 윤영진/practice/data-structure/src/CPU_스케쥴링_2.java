import java.util.*;

class CPU_스케쥴링_2 {
    // 실행시간이 가장 작은 작업을 먼저 처리하며, 실행시간이 같은 작업의 경우는 작업번호가 작은 것을 먼저 처리
    // ==> 우선순위 큐
    static class Info {
        int num; // 작업 번호
        int ct; // 호출 시간
        int rt; // 실행 시간

        public Info(int num, int ct, int rt) {
            this.num = num;
            this.ct = ct;
            this.rt = rt;
        }
    }


    public int[] solution(int[][] tasks) {
        LinkedList<Info> infoList = new LinkedList<>();

        int[] answer;
        int n = tasks.length;
        for (int i = 0; i < tasks.length; i++) {
            int ct = tasks[i][0];
            int rt = tasks[i][1];

            infoList.add(new Info(i, ct, rt));
        }
        Collections.sort(infoList, (o1, o2) -> o1.ct - o2.ct);

        PriorityQueue<Info> waitQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.rt == o2.rt) return o1.num - o2.num;
            return o1.rt - o2.rt;
        });
        int fT = 0; // 0 -> 1
        int idx = 0;
        answer = new int[n];
        while (!infoList.isEmpty() || !waitQ.isEmpty()) {
            if (waitQ.isEmpty()) fT = Math.max(fT, infoList.peek().ct);
            while (!infoList.isEmpty() && infoList.peek().ct <= fT) {
                Info info = infoList.poll();
                waitQ.add(info);
            }

            Info info = waitQ.poll();
            fT = fT + info.rt;
            answer[idx++] = info.num;
        }

        return answer;
    }

    public static void main(String[] args) {
        CPU_스케쥴링_2 T = new CPU_스케쥴링_2();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}