import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AtoB {

    // 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같이 두 가지이다.
    // 2를 곱한다.
    // 1을 수의 가장 오른쪽에 추가한다.

    // A를 B로 바꾸는데 필요한 연산의 최솟값 -> BFS

    static Queue<Long> queue = new LinkedList<>();
    static List<Boolean> visited = new ArrayList<>();

    static long A, B;
    static int level = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        if (A == B) {
            System.out.println(0);
            return;
        }

        queue.offer(A);
        System.out.println(BFS());


    }

    private static int BFS() {

        while (!queue.isEmpty()) {

            int len = queue.size(); // 1 -> 2 -> 3 -> 4 ->

            for (int i = 0; i < len; i++) {
                Long cur = queue.poll();
                if (cur == B) {
                    return level;
                }
                long next;

                // 2 곱하기
                next = cur * 2;
                if (next <= B) {
                    queue.offer(next);
                }

                // 1 오른쪽에 추가하기
                next = cur * 10 + 1;
                if (next <= B) {
                    queue.offer(next);
                }
            }
            level++; // 1 -> 2
        }
        return -1;
    }
}
