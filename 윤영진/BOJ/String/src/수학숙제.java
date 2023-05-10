import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> list = new ArrayList<>();

        while (N-- > 0) {
            String s = br.readLine();
            int idx = 0;
            while (idx < s.length()) {
                StringBuilder tmp = new StringBuilder();

                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    tmp.append(s.charAt(idx));
                    idx++;
                }
                if (!tmp.toString().isEmpty()) {
                    list.add(new BigInteger(tmp.toString()));
                }
                idx++;
            }
        }
        list.sort(null);
        for (BigInteger x : list) {
            System.out.println(x);
        }
    }
}
