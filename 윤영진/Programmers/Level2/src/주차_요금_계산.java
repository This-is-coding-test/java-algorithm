import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 주차_요금_계산 {
    class Car {
        String num;
        int amount;

        public Car (String num, int amount) {
            this.num = num;
            this.amount = amount;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        int defT = fees[0]; // 기본 시간(분)
        int defM = fees[1]; // 기본 요금(원)
        int unitT = fees[2]; // 단위 시간(분)
        int unitM = fees[3]; // 단위 요금(원)

        HashMap<String, Integer> amount = new HashMap<>(); // 차량별 누적 시간
        HashMap<String, Integer> carMap = new HashMap<>();

        for (String record : records) {
            String[] tmp = record.split(" ");
            int t = getTime(tmp[0]);
            String carN = tmp[1];
            String type = tmp[2];

            if (type.equals("IN")) {
                carMap.put(carN, t);
            } else {
                int prevT = carMap.get(carN);
                amount.put(carN, amount.getOrDefault(carN, 0) + (t - prevT));
                carMap.remove(carN);
            }
        }
        // 출차안된 차량
        int endT = getTime("23:59");

        for (String carN : carMap.keySet()) {
            int prevT = carMap.get(carN);
            amount.put(carN, amount.getOrDefault(carN, 0) + (endT - prevT));
        }

        // 계산
        ArrayList<Car> carList = new ArrayList<>();
        for (String car : amount.keySet()) {
            int t = amount.get(car);

            if (t <= defT) {
                carList.add(new Car(car, defM));
            } else {
                int unit = (t - defT) / unitT;
                if ((t - defT) % unitT != 0) unit++;
                int total = defM + unit* unitM;
                carList.add(new Car(car, total));
            }
        }
        Collections.sort(carList, (o1, o2) -> o1.num.compareTo(o2.num));
        int[] answer = new int[carList.size()];

        for (int i = 0; i < carList.size(); i++) {
            answer[i] = carList.get(i).amount;
        }

        return answer;
    }

    public int getTime(String s) {
        String[] tmp = s.split(":");

        int h = Integer.parseInt(tmp[0]) * 60;
        int m = Integer.parseInt(tmp[1]);

        return h + m;
    }
}
