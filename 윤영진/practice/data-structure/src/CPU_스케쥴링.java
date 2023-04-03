import java.util.*;

class CPU_스케쥴링 {
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
        List<Info> infoList = new ArrayList<>();

        int[] answer;
        int n = tasks.length;
        for (int i = 0; i < tasks.length; i++) {
            int ct = tasks[i][0];
            int rt = tasks[i][1];

            infoList.add(new Info(i, ct, rt));
        }
        Collections.sort(infoList, (o1, o2) -> o1.ct - o2.ct);

        List<Integer> results = new ArrayList<>();
        PriorityQueue<Info> waitQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.rt == o2.rt) return o1.num - o2.num;
            return o1.rt - o2.rt;
        });
        waitQ.offer(infoList.get(0));
        int fT = infoList.get(0).ct;
        int idx = 1;

        for (int t = fT; ; t++) {

            // 작업 도착
            while (idx < n && t == infoList.get(idx).ct) {
                if (waitQ.isEmpty() && t > fT) fT = t; // 현재 시간이 작업 끝나는 시간보다 큰 경우 -> 바로 작업 시작
                waitQ.offer(infoList.get(idx));
                idx++;
            }

            if (t == fT && !waitQ.isEmpty()) { // 작업 끝나는 시간이 된 경우
                Info info = waitQ.poll();
                fT += info.rt; // 작업 끝나는 시간 업데이트
                results.add(info.num);
            }
            if (results.size() == n) break;

        }
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = results.get(i);
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