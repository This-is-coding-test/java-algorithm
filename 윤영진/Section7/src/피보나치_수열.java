import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수열 {

    // 피보나치는 배열과 재귀 두 가지 모두 구현해보라는 코딩인터뷰가 진행될 수 있다.
    // 배열이 재귀보다 성능이 좋다 -> 재귀는 스택프레임으로 인해 무겁고 메모리 낭비도 심하다.
   static int[] arr = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 1;

        DP(N);
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int DP(int n) {
        if (arr[n] != 0) return arr[n];

        if (n == 1) {
            return arr[1];
        } else if (n == 2) return arr[2];
        else {
            return arr[n] = DP(n - 1) + DP(n - 2);
        }
    }

    // 아래 단순 재귀, 단순 배열 활용 메서드 중에는 배열을 활용한 것이 낫다.
    private static int recursive(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    private static int arr(int n) {
        if (n == 1) {
            return arr[1];
        } else if (n == 2) return arr[2];
        else {
            return arr[n] = arr(n - 1) + arr(n - 2);
        }
    }


}
