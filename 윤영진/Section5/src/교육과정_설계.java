import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 교육과정_설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();

        Set<Character> set = new HashSet<>();

        for (Character x : st1.toCharArray()) {
            set.add(x);
        }
        String st3 = "";
        for (int i = 0; i < st2.length(); i++) {
            if (set.contains(st2.charAt(i))) {
                st3 += st2.charAt(i);
            }
        }
        System.out.print(st1.equals(st3) ? "YES" : "NO");

    }
}
