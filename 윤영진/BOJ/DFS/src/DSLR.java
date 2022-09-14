import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DSLR {
    static char[] out;
    static String dslr = "DSLR";
    static StringBuilder sb = new StringBuilder();
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String to = st.nextToken();
            String from = st.nextToken();
            check = false;

            for (int j = 1; j <= 4; j++) {
                char[] out = new char[j];
                permutation(0, j, to, from, out);
            }
        }
        String tmp = "0";
        // 0 -> 


        System.out.println(sb);


    }

    private static void permutation(int L, int end, String to, String from, char[] output) {

        if (check) return;
        if (L == end) {
            String command = "";
            for (char x : output) {
                command += x;
                if (x == 'D') {
                    to = com1(to);
                } else if (x == 'S') {
                    to = com2(to);
                } else if (x == 'L') {
                    to = com3(to);
                } else {
                    to = com4(to);
                    // 0010 -> 0001 -> 1000
                }


                if (Integer.parseInt(to) == Integer.parseInt(from)) {
                    sb.append(command).append("\n");
                    check = true;
                    return;
                }

            }
        } else {
            for (int i = 0; i < 4; i++) {
                output[L] = dslr.charAt(i);
                permutation(L + 1, end, to, from, output);
            }
        }

    }

    private static String com4(String to) {
        // to = 123 == 0123 -> 3012 // length =3 ,
        String sub1 = "";
        String sub2 = "";

        if (to.length() != 4) {
            sub1 = to.substring(to.length() - 1);
            sub2 = to.substring(0, to.length() - 1); // 012
        } else {
            sub1 = to.substring(3, 4);
            sub2 = to.substring(0, 3);
        }
        while (sub2.length() != 3) {
            sub2 = "0" + sub2;
        }
        return sub1 + sub2;

    }
    // 0010 -> 0001 -> 1000

    private static String com3(String to) {

        // 0010 -> 0100
        // 0123 -> 1230
        // 1234 -> 2341
        String sub1 = "";
        String sub2 = "";
        if (to.length() != 4) {
            sub1 = to; // 123
            sub2 = "0";
        } else {
            sub1 = to.substring(1);
            sub2 = to.substring(0, 1);
        }
        while (sub1.length() != 3) {
            sub1 = "0" + sub1;
        }
        return sub1 + sub2;

    }

    private static String com2(String to) {
        int temp = Integer.parseInt(to) - 1;

        if (temp == -1) {
            return "9999";
        }
        return String.valueOf(temp);
    }

    private static String com1(String to) {

        int temp = Integer.parseInt(to) * 2;

        if (temp > 9999) {
            return String.valueOf(temp % 10000);
        }
        return String.valueOf(temp);

    }
}
