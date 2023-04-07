import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 폴리오미노 {
    // 'AAAA' 'BB' -> 4, 2
    // X 개수 -> 홀수면 -1 return
    // 2의 배수 - 4, 6, 8, 10, 12, 14
    // 4의 배수면 전부 A
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replaceAll("XXXX", "AAAA");
        s = s.replaceAll("XX", "BB");
        if (s.contains("X")) {
            s = "-1";
        }
        System.out.println(s);
    }
}
