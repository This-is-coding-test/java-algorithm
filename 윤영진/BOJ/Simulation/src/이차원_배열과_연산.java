import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이차원_배열과_연산 {

    // R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
    // C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.

    // 한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알야아 한다.

    static class Pair implements Comparable<Pair> {
        int number;
        int count;

        Pair(int n, int c) {
            this.number = n;
            this.count = c;
        }

        // count 가 작은 게 앞으로, 같으면 number 가 작은게 앞으로
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                return -1;
            }
        }
    }


    static int r, c, k;
    static int[][] A = new int[101][101]; // (x,y)
    static int xLength = 3; // 행
    static int yLength = 3; // 열


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time < 100) {
            if (A[r][c] == k) break;
            simulate();
            time++;
        }
        if (time == 100) {
            time = -1;
        }
        System.out.println(time);


    }

    private static void simulate() {

        if (xLength >= yLength) {
            R();
        } else {
            C();
        }
    }

    private static void C() {

        for (int idx = 1; idx <= yLength; idx++) {
            PriorityQueue<Pair> pQ = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 1; j <= xLength; j++) {
                if (A[j][idx] == 0) continue;
                map.put(A[j][idx], map.getOrDefault(A[j][idx], 0) + 1);
            }
            map.forEach((k, v) -> pQ.add(new Pair(k, v)));

            int i = 1;
            while (!pQ.isEmpty()) {
                Pair p = pQ.poll();
                A[i++][idx] = p.number;
                A[i++][idx] = p.count;
            }

            xLength = Math.max(i, xLength);
            while (i <= 99) {
                A[i++][idx] = 0;
                A[i++][idx] = 0;
            }
        }

    }

    private static void R() {

        for (int idx = 1; idx <= xLength; idx++) {
            PriorityQueue<Pair> pQ = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 1; j <= yLength; j++) {
                if (A[idx][j] == 0) continue;
                map.put(A[idx][j], map.getOrDefault(A[idx][j], 0) + 1);
            }
            map.forEach((k, v) -> pQ.add(new Pair(k, v)));

            int i = 1;
            while (!pQ.isEmpty()) {
                Pair p = pQ.poll();
                A[idx][i++] = p.number;
                A[idx][i++] = p.count;
            }

            yLength = Math.max(i, yLength);
            while (i <= 99) {
                A[idx][i++] = 0;
                A[idx][i++] = 0;
            }
        }
    }


}
