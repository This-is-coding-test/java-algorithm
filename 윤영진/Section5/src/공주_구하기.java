import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }
        int cnt = 0;
        while (queue.size() != 1) {
            cnt++;

            if (cnt == K) {
                queue.poll();
                cnt = 0;
            }else {
                queue.add(queue.poll());
            }
        }
        System.out.println(queue.poll());



    }
}
