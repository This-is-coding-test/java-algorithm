import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> waitList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            waitList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(waitList);

        int total = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            time += waitList.get(i);
            total += time;
        }

        System.out.println(total);


    }
}
