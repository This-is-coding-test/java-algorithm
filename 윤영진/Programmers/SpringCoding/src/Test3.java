import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3 {
    // 1. 게임은 턴제로 진행 -> 두명
    // 2. 초기에 0이상 9이하의 정수가 들어있는 배열 -> 양 플레이어는 하나의 배열을 공유
    // 3. 각 플레이어는 자신의 턴이 되면 다음과 같은 행동
    // 3-1. 배열에서 0이 아닌 수를 고른ㄴ다.
    // 3-2. 고른 수에서 1을 뺀다.
    // 4. 3번 행동을 통해 배열을 팰린드롬으로 만들면 승리
    // 5. 팰린드롬이 되지 않았다면 상대방에게 턴이 넘어가며, 2~4번 반복

    // 메모리제이션 문제
    // 1 4 3 -> 1. 1 3 3 -> 2. 1 2 3 -> 1. 1 1 3 -> 2. 0 1 3
    static int[][] dp = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    }
}
