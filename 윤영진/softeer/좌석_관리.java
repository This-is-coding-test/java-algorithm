package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좌석_관리 {

    // 사람들이 사회적 거리두기를 잘 지키면서 식당 좌석에 앉도록 관리하는 일
    // 현재 식당에는 좌석 N x M개
    // 좌석 (1, 1) , (N, M)
    // 현재 K개의 좌석이 차 있고
    // 방역 수칙에 따르면 사람들은 상하좌우에 바로 붙어 앉을 수 없다.

    // 기항이는 현재 비어있는 좌석 (X,Y) 중에서 방역 수칙을 고려하는 동시에, 안전도가 가장 높은 좌석을 새로 들어오는 사람에게 배정
    // 배정해줄수 있는 좌석 중 안전도가 가장 높은 좌석이 여럿 있을 수 있다.
    // 이 때는 그 중에서 X가 가장 낮은 좌석을, X도 같다면 Y가 가장 낮은 좌석을 배정

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class People {
        Point point;
        boolean status;

        public People(boolean status) {
            this.status = status;
        }
    }

    static int N, M, Q;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static People[] people;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        people = new People[100001];

        for (int i = 0; i < 100001; i++) {
            people[i] = new People(false);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String inOut = st.nextToken();
            int id = Integer.parseInt(st.nextToken());

            if (inOut.equals("In")) {
                if (!people[id].status && people[id].point == null) { // 안먹음
                    if (assign(id)) {
                        System.out.println(id + " gets the seat (" + people[id].point.x + ", " + people[id].point.y + ").");
                    } else {
                        System.out.println("There are no more seats.");
                    }

                } else if (!people[id].status && people[id].point != null) { // 먹고 떠남
                    System.out.println(id + " already ate lunch");
                } else { // 먹고있음
                    System.out.println(id + " already seated.");
                }

            } else { // out
                if (!people[id].status && people[id].point == null) { // 안먹음
                    System.out.println(id + " didn't eat lunch.");
                } else if (!people[id].status && people[id].point != null) { // 먹고 떠남
                    System.out.println(id + " already left seat.");

                } else { // 먹고있음 -> 떠나야함
                    System.out.println(id + " leaves from the seat (" + people[id].point.x + ", " + people[id].point.y + ").");
                    map[people[id].point.x][people[id].point.y] = 0;
                    people[id].status = false;
                }
            }

        }


    }

    private static boolean assign(int id) {

        int maxD = Integer.MIN_VALUE;
        People cur = people[id];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {  // 1, 1

                if (map[i][j] == 0) {
                    boolean flag = true;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 1 && ny >= 1 && nx <= N && ny <= M && map[nx][ny] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        int d = nearest(i, j); // d = MAX
                        if (maxD < d) {
                            maxD = d;
                            cur.status = true;
                            cur.point = new Point(i, j);
                        }

                    }

                }

            }
        }

        if (maxD == Integer.MIN_VALUE) return false;
        else {
            map[cur.point.x][cur.point.y] = 1;
            return true;
        }


    }

    private static int nearest(int x, int y) {
        int minD = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    int d = (x - i) * (x - i) + (y - j) * (y - j);
                    minD = Math.min(d, minD);
                }
            }
        }
        return minD;
    }
}
