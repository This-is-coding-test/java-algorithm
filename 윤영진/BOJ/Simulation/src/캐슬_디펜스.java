import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 캐슬_디펜스 {
    // 캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임
    // 각 칸에 포함된 적의 수는 최대 하나
    // 격자판의 N번행의 바로 아래(N+1행)의 모든 칸에는 성
    // 성을 적에게서 지키기 위해 궁수 3명을 배치
    // 궁수는 성이 있는 칸에 배치할 수 있다. -> 하나의 칸에는 1명의 궁수만
    // 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공경한다.
    // 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적 -> 그러한 적이 여럿일 경우에는 가장 왼족에 있는 적
    // 공격 받은 적은 게임에서 제외 / 궁수의 공격이 끝나면, 적이 이동한다.
    // 적은 아래로 한 칸
    static int N, M, D;
    static int[][] map;
    static List<Integer> output = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 1);
        System.out.println(answer);

    }

    private static void comb(int depth, int start) {
        if (depth == 3) {
            simulate();
        } else {
            for (int i = start; i <= M; i++) {
                output.add(i);
                comb(depth + 1, i + 1);
                output.remove(output.size() - 1);
            }
        }
    }

    private static void simulate() {
        int[][] copyMap = new int[N + 1][M + 1];
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int step = 1; step <= N; step++) {
            boolean[][] visited = new boolean[N + 1][M + 1];

            for (int k = 0; k < 3; k++) {
                Integer p = output.get(k); // 현재 궁수 위치
                int minD = Integer.MAX_VALUE;
                int minR = Integer.MAX_VALUE;
                int minC = Integer.MAX_VALUE;

                for (int i = 1; i <= N; i++) { // 가장 가까운 위치 찾기
                    for (int j = 1; j <= M; j++) {
                        if (copyMap[i][j] == 1) {
                            if (minD >= distance(i, j, p, N + 1)) {
                                if (minD > distance(i, j, p, N + 1)) {
                                    minD = distance(i, j, p, N + 1);
                                    minR = i;
                                    minC = j;
                                } else { // 거리가 같은 경우
                                    if (minC > j) { // 왼쪽부터
                                        minR = i;
                                        minC = j;
                                    }
                                }
                            }
                        }
                    }
                }
                if (minD <= D) {
                    visited[minR][minC] = true;
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (visited[i][j]) {
                        copyMap[i][j] = 0;
                        res++;
                    }
                }
            }

            // 성 바로 위 0으로 변경
            for (int j = 1; j <= M; j++) {
                copyMap[N][j] = 0;
            }

            // 한 칸씩 내리기
            for (int i = N; i >= 1; i--) {
                for (int j = 1; j <= M; j++) {
                    copyMap[i][j] = copyMap[i - 1][j];
                }
            }

        }
        answer = Math.max(answer, res);

    }

    private static int distance(int r1, int c1, int c2, int r2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
