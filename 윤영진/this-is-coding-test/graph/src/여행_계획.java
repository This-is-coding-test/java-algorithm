import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행_계획 {
    static int N, M;
    static final int INF = 987654321;
//    static int[][] dist;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        dist = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                if (dist[i][j] == 0) dist[i][j] = INF;
            }
        }
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(dist[i], INF);
//            dist[i][i] = 0;
//        }

        for (int middle = 0; middle < N; middle++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    dist[start][end] = Math.min(dist[start][end], dist[start][middle] + dist[middle][end]);
                }
            }
        }


        st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (dist[now][next] != INF) {
                now = next;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }
}