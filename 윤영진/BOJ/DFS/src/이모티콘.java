import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이모티콘 {

    // 영선이는 효빈이에게 스마일 이모티콘 S개 보내려고 한다.
    // 영선이는 이미 화면에 이모티콘 1개를 입력
    // 이제 다음과 같은 3가지 연산만 사용해서 이모티콘 S개 만들어 보려고 한다.

    // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장 // 복사
    // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다. // 붙여넣기
    // 3. 화면에 있는 이모티콘 중 하나를 삭제한다. // 삭제

    // 모든 연산은 1초
    // 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기

    static class EmoInfo {
        int screenEmoCnt;
        int clipEmoCnt;

        public EmoInfo(int screenEmoCnt, int clipEmoCnt) {
            this.screenEmoCnt = screenEmoCnt;
            this.clipEmoCnt = clipEmoCnt;
        }
    }

    static int S;
    static Queue<EmoInfo> queue = new LinkedList<>();
    static boolean[][] visited = new boolean[1001][1001];
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        queue.offer(new EmoInfo(1, 0));
        visited[1][0] = true;

        BFS();
        System.out.println(time);

    }

    private static void BFS() {

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {
                EmoInfo emo = queue.poll();
                int sc = emo.screenEmoCnt;
                int cc = emo.clipEmoCnt;

                if (sc == S) {
                    return;
                }

                // 복사 -> 클립보드가 비어있는 상태에는 붙여넣기 할 수 없다.
                if (sc > 0 && sc <= 1000 && !visited[sc][sc]) {
                    visited[sc][sc] = true;
                    queue.offer(new EmoInfo(sc, sc));
                }

                // 붙여넣기
                if (cc > 0 && (sc + cc) <= 1000 && !visited[sc + cc][cc]) {
                    visited[sc + cc][cc] = true;
                    queue.offer(new EmoInfo(sc + cc, cc));
                }

                // 삭제
                if (sc - 1 >= 0 && !visited[sc - 1][cc]) {
                    visited[sc - 1][cc] = true;
                    queue.offer(new EmoInfo(sc - 1, cc));
                }

            }
            time++;
        }
    }
}
