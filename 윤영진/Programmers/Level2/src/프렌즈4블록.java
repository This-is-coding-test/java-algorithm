import java.util.*;

class 프렌즈4블록 {
    class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] Board;
    int M, N;
    Queue<Point> bombQ = new LinkedList<>();
    int answer = 0;
    
    int[] dx = {0, 0, 1, 1};
    int[] dy = {0, 1, 0, 1};
    
    // R - 1, M - 2, A - 3, F - 4, N - 5, T - 6, C - 7
    
    public int solution(int m, int n, String[] board) {
        Board = new int[m][n];
        M = m;
        N = n;
        HashMap<Character, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map.containsKey(board[i].charAt(j))) continue;
                else map.put(board[i].charAt(j), idx++);
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Board[i][j] = map.get(board[i].charAt(j));
            }
        }
        
        while(true) {
            bombQ = new LinkedList<>();
            simulate();
            if (bombQ.isEmpty()) break;
            bomb();
            Board = down();
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(Board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    public int[][] down() {
        int[][] tmp = new int[M][N];
        
        for (int i = 0; i < N; i++) { // 열
            int idx = M - 1;
            for (int j = M - 1; j >= 0; j--) { // 행
                if (Board[j][i] != 0) {
                    tmp[idx][i] = Board[j][i];
                    idx--;
                }
            }
        }
        return tmp;
        
        
    }
    
    public void simulate() {
        
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if(Board[i][j] == 0) continue;
                if(isValid(i, j, Board[i][j])) bombQ.offer(new Point(i, j));
            }
        }
    }
    
    public boolean isValid(int x, int y, int type) {
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(Board[nx][ny] != type) return false;
        }
        return true;
    }
    
    public void bomb() {
        
        while(!bombQ.isEmpty()) {
            Point p = bombQ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                Board[nx][ny] = 0;
            }
        }
    }
    
}