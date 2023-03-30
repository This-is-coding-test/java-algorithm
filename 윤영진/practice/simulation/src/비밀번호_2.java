import java.util.Arrays;

class 비밀번호_2 {
    // 키패드의 숫자배치는 항상 변한다.
    // 소프트웨어는 비밀번호의 첫 숫자에서 시작하여 이웃한 8개의 방ㅎ으로 이동하면서 입력
    // 이웃한 숫자로 이동 시 1초

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public int solution(int[] keypad, String password) {
        int[][] keypads = new int[3][3];
        int[][] dist = new int[10][10]; // dist[i][j] : i -> j 이동 시간
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypads[i][j] = keypad[i * 3 + j];
            }
        }

        for (int i = 1; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 1; i < 10; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = keypads[i][j];

                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (inRange(nx, ny)) {
                        int to = keypads[nx][ny];
                        dist[from][to] = 1;
                    }
                }
            }
        }
        int answer = 0;
        // '0' => ASCII : 48
        for (int i = 0; i < password.length() - 1; i++) {
            int from = password.charAt(i) - 48;
            int to = password.charAt(i + 1) - 48;
            answer += dist[from][to];
        }
        return answer;
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 3 && ny < 3;
    }

    public static void main(String[] args) {
        비밀번호_2 T = new 비밀번호_2();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}