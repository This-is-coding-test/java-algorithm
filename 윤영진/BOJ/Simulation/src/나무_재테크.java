import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나무_재테크 {
    // 부동산 투자로 억대의 돈을 번 상도는 최근 NxN 크기의 땅을 구매
    // r은 행, c는 열
    // S2D2는 모든 칸을 조사
    // 가장 처음에 양분은 모든 칸에 5만큼

    // 나무 재테크란 작은 묘목을 구매해 어느정도 키운 후 팔아서 수익을 얻는 재테크
    // M개의 나무를 구매해 땅에 심었다.
    // 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가
    // 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
    // 만약, 땅에 양분이 부족해 자신이 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
    // 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가 -> 소수점 아래는 버린다.
    // 가을에는 나무가 번식 번식하는 나무는 나이가 5의 배수 -> 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
    // 겨울에는 S2D2가 땅을 돌아다니며 땅에 양분을 추가한다. -> A[r][C]
    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        // 나이 오름차순으로 정렬
        @Override
        public int compareTo(Tree t) {
            return this.age - t.age;
        }
    }

    static int N, M, K;
    static int[][] A; // S2D2
    static int[][] energies; // 양분
    static ArrayList<Tree> trees = new ArrayList<>();
    static ArrayList<Tree> liveTrees;
    static ArrayList<Tree> deadTrees;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        energies = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                energies[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }

        while (K-- > 0) {
            liveTrees = new ArrayList<>();
            deadTrees = new ArrayList<>();
            simulate();
        }


        System.out.println(trees.size());

    }

    private static void simulate() {
        Collections.sort(trees);
        // 봄 -> 나무가 자신의 나이만큼 양분을 먹고, 나이가 1증가
        spring();
        // 여름 -> 봄에 죽은 나무가 양분으로 변한다.
        summer();
        // 가을 -> 나무가 번식 -> 번식하는 나무는 나이가 5의 배수
        fall();
        // 겨울 -> S2D2가 땅을 양분 추가
        winter();

    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                energies[i][j] += A[i][j];
            }
        }
    }

    private static void fall() {

        for (int i = 0; i < trees.size(); i++) {
            Tree t = trees.get(i);
            if (t.age % 5 == 0) {
                breed(t.x, t.y);
            }
        }

    }

    private static void breed(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny)) {
                trees.add(new Tree(nx, ny, 1));
            }
        }

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }

    private static void summer() {
        for (Tree deadTree : deadTrees) {
            energies[deadTree.x][deadTree.y] += deadTree.age / 2;
        }
    }

    private static void spring() {

        for (int i = 0; i < trees.size(); i++) {
            Tree t = trees.get(i);
            if (t.age <= energies[t.x][t.y]) {
                energies[t.x][t.y] -= t.age;
                t.age += 1;
                liveTrees.add(t);
            } else {
                deadTrees.add(t);
            }
        }

        trees.clear();
        trees.addAll(liveTrees);
    }
}
