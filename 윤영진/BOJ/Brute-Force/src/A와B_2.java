import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A와B_2 {

    // AB -> BA
    // BAB -> BAB
    // BABA

    static String S, T;
    static Queue<String> queue = new LinkedList<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        visited.add(T);
        queue.offer(T);

        bfs();
        if (visited.contains(S)) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            String now = queue.poll();
            if (now.length() == S.length()) return;

            // A 추가한 경우
            String s1 = now.substring(0, now.length() - 1);
            if (now.charAt(now.length() - 1) == 'A' && !visited.contains(s1)) {
                visited.add(s1);
                queue.offer(s1);
            }

            // B 추가한 경우
            StringBuilder sb = new StringBuilder(now.substring(1));
            String s2 = sb.reverse().toString();
            if (now.charAt(0) == 'B' && !visited.contains(s2)) {
                visited.add(s2);
                queue.offer(s2);
            }

        }

    }
}
