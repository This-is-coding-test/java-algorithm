package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 금고털이 {

    // 배낭은 W 까지 담을 수 있다.

    // 각 금속의 무게와 무게당 가격이 주어졌을 때 배낭을 채울 수 있는 가장 값비싼 가격

    static class Metal {
        int w;
        int p;

        public Metal(int w, int p) {
            this.w = w;
            this.p = p;
        }


    }

    static int W, N;
    static PriorityQueue<Metal> metals = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);

    // 70 2 ->
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            metals.offer(new Metal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int weight = 0;
        int sum = 0;

        while (weight != W && !metals.isEmpty()) {
            Metal m = metals.poll(); // 70 2
            if (m.w + weight <= W) {
                weight += m.w;
                sum += (m.w * m.p);
            }
            else if (m.w + weight > W) {
                if (m.w >= W - weight) {
                    sum += ((W - weight) * m.p);
                    weight += W - weight;

                } else {
                    weight += m.w;
                    sum += (m.w * m.p);
                }
            }
        }
        System.out.println(sum);

    }
}
