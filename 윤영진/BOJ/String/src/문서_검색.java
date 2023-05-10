import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 문서_검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s1);

        while (sb.toString().contains(s2)) {
            int idx = sb.toString().indexOf(s2);
            sb.delete(0, idx + s2.length());
            cnt++;
        }
        System.out.println(cnt);

    }


}