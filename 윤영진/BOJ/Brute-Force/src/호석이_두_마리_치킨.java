import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 호석이_두_마리_치킨 {
    // 도시 안에 2개의 매장
    // 도시는 N개의 건물과 M개의 도로
    // 건물은 1번부터 N번의 번호
    // 도로는 양방향

    // 도시에서 2개의 건물을 골라서 치킨집
    // 모든 건물에서의 접근성의 합을 최소화

    static int N, M;
    static int[][] map;
    static List<Integer> output = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int n1 = 0;
    static int n2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = 101;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }


        for (int middle = 1; middle <= N; middle++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    map[start][end] = Math.min(map[start][end], map[start][middle] + map[middle][end]);
                }
            }
        }

        combination(0, 1);
        System.out.println(n1 + " " + n2 + " " + result);

    }

    private static void combination(int depth, int start) {
        if (depth == 2) {
            int dist = calculate();
            if (result > dist) {
                result = dist;
                n1 = output.get(0);
                n2 = output.get(1);
            }
        } else {

            for (int i = start; i <= N; i++) {
                output.add(i);
                combination(depth + 1, i + 1);
                output.remove(output.size() - 1);
            }

        }


    }

    private static int calculate() {

        int n1 = output.get(0);
        int n2 = output.get(1);
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            int dist = Math.min(map[i][n1], map[i][n2]);
            dist *= 2;
            sum += dist;
        }
        return sum;
    }
}
