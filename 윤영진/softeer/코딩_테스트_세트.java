package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 코딩_테스트_세트 {

    // 관리를 위해 문제의 난이도를 1레벨에서 총 N개의 레벨로 구분
    // 문제 중에 난이도가 정확히 i레벨로 평가된 문제는 총 ci개가 있고,
    // 난이도를 정확히 매기기 애매하다는 평가를 받아 난이도를 i레벨 또는 i+1 레벨로 매길 수 있다고 평가된 문제는 총 di개

    // 현대자동차그룹 채용 시험을 위해 코딩 테스트 세트를 만드는 작업
    // 하나의 코딩 테스트 세트는 1에서 N사이의 모든 난이도를 가지는 문제 N개를 모은 것

    // 난이도가 애매한 문제들은 현호가 임의로 가능한 난이도를 적절히 매겨 넣을 때,
    // 서로 같은 문제를 포함하지 않는 코딩 테스트 세트는 최대 몇 개?

    static int N, T; // N: 난이도의 개수, T: 시나리오의 개수
    // 1레벨에서 3레벨
    // 문제 개수를 나타내는 5개의 정수 -> c1=2, d1=2, c2=1, d2=1, c3 = 3
    // map [1, 1-2, 2, 2-3, 3]
    // map [2   2   1   1   3]
    //      1       0       2
    //      0   1           1
    //          0       0   0
    // test1: 1 -> 2 -> 3
    // test2: 1 -> 1-2 -> 3
    // test3: 1-2 -> 2-3 -> 3

    // 1레벨로 확실히 평가된 문제 2개
    // 1, 2 레벨 평가된 문제 2개
    // 2레벨로 확실히 평가된 문제 1개
    // 2레벨, 3레벨로 평가된 문제 1개
    // 3레벨로 확실히 평가된 문제 3개

    // 1레벨로 확실히 평가된 문제 39개
    // 1, 2 레벨 평가된 문제 31개
    // 2레벨로 확실히 평가된 문제 97개
    // 2레벨, 3레벨로 평가된 문제 95개
    // 3레벨로 확실히 평가된 문제 24개

    static List<Integer> C = new ArrayList<>();
    static List<Integer> D = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            C = new ArrayList<>();
            D = new ArrayList<>();

            for (int j = 0; j < (2 * N - 1); j++) {
                if (j % 2 == 0) {
                    C.add(Integer.parseInt(st.nextToken()));
                } else {
                    D.add(Integer.parseInt(st.nextToken()));
                }
            }

            System.out.println(binarySearch(0, (long) Math.pow(2 * 10, 12.0)));

            // 1, 2, 3 먼저 처리 // 가장 작은 값 처리


        }


    }

    private static long binarySearch(long start, long end) {

        if (start == end) return start;
        long mid = (start + end) / 2;

        if (test(mid)) {
            return binarySearch(mid, end);
        } else {
            System.out.println(mid);
            return binarySearch(start, mid - 1);
        }
    }

    private static boolean test(long mid) {
        long[] S = new long[N];
        S[0] = C.get(0);
        for (int i = 0; i < N - 1; i++) {
            if (S[i] >= mid) {
                S[i + 1] = C.get(i + 1)  + D.get(i);
            } else if (S[i] + D.get(i) >= mid) {
                S[i + 1] = C.get(i + 1) + (S[i] + D.get(i) - mid);
            } else {
                return false;
            }
        }
        if (S[N - 1] >= mid) return true;
        else return false;
    }


}
