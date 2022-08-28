import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 피자_배달_거리 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static Point[] output;
    static int[][] board;
    static List<Point> hs = new ArrayList<>();
    static List<Point> pz = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    hs.add(new Point(i, j));
                }
                if (board[i][j] == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }

        output = new Point[M];
        comb(0,0);

        System.out.println(result);

    }

    private static void comb(int start, int L) {

        if (L == M) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (Point pz : output) {
                    // 집 기준으로 가장 가까운 피자집 택
                    int temp = Math.abs(pz.x - h.x) + Math.abs(pz.y - h.y);
                    dis = Math.min(temp, dis);
                }
                sum += dis;
            }
            result = Math.min(sum, result);
        } else {
            for (int i = start; i < pz.size(); i++) {
                output[L] = pz.get(i);
                comb(i + 1, L + 1);
            }

        }

    }
}
