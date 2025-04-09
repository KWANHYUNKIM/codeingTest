import java.util.*;
import java.io.*;

public class p5464 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 주차 공간의 수
        int M = Integer.parseInt(input[1]); // 차량의 수

        // 각 주차공간의 단위 무게당 요금을 1번부터 N번까지 1-indexed 배열에 저장
        int[] rate = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rate[i] = Integer.parseInt(br.readLine());
        }

        // 각 차량의 무게를 1-indexed 배열에 저장 (차량 번호: 1 ~ M)
        int[] weight = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        // 주차장에 남아있는 주차 공간 번호를 관리하는 PriorityQueue (번호가 작은 순서부터 할당)
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            available.add(i);
        }

        // 주차 공간을 기다리는 차량들을 저장할 큐 (도착 순서대로 주차)
        Queue<Integer> waiting = new LinkedList<>();

        // 각 차량이 할당받은 주차 공간 번호 저장 (1-indexed, 차량 번호: 1 ~ M)
        int[] parkedSpot = new int[M + 1];

        int total = 0; // 총 매출

        // 2*M 개의 주차장 출입 이벤트 처리 (양수: 차량 입차, 음수: 차량 출차)
        for (int i = 0; i < 2 * M; i++) {
            int car = Integer.parseInt(br.readLine());
            if (car > 0) {  // 차량 입차
                if (!available.isEmpty()) {
                    int spot = available.poll();    // 번호가 가장 작은 주차 공간 할당
                    parkedSpot[car] = spot;
                    total += rate[spot] * weight[car];
                } else {
                    // 빈 공간이 없으면 대기 큐에 추가 (도착한 순서대로 대기)
                    waiting.add(car);
                }
            } else {  // 차량 출차 (음수값, -car)
                car = -car;
                int freedSpot = parkedSpot[car];
                available.add(freedSpot);           // 주차 공간을 비움

                // 만약 대기하는 차량이 있다면 즉시 주차 공간 할당
                if (!waiting.isEmpty() && !available.isEmpty()) {
                    int waitingCar = waiting.poll();
                    int spot = available.poll();
                    parkedSpot[waitingCar] = spot;
                    total += rate[spot] * weight[waitingCar];
                }
            }
        }
        System.out.println(total);
    }
}
