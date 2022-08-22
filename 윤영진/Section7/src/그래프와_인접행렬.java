import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그래프와_인접행렬 {

    // 무방향 그래프
    static int[][] graph1 = new int[10001][10001];

    // 방향그래프
    static int[][] graph2 = new int[10001][10001];

    // 가중치 방향그래프
    static int[][] graph3 = new int[10001][10001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 입력
        // 5
        // 1 2
        // 1 3
        // 2 4
        // 3 4
        // 2 5

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            graph1[x][y] = 1; // graph[1][2] = 1
            graph1[y][x] = 1; // graph[2][1] = 1
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (graph1[i][j] == 1) {
                    System.out.print(j + " connect ");
                }
            }
            System.out.println();
        }

        // 입력
        // 5
        // 1 2
        // 1 3
        // 3 4
        // 4 2
        // 2 5

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            graph2[x][y] = 1; // graph[1][2] = 1
        }

        // i번 노드에서 j번 노드로 이동
        for (int i = 1; i < 6; i++) {
            System.out.print(i + " -> ");
            for (int j = 1; j < 6; j++) {
                if (graph2[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        // 입력
        // 5
        // 1 2 2
        // 1 3 4
        // 4 2 2
        // 2 5 5
        // 3 4 5

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            int w = Integer.parseInt(st.nextToken()); // 2
            graph3[x][y] = w; // graph[1][2] = 2
        }


    }
}
