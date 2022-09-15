import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {

    // 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실
    // 스타트링크는 G층에 위치
    // 강호는 S층에 위치
    // 강호는 엘레베이터를 타고 G층으로 이동 -> 목적지 G층
    // U버튼은 위로 U층
    // D버튼은 아래로 D층층

    // S층에 위치한 강호는 G층에 도착하기 위해서 눌러야할 최소한의 버튼 클릭수
    // S -> G //

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited;
    static int[] count;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 10
        S = Integer.parseInt(st.nextToken()); // 1
        G = Integer.parseInt(st.nextToken()); // 10
        U = Integer.parseInt(st.nextToken()); // 2
        D = Integer.parseInt(st.nextToken()); // 1

        if (S == G) {
            System.out.println(0);
            return;
        }

        visited = new boolean[F + 1];
        visited[S] = true;
        count = new int[F + 1];

        queue.add(S);

        BFS();

        // 1층에서 10층으로 7777
        // U(3) -> D(2) -> U(4) -> U(6) -> U(8) -> U(10)
        // 6


    }

    private static void BFS() {

        while (!queue.isEmpty() && !visited[G]) {
            Integer now = queue.poll();

            if (now + U <= F && !visited[now + U]) {
                visited[now + U] = true;
                queue.add(now + U);
                count[now + U] = count[now] + 1;
            }

            if (now - D > 0 && !visited[now - D]) {
                visited[now - D] = true;
                queue.add(now - D);
                count[now - D] = count[now] + 1;

            }

        }
        if (count[G] == 0) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(count[G]);
    }
}
