package Test.auto;

import java.io.*;
import java.util.*;

public class AutoEver2 {
    // N개 수열이 주어지고 0번 인덱스에서 N - 1 인덱스로 이동하는 최소 거리
    // 1, 2, 3 중 하나를 정해서 가장 가까운 위치로 이동
    // 풀이 1. 그래프 + 최단거리
    // 풀이 2. 그리디 -> 현재 위치부터 오른쪽으로 가장 빠르게 발견할 수 있는 1, 2, 3을 고르고 그 중에서 가장 먼 위치를 선택
    // 매 순간 가장 가까운 1, 2, 3을 찾고 그 중 제일 먼 곳으로 이동하는 전략
    // i번째에서 가장 가까운 1, 2, 3을 찾기 위해 오른쪽을 모두 훑는 것은 안된다. -> N^2
    // 거꾸로 탐색 아이디어 적용
    // i번째 위치에서 가장 가까운 1, 2, 3을 찾고 i - 1 번째에서 가장 가까운 1, 2, 3을 찾을 때 기존 3개 + i번째를 고려하면 된다.

    // 6
    // 1 2 2 3 1 2
    // 1 2 2 2 ... 1 3
    // 1 2 2 2 ... 2 1
    // 1 1 2 3 1 2 3 ... 1 2 3
    static int N;
    static int[] arr;
    static int[][] next; // next[i][k] : i번째 원소에서 오른쪽으로 가장 가까운 k값의 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        next = new int[N][4];
        for (int i = 0; i < N; i++) {
            next[i][0] = -1;
            next[i][1] = -1;
            next[i][2] = -1;
            next[i][3] = -1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    private static void solution() {

        for (int i = N - 2; i >= 0; i--) {
            // 이전 정보 계승
            next[i][1] = next[i + 1][1];
            next[i][2] = next[i + 1][2];
            next[i][3] = next[i + 1][3];

            next[i][arr[i + 1]] = i + 1;

//            if (i + 1 < N) {
//            }
        }

        // Greedy 하게 이동
        int cur = 0;
        int cnt = 0;
        // O(N)
        while (cur != N - 1) {
            cur = getMax(cur); // 현재 위치(cur)에서 갈 수 있는 1, 2, 3위치들 중에서 가장 먼 곳
            cnt++;
        }
        System.out.println(cnt);
    }

    private static int getMax(int cur) {
        int tmp = Math.max(next[cur][1], next[cur][2]);
        return Math.max(tmp, next[cur][3]);
    }


}
