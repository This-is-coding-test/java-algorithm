import java.util.*;

class 문서_도난 {
    static class Person {
        String name;
        int sec;

        public Person(String name, int sec) {
            this.name = name;
            this.sec = sec;
        }
    }

    public String[] solution(String[] reports, String times) {
        String[] answer = {};
        ArrayList<Person> personList = new ArrayList<>();
        for (String report : reports) {
            String[] tmp = report.split(" ");
            String name = tmp[0];
            String[] time = tmp[1].split(":");
            int sec = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60;

            personList.add(new Person(name, sec));
        }
        personList.sort(Comparator.comparingInt(p -> p.sec));

        String[] tmp = times.split(" ");
        String[] start = tmp[0].split(":");
        String[] end = tmp[1].split(":");

        int startSec = Integer.parseInt(start[0]) * 3600 + Integer.parseInt(start[1]) * 60;
        int endSec = Integer.parseInt(end[0]) * 3600 + Integer.parseInt(end[1]) * 60;

        ArrayList<Person> results = new ArrayList<>();
        for (Person p : personList) {
            if (startSec <= p.sec && endSec >= p.sec) {
                results.add(p);
            }
        }
        answer = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i).name;
        }

        return answer;
    }

    public static void main(String[] args) {
        문서_도난 T = new 문서_도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}