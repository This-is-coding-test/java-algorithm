package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 네가지_연산을_이용하여_1_만들기 {

    // 숫자 N이 주어졌을 때, 다음 4가지 연산을 적절히 사용하여 연산의 횟수를 최소화 하여 숫자 1
    // 1. 현재 숫자에서 1을 뺀다
    // 2. 현재 숫자에 1을 더한다.
    // 3. 현재 숫자가 2로 나누어 떨어질 경우, 현재 숫자를 2로 나눈다.
    // 4. 현재 숫자가 3으로 나누어 떨어질 경우, 현재 숫자를 3으로 나눈다.

    static final int MAX_NUM = 1000000;
    static final int MIN_NUM = 1;
    static int N;
    static boolean[] visited = new boolean[MAX_NUM + 1];
    static int[] step = new int[MAX_NUM + 1];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        step[N] = 0;
        visited[N] = true;
        queue.offer(N);

        bfs();
        System.out.println(step[1]);

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer now = queue.poll();
                int next;

                // +1
                next = now + 1;
                if (next <= MAX_NUM && !visited[next]) {
                    visited[next] = true;
                    step[next] = step[now] + 1;
                    queue.offer(next);
                }

                // -1
                next = now -  1;
                if (next >= MIN_NUM && !visited[next]) {
                    visited[next] = true;
                    step[next] = step[now] + 1;
                    queue.offer(next);
                }


                // /2
                next = now / 2;
                if (now % 2 == 0 && !visited[next]) {
                    visited[next] = true;
                    step[next] = step[now] + 1;
                    queue.offer(next);
                }


                // /3
                next = now / 3;
                if (now % 3 == 0 && !visited[next]) {
                    visited[next] = true;
                    step[next] = step[now] + 1;
                    queue.offer(next);
                }

                if(visited[1]) return;
            }


        }

    }
}
