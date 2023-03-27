import java.util.*;

class 퍼즐_조각_채우기 {
    // 1. 조각은 한 번에 하나씩 채워 넣는다.
    // 2. 조각을 회전시킬 수 있다.
    // 3. 조각을 뒤집을 수는 없다.
    // 4. 게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 된다.

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    static int boardSize;
    static ArrayList<ArrayList<Point>> empty = new ArrayList<>(); // 게임 보드의 빈 공간 저장
    static ArrayList<ArrayList<Point>> block = new ArrayList<>(); // 테이블의 블록 저장
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상하
    static int[] dy = {0, -1, 0, 1}; // 좌우

    public int solution(int[][] game_board, int[][] table) {
        boardSize = game_board.length;
        visited = new boolean[boardSize][boardSize];

        // 게임 보드의 빈 공간 체크
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    empty.add(check(game_board, i, j, 0));
                }
            }
        }

        visited = new boolean[boardSize][boardSize];
        // 테이블의 블록 체크
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (table[i][j] == 1 && !visited[i][j])
                    block.add(check(table, i, j, 1));

            }
        }

        boolean[] visitedBoard = new boolean[empty.size()];
        int answer = 0;

        // 게임 보드의 빈 공간과 테이블의 블록만큼 반복하면서 빈 공간에 블록을 채움
        for (int i = 0; i < block.size(); i++) {
            ArrayList<Point> blockCheck = block.get(i);
            for (int j = 0; j < empty.size(); j++) {
                ArrayList<Point> emptyCheck = empty.get(j);

                if (emptyCheck.size() == blockCheck.size() && !visitedBoard[j]) {

                    // 빈 공간에 블록이 들어가는지 확인
                    if (isPossible(emptyCheck, blockCheck)) {
                        answer += blockCheck.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    // 게임 보드의 빈 공간과 테이블의 블록을 찾아내는 메소드
    // 탐색할 배열, 탐색할 인덱스, 게임보드와 테이블 구분하는 변수
    public static ArrayList<Point> check(int[][] board, int x, int y, int type) {
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> result = new ArrayList<>();

        q.add(new Point(x, y));
        visited[x][y] = true;

        // 빈 공간이나 블록의 첫 번째 좌표를 (0, 0)으로 함
        result.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (inRange(nx, ny)) {
                    if (!visited[nx][ny] && board[nx][ny] == type) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                        // 기준이 (0, 0)이기 때문에 (nx - x, ny - y)를 리스트에 넣음
                        result.add(new Point(nx - x, ny - y));
                    }
                }

            }
        }

        Collections.sort(result);

        return result;
    }

    // 블록을 회전시키면서 게임 보드에 들어가는지 확인하는 메소드
    public static boolean isPossible(ArrayList<Point> empty, ArrayList<Point> block) {

        // 90도씩 회전 시키기
        for (int i = 0; i < 4; i++) {
            int zeroX = block.get(0).x; // 0
            int zeroY = block.get(0).y; // 0

            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
            for (int j = 0; j < block.size(); j++) {

                block.get(j).x -= zeroX;
                block.get(j).y -= zeroY;

            }
            boolean isCollect = true;

            for (int j = 0; j < empty.size(); j++) {
                Point emptyPoint = empty.get(j);
                Point blockPoint = block.get(j);

                // 블록 좌표가 빈 공간의 좌표와 하나라도 다르면 중단
                if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
                    isCollect = false;
                    break;
                }
            }

            if (isCollect) {
                return true;
            } else {
                // 90도 회전 : (x, y) -> (y, -x)
                for (int j = 0; j < block.size(); j++) {
                    int temp = block.get(j).x;

                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -temp;
                }
                Collections.sort(block);
            }

        }
        return false;
    }


    public static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < boardSize && ny < boardSize;
    }
}