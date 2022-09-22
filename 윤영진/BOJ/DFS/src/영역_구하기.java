import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역_구하기 {

    static int M;
    static int N;
    static int K;

    static int[][] arr;
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> sizes = new ArrayList<>();
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 0) {
                    size = 1;
                    arr[i][j] = 1;
                    DFS(i, j);
                    sizes.add(size);
                }
            }
        }

        System.out.println(sizes.size());
        Collections.sort(sizes);

        for (Integer size : sizes) {
            System.out.print(size + " ");
        }

    }

    private static void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[nx][ny] == 0) {
                arr[nx][ny] = 1;
                size++;
                DFS(nx, ny);
            }


        }

    }
}
