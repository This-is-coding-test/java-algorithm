package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_클린알파 {

    // H 클린알파의 성능 테스트
    // 1초 간격으로 바이러스들이 집 안으로 침입한다.
    // 집 안에서 바이러스는 1초당 P배씩 증가한다.

    // 매초 집 안에 침입하는 바이러스의 숫자가 주어질 때, N초 후에는 총 몇 마리의 바이러스를 잡아야 할까?
    // 증가율 P, 총 시간 N

    static int P, N;
    static int[] virus;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        P = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);

        virus = new int[N];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            virus[i] = Integer.parseInt(s[i]);
        }

        int total = virus[0]; // 1

        for (int i = 1; i < N; i++) {
            total = (total * P) % 1000000007; // 3
            total += virus[i];
        }

        System.out.println(total);



    }
}
