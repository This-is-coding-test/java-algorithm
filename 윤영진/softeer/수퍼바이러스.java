package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수퍼바이러스 {
    // 수퍼바이러스가 숙주의 몸속에서 0.1초당 P배씩 증가한다.
    // 처음에 softeer.수퍼바이러스 K마리가 있었다면 N초 후에는 총 몇 마리의 수퍼바이러스로 불어날까?

    static int K, P, N;
    // K: 바이러스 개수, P: 증가율, N: 총 시간(초)
    // 1초후에 2배 증가율 -> 0.1초 -> 1 * 2^10

    // 1 2 4
    // 4초 후에 2배의 증가율
    // 0.1초 2배 -> 1초: 2^10 -> 4초: 4 * 2^10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        System.out.println(K * calculate(N * 10L, P)  %  1000000007);


    }

    static public long calculate(long n, long p) {
        if (n == 1) return p;
        long ret = calculate(n / 2, p);
        if (n % 2 == 1) {
            return ret * ret * p % 1000000007;
        }else {
            return ret * ret % 1000000007;
        }
    }
}
