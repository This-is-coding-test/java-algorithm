import java.util.*;

class 송아지를_잡자 {
    // 송아지는 매초 1만큼 이동
    // 현수는 매초 앞으로 x + 1, x - 1, x * 2
    // 홀수 L에서 진행할 수 있는 지점은 다음 홀수L에서 반드시 나타난다.
    // 짝수 L에서 진행할 수 있는 지점은 다음 짝수L에서 반드시 나타난다.

    int answer;

    public int solution(int s, int e) {
        answer = 0;
        return bfs(s, e);
    }

    private int bfs(int s, int e) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        boolean[][] visited = new boolean[2][200001]; // 0 짝수L, 1 홀수L
        visited[0][s] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            time++;

            for (int i = 0; i < len; i++) {
                int curr = queue.poll();
                for(int nx : new int[]{curr + 1, curr - 1, curr * 2}) {
                    if (nx >= 0 && nx <= 200000 && !visited[time % 2][nx]) {
                        visited[time % 2][nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            e += time;
            if(e > 200000) return -1;
            if(visited[time % 2][e]) return time;
        }
        return -1;
    }

    public static void main(String[] args) {
        송아지를_잡자 T = new 송아지를_잡자();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}