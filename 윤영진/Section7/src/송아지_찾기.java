import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지_찾기 {

    static int S;
    static int E;
    static int[] check = new int[10001];
    static int[] moves = {1, -1, 5};
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        check[S] = 1;
        queue.offer(S);
        BFS();
    }

    private static void BFS() {

        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer temp = queue.poll();
                if (temp == E) {
                    System.out.println(L);
                    return;
                }

                for (int move : moves) {
                    int nx = temp + move;
                    if (nx > 0 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }

    }
}
