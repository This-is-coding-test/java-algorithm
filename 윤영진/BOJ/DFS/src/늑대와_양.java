import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 늑대와_양 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 크기과 RxC인 목장
    // 목장은 1x1 크기의 칸으로 나눠짐
    // 각가의 칸에는 비어있거나(.), 양(s), 늑대(w)
    // 양은 움직일 수 없고, 늑대는 인접(변을 공유하고 있는 상태)한 칸을 자유롭게 이동할 수 있다.
    // 목장에 울타리(D)를 설치해 늑대가 양이 있는 칸으로 갈 수 없게 할 것이다.
    // 늑대가 양이 있는 칸으로 갈 수 없다면 1을 출력하고 현재 상태 출력
    // 늑대가 양이 있는 칸으로 갈 수 있다면 0을 출력

    static int R;
    static int C;
    static char[][] boards;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        boards = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                boards[i][j] = str.charAt(j);

                if (boards[i][j] == 'W') {
                    queue.add(new Point(i, j));
                }
            }
        }

        BFS();
        if (flag) {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(boards[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println(0);
        }


    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (boards[nx][ny] == '.') {
                        boards[nx][ny] = 'D';
                    } else if(boards[nx][ny] == 'S') {
                        flag = false;
                        return;
                    }

                }
            }


        }



    }
}
