import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2 {

    // 수빈 -> N위치, 동생 -> K 위치
    // 수빈(X)은 걷기(X-1, X+1) or 순간이동(2*X)

    // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간(1)과 가장 빠른 시간으로 찾는 방법이 몇 가지?
    static int N;
    static int K;
    static int count = 0;
    static int time = 0;
    static boolean[] visited = new boolean[100001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        queue.add(N);
        visited[N] = true;

        BFS();
        System.out.println(time);
        System.out.println(count);

    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            // 만나 경우가 1번이라도 있으면 다음 계산부터는 최소가 아님
            if(count != 0) {
                return;
            }

            // 현재 q의 사이즈 만큼만 돌리기 - 시간 계산을 위해서
            for(int j = 0, size = queue.size(); j < size; j++) {
                int now = queue.poll();
                // 현재 방문 처리 - 현재를 방문한 시점 이후로 나오는 모든 방문은 중복처리
                visited[now] = true;
                int next;

                // 다음에서 만나는 경우 count + 1
                // 다음에서 못 만나는 경우 큐에 추가
                next = now - 1;
                if(next == K) {
                    count++;
                } else if(next >= 0 && !visited[next]) {
                    queue.offer(next);
                }

                next = now + 1;
                if(next == K) {
                    count++;
                } else if(next < 100001 && !visited[next]) {
                    queue.offer(next);
                }

                next = now * 2;
                if(next == K) {
                    count++;
                } else if(next < 100001 && !visited[next]) {
                    queue.offer(next);
                }
            }
            time++;
        }

    }
}
