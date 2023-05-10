import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잠수함식별 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String pattern = "^(100+1+|01)+$";

        System.out.println(s.matches(pattern) ? "SUBMARINE" : "NOISE");


    }
}
