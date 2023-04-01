import java.util.*;

class 경고_메일 {
    // 직원들은 하루동안 보안실을 이용한 총 시간이 특정시간을 넘기면 경고 메일을 받는다.

    static class Info {
        String name;
        int min;
        String type;

        public Info(String name, int min, String type) {
            this.name = name;
            this.min = min;
            this.type = type;
        }
    }

    public String[] solution(String[] reports, int time) {
        String[] answer;
        ArrayList<Info> infoList = new ArrayList<>();

        for (String report : reports) {
            String[] tmp = report.split(" ");
            String name = tmp[0];
            int min = getTime(tmp[1]);
            String type = tmp[2];

            infoList.add(new Info(name, min, type));
        }

        HashMap<String, Integer> prev = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        for (Info info : infoList) {
            String type = info.type;
            String name = info.name;

            if (type.equals("in")) {
                prev.put(name, info.min);
            } else {
                int min = prev.get(name);
                total.put(name, total.getOrDefault(name, 0) + info.min - min);
            }
        }

        List<String> results = new ArrayList<>();
        for (String name : total.keySet()) {
            if(total.get(name) > time) {
                results.add(name);
            }
        }
        Collections.sort(results, new Comparator<>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        answer = new String[results.size()];
        for(int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }

    private int getTime(String hour) {
        String[] tmp = hour.split(":");
        int h = Integer.parseInt(tmp[0]) * 60;
        int m = Integer.parseInt(tmp[1]);
        return h + m;
    }

    public static void main(String[] args) {
        경고_메일 T = new 경고_메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}