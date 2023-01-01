package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 구슬의_이동 {

    static class Marble {
        int idx;
        int x;
        int y;
        int d;
        int v;


        public Marble(int i, int x, int y, int d, int v) {
            this.idx = i;
            this.x = x;
            this.y = y;
            this.d = d;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Marble{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", v=" + v +
                    '}';
        }
    }

    static int n, m, t, k;
    static int[][] count;

    static List<Marble> marbles = new ArrayList<>();

    static int[] dx = {-1, 0, 0, 1}; // 상우좌하 -> 대칭 처리
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        count = new int[n][n];

        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int v = Integer.parseInt(st.nextToken());

            marbles.add(new Marble(i, r, c, dirMapper[d], v));
        }

        while (t-- > 0) {
            simulate();
        }

        System.out.println(marbles.size());

    }

    private static void simulate() {

        // Step1
        // 구슬을 전부 한 번씩 움직여 봅니다.
        moveAll();

        // Step2
        // 움직임 이후에 충돌이 일어나는 구슬들을 처리 -> 우선순위
        collide();
//        removeDuplicateMarbles();
    }

    private static void removeDuplicateMarbles() {

        ArrayList<Marble> tempVector = new ArrayList<>();

        // count 배열 clear
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = 0;
            }
        }

        for (int i = 0; i < marbles.size(); i++) {
            int x = marbles.get(i).x;
            int y = marbles.get(i).y;

            count[x][y]++;
        }

        for (int i = 0; i < marbles.size(); i++) {
            if (!exceedMarble(i)) {
                tempVector.add(marbles.get(i));

            } else {
                if (isAvailable(i)) {
                    tempVector.add(marbles.get(i));
                }
            }
        }

        marbles = tempVector;
    }

    private static boolean isAvailable(int idx) {

        PriorityQueue<Marble> pQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.v == o2.v) return o2.idx - o1.idx;
            return o2.v - o1.v;
        });
        Marble cM = marbles.get(idx);

        for (int j = 0; j < marbles.size(); j++) {
            Marble nM = marbles.get(j);
            if (cM.x == nM.x && cM.y == nM.y) {
                pQ.offer(nM);
            }
        }

        for (int i = 0; i < k; i++) {
            if (idx == pQ.poll().idx) return true;
        }

        return false;
    }

    private static boolean exceedMarble(int idx) {

        int targetX = marbles.get(idx).x;
        int targetY = marbles.get(idx).y;

        return count[targetX][targetY] > k;
    }

    private static void moveAll() {
        for (int i = 0; i < marbles.size(); i++) {
            Marble nP = move(marbles.get(i));
            marbles.set(i, nP);
        }
    }

    private static Marble move(Marble m) {

        int moveNum = m.v; // 3
        int x = m.x; // 1
        int y = m.y; // 0
        int dir = m.d; // 2

        for (int i = 0; i < moveNum; i++) { // 0,1,2
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                dir = 3 - dir;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;

        }
        return new Marble(m.idx, x, y, dir, m.v);
    }

    private static void collide(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                List<Marble> tmp = new ArrayList<>();
                for (Marble marble : marbles){
                    if (i == marble.y && j == marble.x){
                        tmp.add(marble);
                    }
                }
                if (tmp.size() > k) {
                    tmp.sort((o1, o2) -> {
                        if (o1.v == o2.v) {
                            return o2.idx - o1.idx;
                        }
                        return o2.v - o1.v;
                    });

                    while (tmp.size() > k){
                        marbles.remove(tmp.get(tmp.size()-1));
                        tmp.remove(tmp.get(tmp.size()-1));
                    }
                }


            }
        }
    }

}
