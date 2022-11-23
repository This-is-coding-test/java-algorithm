package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스마트_물류 {
    // 로봇들의 위치에서 거리가 K 이하인 부품만 잡을 수 있다.
    // 왼쪽, 오른쪽은 상관 없다.

    // 라인의 길이 N, 부품을 잡을 수 있는 거리 K
    // P 로봇, H 부품
    // 부품을 잡을 수 있는 로봇의 최대 수

    static List<Integer> robots = new ArrayList<>();
    static Queue<Integer> things = new LinkedList<>();
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String temp = br.readLine();

        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c == 'H') {
                things.offer(i);
            } else {
                robots.add(i);
            }
        }
        int answer = 0;

        for (Integer robot : robots) {

            while (!things.isEmpty()) {
                int i = things.peek();
                if (Math.abs(robot - i) <= K) {
                    answer++;
                    things.poll();
                    break;
                } else if (robot > i) things.poll();
                else break;
            }
        }
        System.out.println(answer);

    }
}
