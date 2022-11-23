package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조립라인 {

    // 동일한 자동차를 생산하는 2개의 조립 라인 A와 B가 있다.
    // 두 조립라인에는 각각 N개의 작업장이 있다.
    // 각각의 작업장을 Ai, Bi로 표시하자.

    // Ai 작업장과 Bi 작업장은 동일한 작업을 수행하지만 작업시간은 다를 수 있다.

    // A 조립 라인의 경우 A1 작업장에서 최초 조립이 시작되고, Ai 작업장에서 작업이 종료되면 바로 Ai+1 작업장에서 작업을 시작
    // B 조립 라인도 동일한 방식

    // Ai 작업장에서 Bi+1 작업장으로 혹은 Bi 작업장에서 Ai+1 작업장으로 반조립 제품의 이동이 가능 -> 이동시간이 추가

    static int N; // 작업장 개수
    static int[][] finish; // dp
    static int[][] switching;
    static int[][] work;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        finish = new int[2][N];
        switching = new int[2][N];
        work = new int[2][N];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine()); // 1 3
            int a = Integer.parseInt(st.nextToken()); // ai
            int b = Integer.parseInt(st.nextToken()); // bi
            int sA = Integer.parseInt(st.nextToken()); // switch a->b
            int sB = Integer.parseInt(st.nextToken()); // switch b->a

            work[0][i] = a;
            work[1][i] = b;

            switching[0][i] = sA;
            switching[1][i] = sB;
        }

        st = new StringTokenizer(br.readLine()); //
        work[0][N - 1] = Integer.parseInt(st.nextToken());
        work[1][N - 1] = Integer.parseInt(st.nextToken());

        finish[0][0] = work[0][0];
        finish[1][0] = work[1][0];

        for (int i = 1; i < N; i++) {
            finish[0][i] = Math.min(finish[0][i - 1], finish[1][i - 1] + switching[1][i - 1]) + work[0][i];
            finish[1][i] = Math.min(finish[1][i - 1], finish[0][i - 1] + switching[0][i - 1]) + work[1][i];
        }

        System.out.println(Math.min(finish[0][N - 1], finish[1][N - 1]));

    }
}
