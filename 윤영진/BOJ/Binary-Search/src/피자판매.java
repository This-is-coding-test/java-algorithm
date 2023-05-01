import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 피자판매 {
    // 고객이 두 종류의 피자 A와 B를 취급하는 피자가게에서 피자를 주문하고자 한다.
    // 각 종류의 피자는 다양한 크기의 여러 개의 피자조각으로 나누어져 있다.

    // 고객이 원하는 피자의 크기를 이야기하면, 피자가게에서는 한 종류의 피자를 2 조각 이상 판매할 때는 반드시 연속된 조각들을 잘라서 판매한다.
    // 이때 판매한 피자조각의 크기 합이 주문한 크기가 되어야 한다.
    // 판매한 피자조각은 모두 A종류이거나, 모두 B종류이거나, 또는 A와 B종류가 혼합될 수 있다.

    static int w;
    static int m, n;
    static int[] pizzaA;
    static int[] pizzaB;
    static boolean[] check;
    static ArrayList<Integer> AList = new ArrayList<>();
    static ArrayList<Integer> BList = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        w = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        pizzaA = new int[m];
        pizzaB = new int[n];

        for (int i = 0; i < m; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            //체크 배열 초기화
            check = new boolean[m];
            //첫번째 조각 담기
            check[i] = true;
            getSum(pizzaA[i], i, i + 1, check, pizzaA, AList);
        }

        for (int i = 0; i < n; i++) {
            //체크 배열 초기화
            check = new boolean[n];
            //첫번째 조각 담기
            check[i] = true;
            getSum(pizzaB[i], i, i + 1, check, pizzaB, BList);
        }
        AList.add(0);
        BList.add(0);

        Collections.sort(AList);
        Collections.sort(BList);

        binarySearch();
        System.out.println(result);


    }

    private static void binarySearch() {
        int left = 0;
        int right = BList.size() - 1;

        while (left < AList.size() && right >= 0) {
            int lv = AList.get(left);
            int rv = BList.get(right);

            if (lv + rv == w) {
                int lc = 0;
                int rc = 0;

                while (left < AList.size() && AList.get(left) == lv) {
                    lc++;
                    left++;
                }

                while (right >= 0 && BList.get(right) == rv) {
                    rc++;
                    right--;
                }
                result += (lc * rc);

            } else if (lv + rv < w) {
                left++;
            } else {
                right--;
            }
        }


    }

    private static void getSum(int sum, int startIdx, int idx, boolean[] check, int[] arr, ArrayList<Integer> list) {
        if (idx == arr.length) idx = 0;

        if (sum <= w) list.add(sum);

        // 아직 안 담은 피자조각에 대해서만 && 순환 방지
        if (check[idx] == false && sum <= w && idx != startIdx - 1) {
            check[idx] = true;
            getSum(sum + arr[idx], startIdx, idx + 1, check, arr, list);
        } else {
            return;
        }

    }
}
