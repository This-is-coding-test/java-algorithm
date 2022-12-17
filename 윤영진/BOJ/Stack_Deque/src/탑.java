import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 탑 {
    // 레이저를 이용한 새로운 비밀 통신 시스템 개발
    // 실험을 위해 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고, 각 팀의 꼭대기에 레이저 송신기를 설치

    // 모든 탑의 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사
    // 탑의 기둥 모두에는 레어저 신호를 수신하는 장치가 설치
    // 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능

    static class Top {
        int idx;
        int tall;

        public Top(int idx, int tall) {
            this.idx = idx;
            this.tall = tall;
        }
    }

    static int N;
    static Stack<Top> topStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!topStack.isEmpty()) {
                if (topStack.peek().tall > top) {
                    System.out.print(topStack.peek().idx + " ");
                    break;
                }
                topStack.pop();
            }
            if (topStack.isEmpty()) {
                System.out.print("0 ");
            }
            topStack.push(new Top(i, top));
        }


    }
}
