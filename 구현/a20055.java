import java.util.*;
import java.io.*;

public class a20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int size = 2 * N;

        int[] durability = new int[size]; // 벨트 내구도
        boolean[] robots = new boolean[size]; // 로봇 위치
        String[] beltInput = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            durability[i] = Integer.parseInt(beltInput[i]);
        }

        int step = 0; // 진행된 단계 수

        while (true) {
            step++;

            // 1. 벨트 회전
            rotate(durability, robots, size);

            // 2. 로봇 이동
            moveRobots(durability, robots, N);

            // 3. 로봇 올리기
            placeRobot(durability, robots);

            // 4. 내구도 0인 칸 개수 확인
            if (countZeroDurability(durability) >= K) {
                break;
            }
        }

        System.out.println(step);
    }

    // 벨트와 로봇 회전
    private static void rotate(int[] durability, boolean[] robots, int size) {
        // 내구도 회전
        int lastDurability = durability[size - 1];
        System.arraycopy(durability, 0, durability, 1, size - 1);
        durability[0] = lastDurability;

        // 로봇 회전
        for (int i = size - 2; i >= 0; i--) {
            robots[i + 1] = robots[i];
        }
        robots[0] = false; // 올리는 위치 초기화
        robots[size / 2 - 1] = false; // 내리는 위치에서 로봇 제거
    }

    // 로봇 이동
    private static void moveRobots(int[] durability, boolean[] robots, int N) {
        for (int i = N - 2; i >= 0; i--) { // 내리는 위치 바로 앞부터 처리
            if (robots[i] && !robots[i + 1] && durability[i + 1] > 0) {
                robots[i] = false;
                robots[i + 1] = true;
                durability[i + 1]--;
            }
        }
        robots[N - 1] = false; // 내리는 위치에서 로봇 제거
    }

    // 로봇 올리기
    private static void placeRobot(int[] durability, boolean[] robots) {
        if (durability[0] > 0) {
            robots[0] = true;
            durability[0]--;
        }
    }

    // 내구도 0인 칸 개수 확인
    private static int countZeroDurability(int[] durability) {
        int count = 0;
        for (int d : durability) {
            if (d == 0) {
                count++;
            }
        }
        return count;
    }
}
