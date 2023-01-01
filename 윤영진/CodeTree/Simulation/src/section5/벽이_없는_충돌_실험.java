package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 벽이_없는_충돌_실험 {

    static class Marble {
        int idx;
        int x;
        int y;
        int w;
        int dir;

        public Marble(int idx, int x, int y, int w, int dir) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.w = w;
            this.dir = dir;
        }
    }

    static int t, n;

    public static int[][] nextMarbleIndex = new int[4001][4001];

    public static int[] dx = new int[]{1, 0, 0, -1};
    public static int[] dy = new int[]{0, 1, -1, 0};


    public static ArrayList<Marble> marbles = new ArrayList<>();
    public static ArrayList<Marble> nextMarbles = new ArrayList<>();

    public static int currTime;
    public static int lastCollisionTime;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        int[] dirMapper = new int[128];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;

        for (int i = 0; i <= 4000; i++)
            for (int j = 0; j <= 4000; j++)
                nextMarbleIndex[i][j] = -1;


        while (t-- > 0) {
            lastCollisionTime = -1;
            marbles = new ArrayList<>();

            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int w = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                // 양수로 만들기
                x += 2000;
                y += 2000;
                marbles.add(new Marble(i + 1, x, y, w, dirMapper[d]));

            }

            for (int i = 1; i <= 4000; i++) {
                currTime = i;
                simulate();
            }

            System.out.println(lastCollisionTime);

        }
    }

    // 모든 구슬들을 한 칸씩 움직이는 시뮬레이션을 진행합니다.
    private static void simulate() {

        for (int i = 0; i < marbles.size(); i++) {
            // 움직인 이후의 위치
            Marble nextMarble = move(marbles.get(i));

            // 구슬의 목록에 반영
            pushNextMarble(nextMarble);


        }

        marbles = (ArrayList<Marble>) nextMarbles.clone();

        for (int i = 0; i < nextMarbles.size(); i++) {
            int x = nextMarbles.get(i).x;
            int y = nextMarbles.get(i).y;
            nextMarbleIndex[x][y] = -1;
        }
        nextMarbles = new ArrayList<>();

    }

    private static void pushNextMarble(Marble nextMarble) {

        if (nextMarble.x < 0 || nextMarble.y < 0 || nextMarble.x > 4000 || nextMarble.y > 4000) {
            return;
        }

        int idx = findDuplicateMarble(nextMarble);

        if (idx == -1) { // 해당 위치에 아직 구슬 X
            nextMarbles.add(nextMarble);

            nextMarbleIndex[nextMarble.x][nextMarble.y] = nextMarble.idx;
        } else { // 구슬이 이미 존재 -> Collide
            Marble newMarble = collide(nextMarbles.get(idx), nextMarble); // (기존 marble, 새로운 marble)
            nextMarbles.set(idx, newMarble);
            lastCollisionTime = currTime;

        }


    }

    private static Marble collide(Marble marble1, Marble marble2) {

        // 우선순위
        // 1. 무게가 더 큰 구슬
        // 2. 번호가 더 큰 구슬
        if (marble1.w == marble2.w) {
            if (marble1.idx > marble2.idx) return marble1;
            else return marble2;
        } else {
            if (marble1.w > marble2.w) return marble1;
            else return marble2;
        }

    }

    private static int findDuplicateMarble(Marble marble) {
        return nextMarbleIndex[marble.x][marble.y];
    }

    private static Marble move(Marble marble) {

        int nx = marble.x + dx[marble.dir];
        int ny = marble.y + dy[marble.dir];

        return new Marble(marble.idx, nx, ny, marble.w, marble.dir);
    }
}
