class 비밀번호_1 {
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

    static int[][] Keypad;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public int solution(int[] keypad, String password) {
        Keypad = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Keypad[i][j] = keypad[i * 3 + j];
            }
        }

        Point currP = getPoint(Integer.parseInt(String.valueOf(password.charAt(0))));

        int answer = 0;
        for (int i = 1; i < password.length(); i++) {
            int num = Integer.parseInt(String.valueOf(password.charAt(i)));
            boolean flag = true;
            if (Keypad[currP.x][currP.y] == num) continue;
            for (int d = 0; d < 8; d++) {
                int nx = currP.x + dx[d];
                int ny = currP.y + dy[d];

                if (!inRange(nx, ny)) continue;
                if (Keypad[nx][ny] == num) {
                    currP.x = nx;
                    currP.y = ny;
                    answer += 1;
                    flag = false;
                }
            }
            if (flag) {
                currP = getPoint(num);
                answer += 2;
            }
        }


        return answer;
    }

    private boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < 3 && ny < 3;
    }

    private Point getPoint(int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (num == Keypad[i][j]) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        비밀번호_1 T = new 비밀번호_1();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}