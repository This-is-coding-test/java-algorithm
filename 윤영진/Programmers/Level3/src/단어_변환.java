import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어_변환 {
    static int time = 0;
    static Set<String> visited = new HashSet<>();
    static Queue<String> queue = new LinkedList<>();
    static int size;
    static String[] word;

    public static int solution(String begin, String target, String[] words) {

        word = words;
        size = words.length;
        visited.add(begin);
        queue.offer(begin);

        bfs(target);


        return time;
    }

    private static void bfs(String target) {

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return;
                visited.add(cur);

                for (int k = 0; k < size; k++) {
                    if (!visited.contains(word[k]) && isPossible(cur, word[k])) {
                        queue.offer(word[k]);
                    }
                }
            }
            time++;
        }

    }

    private static boolean isPossible(String s1, String s2) {
        int cnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    }
}
