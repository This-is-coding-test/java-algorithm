import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 단어_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }

        for (String string : strings) {

            StringBuffer sb = new StringBuffer(string);
            System.out.println(sb.reverse());

        }

    }


}
