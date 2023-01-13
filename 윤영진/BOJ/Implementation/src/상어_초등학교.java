import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 상어_초등학교 {

    // NxN 크기의 격자
    // 학교에 다니는 학생의 수는 N^2명
    // 학생은 1번부터 N^2까지 번호
    // 선생님은 학생의 순서를 정했고, 각 학생이 좋아하는 학생 4명도 모두 조사했다.
    // 상하좌우만 인접

    // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int nearCount;
        int likeCount;

        public Point(int x, int y, int nearCount, int likeCount) {
            this.x = x;
            this.y = y;
            this.nearCount = nearCount;
            this.likeCount = likeCount;
        }

        @Override
        public int compareTo(Point o) {
            if (o.likeCount != this.likeCount) return o.likeCount - this.likeCount;
            else if (o.nearCount != this.nearCount) return o.nearCount - this.nearCount;
            else {
                if (o.x != this.x) return this.x - o.x;
                return this.y - o.y;
            }
        }
    }

    static int N;
    static int[][] map;
    static List<ArrayList<Integer>> likeList = new ArrayList<>(); // 좋아하는 학생을 담는 리스트
    static int[] order; // 학생을 앉히는 순서
    static PriorityQueue<Point> pQ = new PriorityQueue<>(); // 규칙에 따라서 최적의 칸을 선택
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        order = new int[N * N + 1];

        for (int i = 0; i <= N * N; i++) {
            likeList.add(new ArrayList<>());
        }

        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            for (int j = 1; j <= 4; j++) {
                int l = Integer.parseInt(st.nextToken());
                likeList.get(num).add(l);

            }
        }

        for (int i = 1; i <= N * N; i++) {
            simulate(order[i]);
            pQ.clear();
        }



        System.out.println(getSatisfaction());

    }

    private static int getSatisfaction() {
        int sum = 0;
        int likeCount;

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                likeCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (inRange(nx, ny) && isLikeStudent(map[x][y], nx, ny)) {
                        likeCount++;
                    }
                }

                if (likeCount != 0) {
                    sum += Math.pow(10, likeCount - 1);
                }

            }
        }

        return sum;
    }

    private static void simulate(int idx) {
        // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.

        int nx, ny;
        int nearCount, likeCount;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                nearCount = 0;
                likeCount = 0;
                if (map[x][y] != 0) continue;

                for (int k = 0; k < 4; k++) {
                    nx = x + dx[k];
                    ny = y + dy[k];
                    if (inRange(nx, ny)) {
                        if (map[nx][ny] == 0) {
                            nearCount++;
                        } else if (isLikeStudent(idx, nx, ny)) {
                            likeCount++;
                        }
                    }
                }
                pQ.offer(new Point(x, y, nearCount, likeCount));
            }
        }

        Point p = pQ.poll();
        map[p.x][p.y] = idx;
    }

    private static boolean isLikeStudent(int idx, int x, int y) {

        for (Integer num : likeList.get(idx)) {
            if (num == map[x][y]) return true;
        }
        return false;

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 1 && ny >= 1 && nx <= N && ny <= N;
    }
}