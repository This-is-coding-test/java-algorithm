import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 탑 {
    // 통신 시스템 개발
    // 일직선 위에 N개의 높이가 (서로 다른) 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례대로 세우고, 각 탑의 꼭대기에 레이저 송신기
    // 모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평평하게 수평 직선의 왼쪽 방향으로 발사
    // 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능
    // 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지 알아내라

    static class Top {
        int n, tall;

        public Top(int n, int tall) {
            this.n = n;
            this.tall = tall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Top> tops = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tops.add(new Top(i, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            Top t = tops.get(i);
            while (!stack.isEmpty() && stack.peek().tall < t.tall) {
                stack.pop();
            }
            if (stack.isEmpty()) sb.append(0).append(" ");
            else sb.append(stack.peek().n).append(" ");
            stack.push(t);
        }
        System.out.println(sb);


    }
}
