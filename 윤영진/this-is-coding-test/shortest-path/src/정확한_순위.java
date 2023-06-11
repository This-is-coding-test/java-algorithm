import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class 정확한_순위 {
    // 시험을 본 학생 N명의 성적을 분실 -> 성적을 비교한 결과의 일부만 가지고 있다.
    static final int INF = 987654321;
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            dist[a][b] = 1;
        }

        for (int middle = 0; middle < N; middle++) {
            // start -> end
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    dist[start][end] = Math.min(dist[start][end], dist[start][middle] + dist[middle][end]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (dist[i][j] != INF || dist[j][i] != INF) cnt++;
            }
            if (cnt == N) answer++;

        }
        System.out.println(answer);

    }
}
