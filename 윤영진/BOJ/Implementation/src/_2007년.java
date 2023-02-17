import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class _2007년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = 0;

        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < m; i++) {
            n += months[i];
        }
        n += d - 1;

        System.out.println(days[n % 7]);

//        LocalDate date = LocalDate.of(2007, m, d);
//        DayOfWeek dayOfWeek = date.getDayOfWeek();
//        String day = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
//        System.out.println(day.toUpperCase());
    }
}
