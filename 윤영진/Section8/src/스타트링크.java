import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {


    static int F; // 스타트링크의 총 층수
    static int G; // 스타트링크가 있는 층
    static int S; // 강호 위치 층
    static int U; // 강호 위치 층
    static int D; // 강호 위치 층
    static int level = 0;

    // 버튼은 U(+x), D(-x)만 존재
    // 최소 버튼 클릭수 ?

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        queue.offer(S);
        visited[S] = true;
        BFS();
        if (visited[G]) {
            System.out.println(level);
        }else {
            System.out.println("use the stairs");
        }


    }

    private static void BFS() {

        while (!queue.isEmpty() && !visited[G]) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer now = queue.poll();
                // U
                if (now + U <= F && !visited[now + U]) {
                    visited[now + U] = true;
                    queue.offer(now + U);
                }

                // D
                if (now - D > 0 && !visited[now - D]) {
                    visited[now - D] = true;
                    queue.offer(now - D);
                }
            }
            level ++;

        }



    }


}
