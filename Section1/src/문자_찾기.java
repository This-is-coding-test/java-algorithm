import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class 문자_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine().toLowerCase(Locale.ROOT);
        Character c = br.readLine().toLowerCase(Locale.ROOT).charAt(0);

        int answer = 0;
        for (char x : st.toCharArray()) {
            if (x == c) answer++;
        }
        System.out.println(answer);

    }
}
