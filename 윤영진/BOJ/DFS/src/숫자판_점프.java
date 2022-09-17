import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판_점프 {

    static int[][] boards = new int[5][5];
    static int[] outputs = new int[6];
    static Set<String> set = new HashSet<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                outputs[0] = boards[i][j];
                DFS(1, i, j);
            }
        }

        System.out.println(set.size());

    }

    private static void DFS(int depth, int x, int y) {

        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(outputs[i]);
            }
            set.add(sb.toString());
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    outputs[depth] = boards[nx][ny];
                    DFS(depth + 1, nx, ny);
                }

            }
        }


    }
}
