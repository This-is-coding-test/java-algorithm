import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 가장_짧은_문자거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        char c = s[1].charAt(0);
        String st = s[0];
        s[0].indexOf(c);
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == c) idx.add(i);
        }

        for (int i = 0; i < st.length(); i++) {

            if (st.charAt(i) == c) System.out.print(0 + " ");

            else {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < idx.size(); j++) {

                    if (min > Math.abs(i - idx.get(j))) {
                        min = Math.abs(i - idx.get(j));
                    }
                }
                System.out.print(min + " ");
            }

        }
    }
}
