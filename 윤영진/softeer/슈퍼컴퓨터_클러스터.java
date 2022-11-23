package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 슈퍼컴퓨터_클러스터 {

    // 클러스터의 성능은 컴퓨터의 수가 많아질 수록, 각각의 성능이 올라갈 수록 향상된다.
    // 클러스터의 성능을 업그레이드해 달라는 요청을 보내 왔다.
    // 클러스터를 이루는 각각의 컴퓨터 중 성능이 가장 낮은 컴퓨터의 성능이 병목이 된다고 알려 왔다.

    // 이 클러스터에는 N대의 컴퓨터가 있으며, 각각의 성능은 aj라는 점수로 평가할 수 있다.
    // 각각의 컴퓨터에 비용을 들여 업그레이드를 진행할 수 있다.
    // 성능을 d만큼 향상시키는 데에 드는 비용은 d^2원이다.

    // 업그레이드를 진행하지 않아도 되지만, 한 컴퓨터에 두 번 이상 업그레이드를 수행할 수는 없다.
    // 업그레이드를 위한 예산이 B원 책정되어 있다. B원 이하의 총 비용으로 업그레이드를 수행하여, 성능이 가장 낮은 컴퓨터의 성능을 최대화하는 것이 목표

    static int N, B;
    static int[] arr;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = binarySearch();

        if (answer == 0) System.out.println(result);
        else {
            System.out.println(answer);
        }


    }

    private static int binarySearch() {
        int left = 0;
        int right = 2000000000;

        while (left <= right) {
            int mid = (left + right) / 2;
            long check = check(mid);

            if (check == B) {
                return mid;
            }
            else if (check > B) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return 0;


    }

    private static long check(int target) {
        long total = 0L; // target == 4 -> target == 5

        for (int i = 0; i < N; i++) {
            if (target > arr[i]) {
                total += Math.pow(target - arr[i], 2);
            }
            if (total > B) break;
        }

        return total;
    }
}
