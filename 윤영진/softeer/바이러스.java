package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

    static long K, P, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        System.out.println(K * Math.pow(P, N) % 1000000007 );


    }
}
