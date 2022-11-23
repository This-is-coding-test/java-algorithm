package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 우물_안_개구리 {

    // 헬스장에서 N명의 회원이 운동을 하고 있다.
    // 각 회원은 1에서 N사이의 번호가 부여되고 있고, i번 회원이 들 수 있는 역기의 무게는 Wi

    // 회원들 사이에는 M개의 친분 관계 (Aj, Bj)가 있다.
    // i번 회원은 자신과 친분 관계가 있는 다른 회원보다 들 수 있는 역기의 무게가 무거우면 자신이 최고라고 생각
    // 누구와도 친분이 없는 멤버는 본인이 최고

    static int N, M;
    static int[] weights;
    static boolean[] best;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        weights = new int[N + 1];
        best = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (weights[A] < weights[B]) {
                best[A] = true;
            }
            else if (weights[A] > weights[B]) {
                best[B] = true;
            }else {
                best[A] = true;
                best[B] = true;
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!best[i]) result++;
        }

        System.out.println(result);


    }
}
