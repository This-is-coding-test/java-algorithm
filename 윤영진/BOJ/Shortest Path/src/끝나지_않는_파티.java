import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 끝나지_않는_파티 {

    static int N, M;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int middle = 1; middle <= N; middle++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    cost[start][end] = Math.min(cost[start][end], cost[start][middle] + cost[middle][end]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (cost[s][e] <= t) {
                sb.append("Enjoy other party").append("\n");
            } else {
                sb.append("Stay here").append("\n");
            }
        }

        System.out.println(sb);
    }

}