import java.util.*;
import java.io.*;

class Lecture {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class a1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);
            lectures.add(new Lecture(start, end));
        }
        lectures.sort(Comparator.comparingInt(lecture -> lecture.start));

        // 우선순위 큐 (최소 힙): 강의 종료 시간 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 강의실 배정
        for (Lecture lecture : lectures) {
            // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의실보다 크거나 같으면 재사용 가능
            if (!pq.isEmpty() && pq.peek() <= lecture.start) {
                pq.poll(); // 기존 강의실에서 강의 종료 시간 제거
            }
            pq.add(lecture.end); // 새로운 강의 종료 시간 추가
        }

        // 최소 강의실 개수 출력
        System.out.println(pq.size());
    }
}

