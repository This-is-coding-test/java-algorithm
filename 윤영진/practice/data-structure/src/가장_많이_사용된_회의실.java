import java.util.*;

class 가장_많이_사용된_회의실 {
    // 여러 개의 회의가 동시에 진행되는 행사
    // 0번부터 n-1번으로 번호가 매겨진 회의실 n개
    // 회의는 다음과 같은 방식으로 회의실 할당

    // 1. 사용 가능한 회의실이 생기면 시작 시간이 더 빠른 회의를 회의실에 배정
    // 2. 사용 가능한 회의실이 여러개일 경우 가장 번호가 낮은 회의실에 회의를 배정
    // 3. 사용 가능한 회의실이 없는 경우 다음 순서의 회의는 회의실이 비워질 때까지 기다렸다 자신의 회의 시간만큼 회의 진행
    // 가장 많은 회의를 개최한 회의실의 번호를 반환

    static class Info {
        int st;
        int et;

        public Info(int st, int et) {
            this.st = st;
            this.et = et;
        }
    }

    public int solution(int n, int[][] meetings) {
        int len = meetings.length;
        // 미팅룸
        TreeSet<Integer> rooms = new TreeSet<>(); // 현재 사용가능한 회의실 번호
        for (int i = 0; i < n; i++) {
            rooms.add(i);
        }
        List<Info> meetingList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int st = meetings[i][0];
            int et = meetings[i][1];
            meetingList.add(new Info(st, et));
        }
        Collections.sort(meetingList, (o1, o2) -> o1.st - o2.st);
        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        }); // {회의 끝나는 시간, 회의실 번호} -> 진행 중인 회의 큐
        int[] res = new int[n];
        for (int i = 0; i < len; i++) {
            while (!pQ.isEmpty() && pQ.peek()[0] <= meetingList.get(i).st) {
                rooms.add(pQ.poll()[1]);
            }
            if (!rooms.isEmpty()) { // 빈 방 존재
                Integer room = rooms.pollFirst();
                res[room]++;
                pQ.offer(new int[]{meetingList.get(i).et, room});
            } else { // 빈 방 없는 경우 -> 대기
                int[] p = pQ.poll();
                int end = p[0];
                int room = p[1];
                res[room]++;
                pQ.offer(new int[]{end + meetingList.get(i).et - meetingList.get(i).st, room});
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (res[i] > max) {
                max = res[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        가장_많이_사용된_회의실 T = new 가장_많이_사용된_회의실();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}